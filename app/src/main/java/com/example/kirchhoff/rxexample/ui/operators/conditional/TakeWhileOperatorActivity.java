package com.example.kirchhoff.rxexample.ui.operators.conditional;

import android.content.Context;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class TakeWhileOperatorActivity extends BaseOperatorActivity {


    public static void startMe(Context context) {
        Intent intent = new Intent(context, TakeWhileOperatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        takeWhileOperatorExample();
    }

    @Override
    protected String getTag() {
        return TakeWhileOperatorActivity.class.getName();
    }

    private void takeWhileOperatorExample() {
        Observable.range(1, 100)
                .takeWhile(integer -> integer < 15).subscribe(getIntObserver());
    }
}
