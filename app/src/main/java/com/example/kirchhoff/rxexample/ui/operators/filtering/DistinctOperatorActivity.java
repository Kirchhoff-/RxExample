package com.example.kirchhoff.rxexample.ui.operators.filtering;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class DistinctOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, DistinctOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        distinctExample();
    }

    @Override
    protected String getTag() {
        return DistinctOperatorActivity.class.getName();
    }

    private void distinctExample() {
        getObservable()
                .distinct()
                .subscribe(getIntObserver());
    }

    private Observable<Integer> getObservable() {
        return Observable.just(1, 2, 3, 4, 1, 1, 2, 7, 12, 3);
    }

}
