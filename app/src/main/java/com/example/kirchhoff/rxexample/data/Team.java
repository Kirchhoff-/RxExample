package com.example.kirchhoff.rxexample.data;

import android.support.annotation.NonNull;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class Team {

    private String teamName;

    public void setTeamName(@NonNull String teamName) {
        this.teamName = teamName;
    }

    public Observable<String> brandDeferObservable() {
       /* return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                return Observable.just(teamName);
            }
        }); */

        return Observable.defer(() -> Observable.just(teamName));
    }
}
