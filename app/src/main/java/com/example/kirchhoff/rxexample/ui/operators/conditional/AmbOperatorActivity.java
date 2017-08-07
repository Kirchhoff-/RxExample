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

public class AmbOperatorActivity extends BaseOperatorActivity {


    public static void startMe(Context context) {
        Intent intent = new Intent(context, AmbOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        ambExample();
    }

    @Override
    protected String getTag() {
        return AmbOperatorActivity.class.getName();
    }

    private void ambExample() {
        Observable<String> source1 = Observable
                .just("data from source 1")
                .delay(generateInt(1000), TimeUnit.MILLISECONDS);

        Observable<String> source2 = Observable
                .just("data from source 2")
                .delay(generateInt(500), TimeUnit.MILLISECONDS);

        Observable<String> amb = Observable.ambArray(source2, source1);

        amb.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getStringObserver());

    }
}
