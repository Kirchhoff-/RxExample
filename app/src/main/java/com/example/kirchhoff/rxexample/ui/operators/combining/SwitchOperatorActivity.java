package com.example.kirchhoff.rxexample.ui.operators.combining;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class SwitchOperatorActivity extends BaseOperatorActivity {

    Observable<Observable<Long>> observable = Observable.interval(0, 500, TimeUnit.MILLISECONDS)
            .map(aLong -> Observable.interval(0, 2000, TimeUnit.MILLISECONDS)
                    .map(aLong1 -> aLong1 * 10).take(5)).take(3);

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, SwitchOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        switchExample();
    }

    @Override
    protected String getTag() {
        return StartWithOperatorActivity.class.getName();
    }

    private void switchExample() {
        Observable.switchOnNext(observable)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getLongObserver());
    }
}
