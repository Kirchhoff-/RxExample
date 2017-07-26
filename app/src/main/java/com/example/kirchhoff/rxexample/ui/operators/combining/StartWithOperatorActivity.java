package com.example.kirchhoff.rxexample.ui.operators.combining;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class StartWithOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, StartWithOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        startWithExample();
    }

    @Override
    protected String getTag() {
        return StartWithOperatorActivity.class.getName();
    }

    private void startWithExample() {
        Observable.just(generateInt(10), generateInt(10), generateInt(10))
                .startWithArray(-5, -4, -3, -2, -1, 0)
                .subscribe(getIntObserver());
    }
}
