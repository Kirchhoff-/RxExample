package com.example.kirchhoff.rxexample.ui.operators.conditional;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class SkipWhileOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Context context) {
        Intent intent = new Intent(context, SkipWhileOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        skipWhileExample();
    }

    @Override
    protected String getTag() {
        return SkipWhileOperatorActivity.class.getName();
    }

    private void skipWhileExample() {
        Observable.range(0, 100)
                .skipWhile(i -> i < 75)
                .subscribe(getIntObserver());
    }
}
