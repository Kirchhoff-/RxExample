package com.example.kirchhoff.rxexample.ui.operators.transforming;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class FlatMapOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, FlatMapOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        flatMapExample();
    }

    @Override
    protected String getTag() {
        return FlatMapOperatorActivity.class.getName();
    }

    private void flatMapExample() {
        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<List<String>, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(@NonNull List<String> integers) throws Exception {
                        return Observable.fromIterable(integers);
                    }
                })
                .subscribe(getStringObserver());
    }

    private Observable<List<String>> getObservable() {
        return Observable.create(emitter -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                list.add(i + ".com");
            }

            if (!emitter.isDisposed()) {
                emitter.onNext(list);
                emitter.onComplete();
            }
        });
    }
}
