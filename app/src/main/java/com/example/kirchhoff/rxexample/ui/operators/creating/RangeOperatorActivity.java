package com.example.kirchhoff.rxexample.ui.operators.creating;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class RangeOperatorActivity extends BaseOperatorActivity {


    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, RangeOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        rangeExample();
    }

    @Override
    protected String getTag() {
        return RangeOperatorActivity.class.getName();
    }

    private void rangeExample() {

        int count = generateInt(1000);
        int from = generateInt(1000);
        writeToScreen("Range");
        writeToScreen("\n");
        writeToScreen("From: " + from);
        writeToScreen("\n");
        writeToScreen("Count: " + count);
        writeToScreen("\n");
        writeToConsole("Range");
        writeToConsole("From = " + from);
        writeToConsole("Count = " + count);
        Observable.range(from, count).subscribe(getIntObserver());
    }

}
