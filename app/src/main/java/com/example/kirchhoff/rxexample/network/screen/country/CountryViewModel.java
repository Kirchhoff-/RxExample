package com.example.kirchhoff.rxexample.network.screen.country;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;

import com.android.databinding.library.baseAdapters.BR;
import com.example.kirchhoff.rxexample.network.model.country.CountryData;
import com.example.kirchhoff.rxexample.network.rest.CountryApi;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class CountryViewModel extends ViewModel {

    private CountryApi countryApi = retrofit.create(CountryApi.class);

    private String names;

    private String ccc;

    private boolean errorEnabled = false;

    private String errorText;


    protected CountryViewModel(@Nullable SavedState savedInstanceState) {
        super(savedInstanceState);
    }

    @BindingAdapter("app:errorText")
    public static void setErrorMessage(TextInputLayout view, String errorMessage) {
        view.setError(errorMessage);
    }

    @Bindable
    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
        notifyPropertyChanged(BR.names);
    }

    @Bindable
    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
        notifyPropertyChanged(BR.ccc);
    }

    @Bindable
    public boolean getErrorEnabled() {
        return errorEnabled;
    }

    public void setErrorEnabled(boolean errorEnabled) {
        this.errorEnabled = errorEnabled;
        notifyPropertyChanged(BR.errorEnabled);
    }

    @Bindable
    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
        notifyPropertyChanged(BR.errorText);
    }

    public void onSearchClick() {
        countryApi.getRestCountriesCallingCode(getCcc())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<CountryData>>() {
                    @Override
                    public final void onCompleted() {
                    }

                    @Override
                    public final void onError(@NonNull Throwable e) {
                        setErrorText("No country found for CCC: " + getCcc());
                        setErrorEnabled(true);
                        setNames("N/A");
                    }

                    @Override
                    public final void onNext(@NonNull List<CountryData> countryDataList) {
                        setErrorText("");
                        setErrorEnabled(false);
                        Observable.from(countryDataList).map(countryData -> countryData.name)
                                .reduce((accumulator, name) -> accumulator + " - " + name)
                                .subscribe(names -> setNames(names));
                    }
                });
    }
}
