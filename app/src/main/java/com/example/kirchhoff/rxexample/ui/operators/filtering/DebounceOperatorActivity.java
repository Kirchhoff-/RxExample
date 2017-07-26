package com.example.kirchhoff.rxexample.ui.operators.filtering;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class DebounceOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, DebounceOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        debounceExample();
    }

    @Override
    protected String getTag() {
        return DebounceOperatorActivity.class.getName();
    }

    /*
   * Using debounce() -> only emit an item from an Observable if a particular time-span has
   * passed without it emitting another item */
    private void debounceExample() {
        getObservable()
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getIntObserver());
    }

    private Observable<Integer> getObservable() {
        return Observable.create(emitter -> {
            // send events with simulated time wait
            emitter.onNext(1); // skip
            Thread.sleep(400);
            emitter.onNext(2); // deliver
            Thread.sleep(505);
            emitter.onNext(3); // skip
            Thread.sleep(100);
            emitter.onNext(4); // deliver
            Thread.sleep(605);
            emitter.onNext(5); // deliver
            Thread.sleep(510);
            emitter.onComplete();
        });
    }
}
