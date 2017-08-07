package com.example.kirchhoff.rxexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kirchhoff.rxexample.network.screen.RxStreamingActivity;
import com.example.kirchhoff.rxexample.network.screen.country.CountryActivity;
import com.example.kirchhoff.rxexample.ui.AsyncSubjectActivity;
import com.example.kirchhoff.rxexample.ui.BehaviorSubjectActivity;
import com.example.kirchhoff.rxexample.ui.CompletableObserverActivity;
import com.example.kirchhoff.rxexample.ui.ConcatOperatorActivity;
import com.example.kirchhoff.rxexample.ui.DelayOperatorActivity;
import com.example.kirchhoff.rxexample.ui.DisposableActivity;
import com.example.kirchhoff.rxexample.ui.FlowableActivity;
import com.example.kirchhoff.rxexample.ui.MergeOperatorActivity;
import com.example.kirchhoff.rxexample.ui.PublishSubjectActivity;
import com.example.kirchhoff.rxexample.ui.ReduceOperatorActivity;
import com.example.kirchhoff.rxexample.ui.ReplayOperatorActivity;
import com.example.kirchhoff.rxexample.ui.ReplaySubjectActivity;
import com.example.kirchhoff.rxexample.ui.SingleObserverActivity;
import com.example.kirchhoff.rxexample.ui.ThrottleFirstActivity;
import com.example.kirchhoff.rxexample.ui.ThrottleLastActivity;
import com.example.kirchhoff.rxexample.ui.operators.combining.CombineLatestOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.combining.JoinOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.combining.StartWithOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.combining.SwitchOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.combining.ZipOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.conditional.TakeUntilOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.conditional.TakeWhileOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.creating.DeferOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.creating.IntervalOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.creating.RangeOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.creating.RepeatOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.creating.RepeatWhenOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.creating.TimerOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.filtering.DebounceOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.filtering.DistinctOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.filtering.ElementAtOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.filtering.FilterOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.filtering.FirstOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.filtering.IgnoreOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.filtering.LastOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.filtering.SampleOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.filtering.SkipOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.filtering.TakeOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.transforming.BufferOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.transforming.FlatMapOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.transforming.GroupBuyOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.transforming.MapOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.transforming.ScanOperatorActivity;
import com.example.kirchhoff.rxexample.ui.operators.transforming.WindowOperatorActivity;
import com.example.kirchhoff.rxexample.ui.pagination.PaginationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void firstExample(View view) {
        FirstOperatorActivity.startMe(this);
    }

    public void mapOperatorExample(View view) {
        MapOperatorActivity.startMe(this);
    }

    public void zipOperatorExample(View view) {
        ZipOperatorActivity.startMe(this);
    }

    public void disposableOperatorExample(View view) {
        DisposableActivity.startMe(this);
    }

    public void takeOperatorExample(View view) {
        TakeOperatorActivity.startMe(this);
    }

    public void timerExample(View view) {
        TimerOperatorActivity.startMe(this);
    }

    public void intervalExample(View view) {
        IntervalOperatorActivity.startMe(this);
    }

    public void singleObserverExample(View view) {
        SingleObserverActivity.startMe(this);
    }

    public void completableObserverExample(View view) {
        CompletableObserverActivity.startMe(this);
    }

    public void flowableExample(View view) {
        FlowableActivity.startMe(this);
    }

    public void reduceOperatorExample(View view) {
        ReduceOperatorActivity.startMe(this);
    }

    public void bufferOperatorExample(View view) {
        BufferOperatorActivity.startMe(this);
    }

    public void filterOperatorExample(View view) {
        FilterOperatorActivity.startMe(this);
    }

    public void skipOperatorExample(View view) {
        SkipOperatorActivity.startMe(this);
    }

    public void scanOperatorExample(View view) {
        ScanOperatorActivity.startMe(this);
    }

    public void replayOperatorExample(View view) {
        ReplayOperatorActivity.startMe(this);
    }

    public void concatOperatorExample(View view) {
        ConcatOperatorActivity.startMe(this);
    }

    public void mergeOperatorExample(View view) {
        MergeOperatorActivity.startMe(this);
    }

    public void deferOperatorExample(View view) {
        DeferOperatorActivity.startMe(this);
    }

    public void distinctOperatorExample(View view) {
        DistinctOperatorActivity.startMe(this);
    }

    public void lastOperatorExample(View view) {
        LastOperatorActivity.startMe(this);
    }

    public void replaySubjectExample(View view) {
        ReplaySubjectActivity.startMe(this);
    }

    public void publishSubjectExample(View view) {
        PublishSubjectActivity.startMe(this);
    }

    public void behaviorSubjectExample(View view) {
        BehaviorSubjectActivity.startMe(this);
    }

    public void asyncSubjectExample(View view) {
        AsyncSubjectActivity.startMe(this);
    }

    public void throttleFirstExample(View view) {
        ThrottleFirstActivity.startMe(this);
    }

    public void throttleLastExample(View view) {
        ThrottleLastActivity.startMe(this);
    }

    public void debounceOperatorExample(View view) {
        DebounceOperatorActivity.startMe(this);
    }

    public void windowOperatorExample(View view) {
        WindowOperatorActivity.startMe(this);
    }

    public void delayOperatorExample(View view) {
        DelayOperatorActivity.startMe(this);
    }

    public void rangeOperatorExample(View view) {
        RangeOperatorActivity.startMe(this);
    }

    public void paginationExample(View view) {
        PaginationActivity.startMe(this);
    }

    public void groupByOperatorExample(View view) {
        GroupBuyOperatorActivity.startMe(this);
    }

    public void rxStreaming(View view) {
        RxStreamingActivity.startMe(this);
    }

    public void rxDatabinding(View view) {
        CountryActivity.start(this);
    }

    public void repeatOperatorExample(View view) {
        RepeatOperatorActivity.startMe(this);
    }

    public void repeatWhenOperatorExample(View view) {
        RepeatWhenOperatorActivity.startMe(this);
    }

    public void flatMapOperatorExample(View view) {
        FlatMapOperatorActivity.startMe(this);
    }

    public void elementAtOperatorExample(View view) {
        ElementAtOperatorActivity.startMe(this);
    }

    public void ignoreOperatorExample(View view) {
        IgnoreOperatorActivity.startMe(this);
    }

    public void sampleOperatorExample(View view) {
        SampleOperatorActivity.startMe(this);
    }

    public void startWithExample(View view) {
        StartWithOperatorActivity.startMe(this);
    }

    public void joinExample(View view) {
        JoinOperatorActivity.startMe(this);
    }

    public void combineLatestExample(View view) {
        CombineLatestOperatorActivity.startMe(this);
    }

    public void switchExample(View view) {
        SwitchOperatorActivity.startMe(this);
    }

    public void takeWhileExample(View view) {
        TakeWhileOperatorActivity.startMe(this);
    }

    public void takeUntilExample(View view) {
        TakeUntilOperatorActivity.startMe(this);
    }
}
