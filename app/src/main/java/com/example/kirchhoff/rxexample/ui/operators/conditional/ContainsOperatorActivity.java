package com.example.kirchhoff.rxexample.ui.operators.conditional;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class ContainsOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, ContainsOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        containsExample();
    }

    @Override
    protected String getTag() {
        return ContainsOperatorActivity.class.getName();
    }


    private void containsExample() {
        Observable.just(1, 2, 3, 4).contains(3).subscribe(aBoolean -> {
            writeToScreen(aBoolean.toString());
            writeToScreen("\n");
            writeToConsole(aBoolean.toString());
        });

        Observable.just(1, 2, 3, 4, 5).contains(7).subscribe(aBoolean -> {
            writeToScreen(aBoolean.toString());
            writeToScreen("\n");
            writeToConsole(aBoolean.toString());
        });
    }
}
