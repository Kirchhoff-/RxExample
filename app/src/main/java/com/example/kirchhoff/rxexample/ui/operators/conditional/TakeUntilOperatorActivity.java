package com.example.kirchhoff.rxexample.ui.operators.conditional;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class TakeUntilOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, TakeUntilOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        takeUntilExample();
    }

    @Override
    protected String getTag() {
        return TakeUntilOperatorActivity.class.getName();
    }

    private void takeUntilExample() {
        Observable.range(1, 100)
                .takeUntil(integer -> integer > 25).subscribe(getIntObserver());
    }
}
