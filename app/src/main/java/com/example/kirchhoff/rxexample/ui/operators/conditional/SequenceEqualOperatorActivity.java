package com.example.kirchhoff.rxexample.ui.operators.conditional;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class SequenceEqualOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, SequenceEqualOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        sequenceEqualExample();
    }

    @Override
    protected String getTag() {
        return SequenceEqualOperatorActivity.class.getName();
    }

    private void sequenceEqualExample() {
        Observable.sequenceEqual(Observable.range(0, 5), Observable.range(0, 6))
                .subscribe(aBoolean -> {
                    writeToConsole(aBoolean.toString());
                    writeToScreen(aBoolean.toString());
                    writeToScreen("\n");
                });
    }
}
