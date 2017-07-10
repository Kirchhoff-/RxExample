package com.example.kirchhoff.rxexample.ui.operators.creating;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.kirchhoff.rxexample.R;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class RepeatOperatorActivity extends AppCompatActivity {

    private static final String TAG = RepeatOperatorActivity.class.getName();
    private final CompositeDisposable disposables = new CompositeDisposable();
    private TextView textView;
    private Random generator;

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, RepeatOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_base);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(view -> repeatExample());

        generator = new Random();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }

    private void repeatExample() {
        disposables.add(getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver()));
    }

    private Observable<? extends Long> getObservable() {
        return Observable.just((long) generator.nextInt(100)).repeat(100);
    }

    private DisposableObserver<Long> getObserver() {
        return new DisposableObserver<Long>() {
            @Override
            public void onNext(Long value) {
                textView.append(" onNext : value : " + value);
                textView.append("\n");
                Log.d(TAG, " onNext : value : " + value);
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