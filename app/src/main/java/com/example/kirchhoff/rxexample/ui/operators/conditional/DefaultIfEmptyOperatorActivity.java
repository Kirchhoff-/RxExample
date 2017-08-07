package com.example.kirchhoff.rxexample.ui.operators.conditional;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class DefaultIfEmptyOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, DefaultIfEmptyOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        defaultIfEmptyExample();
    }

    @Override
    protected String getTag() {
        return DefaultIfEmptyOperatorActivity.class.getName();
    }

    private void defaultIfEmptyExample() {
        Observable.empty().defaultIfEmpty(5).subscribe(o -> {
            writeToScreen(o.toString());
            writeToConsole(o.toString());
        });
    }
}
