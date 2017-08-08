package com.example.kirchhoff.rxexample.ui.operators.mathematical;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import rx.Observable;

/**
 * @author Kirchhoff-
 */

public class CountOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, CountOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        Observable.just(100, 200, 300, 4000).count()
                .subscribe(integer -> {
                    writeToConsole(integer.toString());
                    writeToScreen(integer.toString());
                    writeToScreen("\n");
                });
    }

    @Override
    protected String getTag() {
        return CountOperatorActivity.class.getName();
    }
}
