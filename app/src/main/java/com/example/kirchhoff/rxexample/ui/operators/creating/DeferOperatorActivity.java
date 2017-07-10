package com.example.kirchhoff.rxexample.ui.operators.creating;

import android.app.Activity;
import android.content.Intent;

import com.example.kirchhoff.rxexample.data.Team;
import com.example.kirchhoff.rxexample.ui.operators.BaseOperatorActivity;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class DeferOperatorActivity extends BaseOperatorActivity {

    public static void startMe(Activity activity) {
        Intent intent = new Intent(activity, DeferOperatorActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void operatorExample() {
        deferExample();
    }

    @Override
    protected String getTag() {
        return DeferOperatorActivity.class.getName();
    }

    /*
     * Defer used for Deferring Observable code until subscription in RxJava
     */
    private void deferExample() {

        Team team = new Team();

        Observable<String> brandDeferObservable = team.brandDeferObservable();

        team.setTeamName("LA Lakers");

        // Even if we are setting the team name after creating Observable
        // we will get it
        // If we had not used defer, we would have got null as the brand.
        brandDeferObservable.subscribe(getStringObserver());
    }

}
