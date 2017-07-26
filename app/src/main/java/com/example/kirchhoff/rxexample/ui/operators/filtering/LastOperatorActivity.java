package com.example.kirchhoff.rxexample.ui.operators.filtering;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class LastOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, LastOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        lastExample();
    }

    @Override
    protected String getTag() {
        return LastOperatorActivity.class.getName();
    }

    private void lastExample() {
        Observable.just("Value1", "Value2", "Value3", "Value4", "Value5", "Value6", "Value7")
                .last("Default Value")
                .subscribe(getSingleObserver());
    }
}
