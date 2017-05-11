package com.example.kirchhoff.rxexample.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.kirchhoff.rxexample.R;
import com.example.kirchhoff.rxexample.data.ApiUser;
import com.example.kirchhoff.rxexample.data.User;
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

public class MapOperatorActivity extends AppCompatActivity {

    private static final String TAG = FirstActivity.class.getName();

    private TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_base);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(view -> mapExample());
    }


    /*
      * Here we are getting ApiUser Object from api server
      * then we are converting it into User Object because
      * may be our database support User Not ApiUser Object
      * Here we are using Map Operator to do that
    */
    private void mapExample() {
        getObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                /*map function without lambda ->
                .map(new Function<List<ApiUser>, List<User>>() {

                    @Override
                    public List<User> apply(List<ApiUser> apiUsers) throws Exception {
                        return UserUtils.convertApiUserListToUserList(apiUsers);
                    }
                }) */
                .map(UserUtils::convertApiUserListToUserList)
                .subscribe(getObserver());


    }

    private Observable<List<ApiUser>> getObservable() {
        /* Without lambda expression


        return Observable.create(new ObservableOnSubscribe<List<ApiUser>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ApiUser>> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(UserUtils.getApiUserList());
                    e.onComplete();
                }
            }
        }); */

        return Observable.create(e -> {
            if (!e.isDisposed()) {
                e.onNext(UserUtils.getApiUserList());
                e.onComplete();
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
