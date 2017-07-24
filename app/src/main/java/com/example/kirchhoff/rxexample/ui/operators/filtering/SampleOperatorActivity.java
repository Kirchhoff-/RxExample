package com.example.kirchhoff.rxexample.ui.operators.filtering;

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

public class SampleOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, SampleOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        sampleOperatorExample();
    }

    @Override
    protected String getTag() {
        return SampleOperatorActivity.class.getName();
    }

    private void sampleOperatorExample() {
        Observable.interval(150, TimeUnit.MILLISECONDS)
                .sample(4, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(value -> {
                    writeToConsole(value.toString());
                    writeToScreen(value.toString());
                    writeToScreen("\n");
                    writeToConsole("\n");
                });
    }
}
