package com.example.kirchhoff.rxexample.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.kirchhoff.rxexample.R;
import com.example.kirchhoff.rxexample.data.User;
import com.example.kirchhoff.rxexample.utils.UserUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class ZipOperatorActivity extends AppCompatActivity {

    private static final String TAG = FirstActivity.class.getName();

    private TextView textView;

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, ZipOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_base);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(view -> zipExample());
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
        return Observable.create(new ObservableOnSubscribe<List<User>>() {
            @Override
            public void subscribe(ObservableEmitter<List<User>> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(UserUtils.getFootballPlayer());
                    e.onComplete();
                }
            }
        });
    }

    private Observer<List<User>> getObserver() {
        return new Observer<List<User>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(List<User> users) {
                textView.append(" onNext");
                textView.append("\n");
                for (User user : users) {
                    textView.append(" firstName : " + user.firstName);
                    textView.append("\n");
                }
                Log.d(TAG, " onNext :" + users.size());
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
