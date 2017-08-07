package com.example.kirchhoff.rxexample.ui.operators.conditional;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class AllOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, AllOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        allExample();
    }

    @Override
    protected String getTag() {
        return AllOperatorActivity.class.getName();
    }

    private void allExample() {
        Observable.range(0, 10).all(integer -> integer == 0)
                .subscribe(aBoolean -> {
                    writeToConsole(aBoolean.toString());
                    writeToScreen(aBoolean.toString());
                    writeToScreen("\n");
                });


        Observable.range(0, 10).all(integer -> integer < integer + 1)
                .subscribe(aBoolean -> {
                    writeToConsole(aBoolean.toString());
                    writeToScreen(aBoolean.toString());
                    writeToScreen("\n");
                });
    }
}
