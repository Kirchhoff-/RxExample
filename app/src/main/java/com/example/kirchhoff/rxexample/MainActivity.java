package com.example.kirchhoff.rxexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kirchhoff.rxexample.ui.BufferOperatorActivity;
import com.example.kirchhoff.rxexample.ui.CompletableObserverActivity;
import com.example.kirchhoff.rxexample.ui.DisposableActivity;
import com.example.kirchhoff.rxexample.ui.FirstActivity;
import com.example.kirchhoff.rxexample.ui.FlowableActivity;
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
        findViewById(R.id.bufferOperator).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.firstExample:
                FirstActivity.startMe(this);
                break;

            case R.id.mapOperator:
                MapOperatorActivity.startMe(this);
                break;

            case R.id.zipOperator:
                ZipOperatorActivity.startMe(this);
                break;

            case R.id.disposable:
                DisposableActivity.startMe(this);
                break;

            case R.id.takeOperator:
                TakeOperatorActivity.startMe(this);
                break;

            case R.id.timer:
                TimerActivity.startMe(this);
                break;

            case R.id.interval:
                IntervalActivity.startMe(this);
                break;

            case R.id.singleObserver:
                SingleObserverActivity.startMe(this);
                break;

            case R.id.completableObserver:
                CompletableObserverActivity.startMe(this);
                break;

            case R.id.flowable:
                FlowableActivity.startMe(this);
                break;

            case R.id.reduceOperator:
                ReduceOperatorActivity.startMe(this);
                break;

            case R.id.bufferOperator:
                BufferOperatorActivity.startMe(this);
                break;
        }
    }
}
