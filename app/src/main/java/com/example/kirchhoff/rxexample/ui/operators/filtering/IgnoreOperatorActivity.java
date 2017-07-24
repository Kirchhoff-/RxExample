package com.example.kirchhoff.rxexample.ui.operators.filtering;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * @author Kirchhoff-
 */

public class IgnoreOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, IgnoreOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        ignoreOperatorExample();
    }

    @Override
    protected String getTag() {
        return IgnoreOperatorActivity.class.getName();
    }

    private void ignoreOperatorExample() {
        Observable.just(true, true, false, true, false, true, false, false).ignoreElements().subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                writeToScreen("onSubscribe");
                writeToScreen("\n");
                writeToConsole("onSubscribe");
            }

            @Override
            public void onComplete() {
                writeToScreen("onComplete");
                writeToScreen("\n");
                writeToConsole("onComplete");
            }

            @Override
            public void onError(Throwable e) {
                writeToScreen("onError");
                writeToScreen("\n");
                writeToConsole("onError");
            }
        });
    }
}
