package com.example.kirchhoff.rxexample.ui.operators.combining;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class CombineLatestOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, CombineLatestOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        combineLatestExample();
    }

    @Override
    protected String getTag() {
        return CombineLatestOperatorActivity.class.getName();
    }

    private void combineLatestExample() {
        Observable.combineLatest(Observable.range(10, 4), Observable.range(10, 3),
                (integer, integer2) -> integer + ":" + integer2).subscribe(getStringObserver());
    }
}
