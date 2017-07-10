package com.example.kirchhoff.rxexample.ui.operators;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.kirchhoff.rxexample.R;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author Kirchhoff-
 */

public abstract class BaseOperatorActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_base);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(view -> operatorExample());
    }

    protected abstract void operatorExample();

    protected abstract String getTag();

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
}
