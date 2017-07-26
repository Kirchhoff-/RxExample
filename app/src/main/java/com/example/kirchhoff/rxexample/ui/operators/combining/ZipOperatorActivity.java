package com.example.kirchhoff.rxexample.ui.operators.combining;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.data.User;
import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;
import com.example.kirchhoff.rxexample.utils.UserUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class ZipOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, ZipOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        zipExample();
    }

    @Override
    protected String getTag() {
        return ZipOperatorActivity.class.getName();
    }

    /*
      * Here we are getting two user list
      * One, the list of football player
      * Another one, the list of basketball player
      * Then we are finding the list of players who play both
      */
    private void zipExample() {
        Observable.zip(getFootballPlayersObservable(), getBasketballPlayersObservable(),
                /*
                    without lambda expression
                new BiFunction<List<User>, List<User>, List<User>>() {
                    @Override
                    public List<User> apply(@NonNull List<User> footballPlayers,
                                            @NonNull List<User> basketballPlayers) throws Exception {
                        return UserUtils.filterUserWhoPlayFootballAndBasketball(footballPlayers,
                                basketballPlayers);
                    }
                })*/
                UserUtils::filterUserWhoPlayFootballAndBasketball)
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());
    }

    private Observable<List<User>> getBasketballPlayersObservable() {
        return Observable.create(e -> {
            if (!e.isDisposed()) {
                e.onNext(UserUtils.getBasketballPlayer());
                e.onComplete();
            }
        });
    }

    private Observable<List<User>> getFootballPlayersObservable() {
        return Observable.create(e -> {
            if (!e.isDisposed()) {
                e.onNext(UserUtils.getFootballPlayer());
                e.onComplete();
            }
        });
    }

    private Observer<List<User>> getObserver() {
        return new Observer<List<User>>() {
            @Override
            public void onSubscribe(Disposable d) {
                writeToConsole("" + d.isDisposed());
            }

            @Override
            public void onNext(List<User> users) {
                writeToScreen(" onNext");
                writeToScreen("\n");
                for (User user : users) {
                    writeToScreen(" firstName : " + user.firstName);
                    writeToScreen("\n");
                }
                writeToConsole(" onNext :" + users.size());
            }

            @Override
            public void onError(Throwable e) {
                writeToScreen(" onError : " + e.getMessage());
                writeToScreen("\n");
                writeToConsole(" onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                writeToScreen(" onComplete");
                writeToScreen("\n");
                writeToConsole(" onComplete");
            }
        };
    }
}
