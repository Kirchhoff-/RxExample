package com.example.kirchhoff.rxexample.ui.operators.filtering;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class FilterOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, FilterOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        filterExample();
    }

    @Override
    protected String getTag() {
        return FilterOperatorActivity.class.getName();
    }

    private void filterExample() {
        /*Observable.just(1,2,3,4,5,6).filter(new Predicate<Integer>() {
            @Override
            public boolean test(@NonNull Integer integer) throws Exception {
                return integer % 2 == 1;
            }
        }).subscribe(getObserver()); */

        Observable.just(1, 2, 3, 4, 5, 6).filter(integer -> integer % 2 == 1)
                .subscribe(getIntObserver());
    }
}
