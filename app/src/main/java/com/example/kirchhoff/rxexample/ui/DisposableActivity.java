package com.example.kirchhoff.rxexample.ui;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.kirchhoff.rxexample.R;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class DisposableActivity extends AppCompatActivity {

    private static final String TAG = FirstActivity.class.getName();
    private final CompositeDisposable disposables = new CompositeDisposable();
    private TextView textView;

    static Observable<String> sampleObservable() {
      /*  return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                //Do some long running operation
                SystemClock.sleep(2000);
                return Observable.just("one","two","three","four","five");
            }
        }); */
        return Observable.defer(() -> {
            //Do some long running operation
            SystemClock.sleep(2000);
            return Observable.just("one", "two", "three", "four", "five");
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_base);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(view -> disposableExample());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }

    /*
        * Example to understand how to use disposables.
        * disposables is cleared in onDestroy of this activity.
        */
    private void disposableExample() {
        disposables.add(sampleObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onComplete() {
                        textView.append(" onComplete");
                        textView.append("\n");
                        Log.d(TAG, " onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        textView.append(" onError : " + e.getMessage());
                        textView.append("\n");
                        Log.d(TAG, " onError : " + e.getMessage());
                    }

                    @Override
                    public void onNext(String value) {
                        textView.append(" onNext : value : " + value);
                        textView.append("\n");
                        Log.d(TAG, " onNext value : " + value);
                    }
                }));
    }
}
