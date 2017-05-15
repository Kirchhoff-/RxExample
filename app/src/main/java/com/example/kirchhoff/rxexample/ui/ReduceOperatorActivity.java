package com.example.kirchhoff.rxexample.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.kirchhoff.rxexample.R;

import java.util.Random;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * @author Kirchhoff-
 */

public class ReduceOperatorActivity extends AppCompatActivity {

    private static final String TAG = FirstActivity.class.getName();

    private TextView textView;

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, ReduceOperatorActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_base);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(view -> reduceExample());
    }

    private int getRandomInt(int bounds) {
        return new Random().nextInt(bounds);
    }

    private void reduceExample() {
       /* getObservable().reduce(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer integer1, @NonNull Integer integer2) throws Exception {
                return integer1 + integer2;
            }
        }).subscribe(getObserver()); */

        getObservable().reduce((integer1, integer2) -> integer1 + integer2).subscribe(getObserver());
    }

    private Observable<Integer> getObservable() {
        return Observable.just(getRandomInt(100), getRandomInt(200),
                getRandomInt(300), getRandomInt(400));
    }

    private MaybeObserver<Integer> getObserver() {
        return new MaybeObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onSuccess(Integer integer) {
                textView.append(" onSuccess : value : " + integer);
                textView.append("\n");
                Log.d(TAG, " onSuccess : value : " + integer);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append("\n");
                Log.d(TAG, " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append("\n");
                Log.d(TAG, " onComplete");
            }
        };
    }
}
