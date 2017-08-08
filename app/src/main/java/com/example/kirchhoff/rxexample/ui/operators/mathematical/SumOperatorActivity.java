package com.example.kirchhoff.rxexample.ui.operators.mathematical;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import rx.Observable;
import rx.observables.MathObservable;

/**
 * @author Kirchhoff-
 */

public class SumOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, SumOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        MathObservable.sumInteger(Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .subscribe(integer -> {
                    writeToConsole(integer.toString());
                    writeToScreen(integer.toString());
                    writeToScreen("\n");
                });


        MathObservable.sumFloat(Observable.just(1.9f, 2.8f, 3.7f, 4.6f, 5.5f, 6.4f, 7.3f, 8.2f, 9.1f, 10f))
                .subscribe(aFloat -> {
                    writeToConsole(aFloat.toString());
                    writeToScreen(aFloat.toString());
                    writeToScreen("\n");
                });
    }

    @Override
    protected String getTag() {
        return SumOperatorActivity.class.getName();
    }
}
