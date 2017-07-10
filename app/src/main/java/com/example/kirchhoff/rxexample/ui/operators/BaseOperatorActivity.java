package com.example.kirchhoff.rxexample.ui.operators;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.kirchhoff.rxexample.R;

import java.util.Random;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * @author Kirchhoff-
 */

public abstract class BaseOperatorActivity extends AppCompatActivity {

    private final CompositeDisposable disposables = new CompositeDisposable();
    private TextView textView;
    private Random generator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_base);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(view -> operatorExample());

        generator = new Random();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }

    protected abstract void operatorExample();

    protected abstract String getTag();

    protected int generateInt(int maxValue) {
        return generator.nextInt(maxValue);
    }

    protected void writeToConsole(@Nullable String value) {
        textView.append(value);
    }

    protected void writeToScreen(@Nullable String value) {
        Log.d(getTag(), value);
    }

    @NonNull
    protected CompositeDisposable getDisposable() {
        return disposables;
    }

    protected Observer<String> getStringObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(getTag(), " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(String value) {
                textView.append(" onNext : value : " + value);
                textView.append("\n");
                Log.d(getTag(), " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append("\n");
                Log.d(getTag(), " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append("\n");
                Log.d(getTag(), " onComplete");
            }
        };
    }

    protected Observer<Integer> getIntObserver() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(getTag(), " First onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(Integer value) {
                textView.append(" First onNext : value : " + value);
                textView.append("\n");
                Log.d(getTag(), " First onNext value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" First onError : " + e.getMessage());
                textView.append("\n");
                Log.d(getTag(), " First onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" First onComplete");
                textView.append("\n");
                Log.d(getTag(), " First onComplete");
            }
        };
    }

    protected Observer<Long> getLongObserver() {
        return new Observer<Long>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(getTag(), " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(Long value) {
                textView.append(" onNext : value : " + value);
                textView.append("\n");
                Log.d(getTag(), " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append("\n");
                Log.d(getTag(), " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append("\n");
                Log.d(getTag(), " onComplete");
            }
        };
    }

    protected DisposableObserver<Long> getLongDisposableObserver() {
        return new DisposableObserver<Long>() {
            @Override
            public void onNext(Long value) {
                textView.append(" onNext : value : " + value);
                textView.append("\n");
                Log.d(getTag(), " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append("\n");
                Log.d(getTag(), " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append("\n");
                Log.d(getTag(), " onComplete");
            }
        };
    }
}
