package com.example.kirchhoff.rxexample.ui.operators.conditional;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class SkipUntilOperatorActivity extends BaseOperatorActivity {


    public static void startMe(Context context) {
        Intent intent = new Intent(context, SkipUntilOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        skipUntilExample();
    }

    @Override
    protected String getTag() {
        return SkipUntilOperatorActivity.class.getName();
    }

    private void skipUntilExample() {
        Observable.interval(2, TimeUnit.SECONDS).take(10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .skipUntil(Observable.interval(5, TimeUnit.SECONDS))
                .subscribe(getLongObserver());
    }
}
