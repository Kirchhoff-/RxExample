package com.example.kirchhoff.rxexample.ui.operators.creating;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class TimerOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, TimerOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        timerExample();
    }

    @Override
    protected String getTag() {
        return TimerOperatorActivity.class.getName();
    }

    /* Do something after 2 second */
    private void timerExample() {
        getObservable()
                //Run on a background thread
                .subscribeOn(Schedulers.io())
                //Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getLongObserver());
    }

    private Observable<? extends Long> getObservable() {
        return Observable.timer(2, TimeUnit.SECONDS)
                .flatMap(i -> Observable.just(new Random().nextLong()));
    }

}
