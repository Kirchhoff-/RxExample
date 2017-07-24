package com.example.kirchhoff.rxexample.ui.operators.filtering;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.creating.DeferOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class ElementAtOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, ElementAtOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        elementAtExample();
    }

    @Override
    protected String getTag() {
        return DeferOperatorActivity.class.getName();
    }

    private void elementAtExample() {
        Observable.fromArray(generateInt(100), generateInt(100), generateInt(100),
                generateInt(100), generateInt(100)).elementAt(3).subscribe(integer -> {
            writeToConsole(integer.toString());
            writeToScreen(integer.toString());
        });
    }
}
