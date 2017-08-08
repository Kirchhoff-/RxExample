package com.example.kirchhoff.rxexample.ui.operators.mathematical;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import rx.Observable;
import rx.observables.MathObservable;

/**
 * @author Kirchhoff-
 */

public class AverageOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, AverageOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        MathObservable.averageInteger(Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .subscribe(integer -> {
                    writeToConsole(integer.toString());
                    writeToScreen(integer.toString());
                    writeToScreen("\n");
                });

        MathObservable.averageFloat(Observable.just(1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f))
                .subscribe(aFloat -> {
                    writeToConsole(aFloat.toString());
                    writeToScreen(aFloat.toString());
                    writeToScreen("\n");
                });

    }

    @Override
    protected String getTag() {
        return AverageOperatorActivity.class.getName();
    }
}
