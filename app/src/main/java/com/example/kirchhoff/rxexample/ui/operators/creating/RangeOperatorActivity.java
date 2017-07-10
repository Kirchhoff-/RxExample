package com.example.kirchhoff.rxexample.ui.operators.creating;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.kirchhoff.rxexample.R;
import com.example.kirchhoff.rxexample.ui.operators.filtering.FirstOperatorActivity;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author Kirchhoff-
 */

public class RangeOperatorActivity extends AppCompatActivity {

    private static final String TAG = FirstOperatorActivity.class.getName();

    private TextView textView;

    private Random random;

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, RangeOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_base);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(view -> rangeExample());

        random = new Random();
    }

    private void rangeExample() {

        int count = generateRandomInt(1000);
        int from = generateRandomInt(1000);
        textView.append("Range");
        textView.append("\n");
        textView.append("From: " + from);
        textView.append("\n");
        textView.append("Count: " + count);
        textView.append("\n");
        Log.d(TAG, "Range");
        Log.d(TAG, "From = " + from);
        Log.d(TAG, "Count = " + count);
        Observable.range(from, count).subscribe(getObserver());
    }

    private int generateRandomInt(int max) {
        return random.nextInt(max);
    }

    private Observer<Integer> getObserver() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " First onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(Integer value) {
                textView.append(" First onNext : value : " + value);
                textView.append("\n");
                Log.d(TAG, " First onNext value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" First onError : " + e.getMessage());
                textView.append("\n");
                Log.d(TAG, " First onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" First onComplete");
                textView.append("\n");
                Log.d(TAG, " First onComplete");
            }
        };
    }

}
