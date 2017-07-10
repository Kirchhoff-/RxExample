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

public class RepeatWhenOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, RepeatWhenOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        repeatWhenExample();
    }

    @Override
    protected String getTag() {
        return RepeatWhenOperatorActivity.class.getName();
    }

    private void repeatWhenExample() {
        getDisposable().add(getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getLongDisposableObserver()));
    }

    private Observable<? extends Long> getObservable() {
        return Observable.just((long) generateInt(100)).repeatWhen(ob -> ob.take(5));
    }

}
