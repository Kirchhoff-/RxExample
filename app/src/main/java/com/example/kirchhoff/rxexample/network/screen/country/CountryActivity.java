package com.example.kirchhoff.rxexample.network.screen.country;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.kirchhoff.rxexample.R;
import com.example.kirchhoff.rxexample.databinding.ACountryBinding;

/**
 * @author Kirchhoff-
 */

public class CountryActivity extends ViewModelActivity {

    private CountryViewModel mainViewModel;

    public static void start(Context context) {
        context.startActivity(new Intent(context, CountryActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ACountryBinding binding =
                DataBindingUtil.setContentView(this, R.layout.a_country);
        binding.setViewModel(mainViewModel);
    }

    @Override
    protected ViewModel createViewModel(ViewModel.SavedState savedViewModelState) {
        mainViewModel = new CountryViewModel(savedViewModelState);
        return mainViewModel;
    }

}
