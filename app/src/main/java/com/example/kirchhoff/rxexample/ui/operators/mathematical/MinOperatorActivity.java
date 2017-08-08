package com.example.kirchhoff.rxexample.ui.operators.mathematical;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import rx.Observable;
import rx.observables.MathObservable;

/**
 * @author Kirchhoff-
 */

public class MinOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, MinOperatorActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void operatorExample() {
        MathObservable.min(Observable.just(100, -1, 2, 4, 12))
                .subscribe(integer -> {
                    writeToConsole(integer.toString());
                    writeToScreen(integer.toString());
                    writeToScreen("\n");
                });
    }

    @Override
    protected String getTag() {
        return MinOperatorActivity.class.getName();
    }
}
