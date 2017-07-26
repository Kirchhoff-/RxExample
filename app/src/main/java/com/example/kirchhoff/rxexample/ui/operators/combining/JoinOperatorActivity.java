package com.example.kirchhoff.rxexample.ui.operators.combining;

import android.annotation.SuppressLint;
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

public class JoinOperatorActivity extends BaseOperatorActivity {

    private Observable<String> ret;

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, JoinOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        joinExample();
    }

    @Override
    protected String getTag() {
        return JoinOperatorActivity.class.getName();
    }

    @SuppressLint("DefaultLocale")
    private void joinExample() {
        Observable<Long> i1 = Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> i2 = Observable.interval(300, TimeUnit.MILLISECONDS);

        Observable<Long> span1 = Observable.timer(600, TimeUnit.MILLISECONDS);
        Observable<Long> span2 = Observable.timer(0, TimeUnit.MILLISECONDS);

        ret = i1.join(i2, i -> span1, i -> span2, (ii1, ii2) ->
                String.format("%d-%d", ii1, ii2));

        getDisposable().add(ret.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    writeToConsole(s);
                    writeToScreen(s);
                    writeToScreen("\n");
                }));
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
