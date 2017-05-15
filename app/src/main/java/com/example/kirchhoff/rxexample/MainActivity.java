package com.example.kirchhoff.rxexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kirchhoff.rxexample.ui.CompletableObserverActivity;
import com.example.kirchhoff.rxexample.ui.DisposableActivity;
import com.example.kirchhoff.rxexample.ui.FirstActivity;
import com.example.kirchhoff.rxexample.ui.FlowableExampleActivity;
import com.example.kirchhoff.rxexample.ui.IntervalActivity;
import com.example.kirchhoff.rxexample.ui.MapOperatorActivity;
import com.example.kirchhoff.rxexample.ui.ReduceOperatorActivity;
import com.example.kirchhoff.rxexample.ui.SingleObserverActivity;
import com.example.kirchhoff.rxexample.ui.TakeOperatorActivity;
import com.example.kirchhoff.rxexample.ui.TimerActivity;
import com.example.kirchhoff.rxexample.ui.ZipOperatorActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.firstExample).setOnClickListener(this);
        findViewById(R.id.mapOperator).setOnClickListener(this);
        findViewById(R.id.zipOperator).setOnClickListener(this);
        findViewById(R.id.takeOperator).setOnClickListener(this);
        findViewById(R.id.disposable).setOnClickListener(this);
        findViewById(R.id.timer).setOnClickListener(this);
        findViewById(R.id.interval).setOnClickListener(this);
        findViewById(R.id.singleObserver).setOnClickListener(this);
        findViewById(R.id.completableObserver).setOnClickListener(this);
        findViewById(R.id.flowable).setOnClickListener(this);
        findViewById(R.id.reduceOperator).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.firstExample:
                Intent intent = new Intent(this, FirstActivity.class);
                startActivity(intent);
                break;

            case R.id.mapOperator:
                Intent mapIntent = new Intent(this, MapOperatorActivity.class);
                startActivity(mapIntent);
                break;

            case R.id.zipOperator:
                Intent zipIntent = new Intent(this, ZipOperatorActivity.class);
                startActivity(zipIntent);
                break;

            case R.id.disposable:
                Intent disposableIntent = new Intent(this, DisposableActivity.class);
                startActivity(disposableIntent);
                break;

            case R.id.takeOperator:
                Intent takeIntent = new Intent(this, TakeOperatorActivity.class);
                startActivity(takeIntent);
                break;

            case R.id.timer:
                Intent timer = new Intent(this, TimerActivity.class);
                startActivity(timer);
                break;

            case R.id.interval:
                Intent interval = new Intent(this, IntervalActivity.class);
                startActivity(interval);
                break;

            case R.id.singleObserver:
                Intent singleObserver = new Intent(this, SingleObserverActivity.class);
                startActivity(singleObserver);
                break;

            case R.id.completableObserver:
                Intent completableIntent = new Intent(this, CompletableObserverActivity.class);
                startActivity(completableIntent);
                break;

            case R.id.flowable:
                Intent flowableIntent = new Intent(this, FlowableExampleActivity.class);
                startActivity(flowableIntent);
                break;

            case R.id.reduceOperator:
                Intent reduceIntent = new Intent(this, ReduceOperatorActivity.class);
                startActivity(reduceIntent);
                break;
        }
    }
}
