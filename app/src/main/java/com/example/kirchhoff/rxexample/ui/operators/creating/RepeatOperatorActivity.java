package com.example.kirchhoff.rxexample.ui.operators.creating;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class RepeatOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, RepeatOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        repeatExample();
    }

    @Override
    protected String getTag() {
        return RepeatOperatorActivity.class.getName();
    }

    private void repeatExample() {
        getDisposable().add(getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getLongDisposableObserver()));
    }

    private Observable<? extends Long> getObservable() {
        return Observable.just((long) generateInt(100)).repeat(100);
    }

}
