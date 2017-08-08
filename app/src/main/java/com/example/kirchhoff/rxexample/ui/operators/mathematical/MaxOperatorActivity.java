package com.example.kirchhoff.rxexample.ui.operators.mathematical;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import rx.Observable;
import rx.observables.MathObservable;


/**
 * @author Kirchhoff-
 */

public class MaxOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, MaxOperatorActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void operatorExample() {
        maxExample();
    }

    @Override
    protected String getTag() {
        return MaxOperatorActivity.class.getName();
    }

    private void maxExample() {
        MathObservable.max(Observable.just(1, 5, 6, 2, 3, 4)).subscribe(integer -> {
            writeToConsole(integer.toString());
            writeToScreen(integer.toString());
            writeToScreen("\n");
        });
    }
}
