package com.example.kirchhoff.rxexample.network;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kirchhoff.rxexample.R;
import com.example.kirchhoff.rxexample.network.model.Feature;
import com.example.kirchhoff.rxexample.network.rest.HugeJsonApi;
import com.example.kirchhoff.rxexample.utils.RestUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * @author Kirchhoff-
 */

public class RxStreamingActivity extends AppCompatActivity {

    public static final int TOTAL_ELEMENTS_COUNT = 206560;

    private TextView tvStatus;
    private TextView tvCounter;
    private TextView tvLastElement;
    private ProgressBar progressBar;

    private int counter = 0;

    public static void startMe(Context context) {
        context.startActivity(new Intent(context, RxStreamingActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_rx_streaming);

        tvStatus = (TextView) findViewById(R.id.tvStatus);
        tvCounter = (TextView) findViewById(R.id.tvCounter);
        tvLastElement = (TextView) findViewById(R.id.tvLastElement);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        loadData();
    }

    private void loadData() {

        HugeJsonApi hugeJsonApi = RestUtils.createService(HugeJsonApi.class,
                HugeJsonApi.SERVICE_ENDPOINT);


        Gson gson = new GsonBuilder().create();

        hugeJsonApi.get()
                .flatMap(responseBody -> RestUtils.convertObjectsStream(responseBody, Feature.class))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Feature>() {
                    @Override
                    public void onStart() {
                        super.onStart();

                        progressBar.setMax(TOTAL_ELEMENTS_COUNT);
                        progressBar.setIndeterminate(false);
                        progressBar.setProgress(0);
                        request(1);
                    }

                    @Override
                    public void onNext(Feature feature) {
                        counter++;
                        tvCounter.setText("Read elements counter: " + counter);
                        tvLastElement.setText("Last read element: " + gson.toJson(feature));
                        tvStatus.setText("Used memory: " + getUsedMemoryInMb() + "Mb");
                        progressBar.setProgress(counter);
                        request(1);
                    }

                    @Override
                    public void onCompleted() {
                        tvStatus.setText("Status: successfully completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        tvStatus.setText("Status: something went wrong " + e.getMessage());
                    }
                });
    }

    private long getUsedMemoryInMb() {
        final Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1048576L;
    }
}
