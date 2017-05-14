package com.example.kirchhoff.rxexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kirchhoff.rxexample.ui.DisposableActivity;
import com.example.kirchhoff.rxexample.ui.FirstActivity;
import com.example.kirchhoff.rxexample.ui.MapOperatorActivity;
import com.example.kirchhoff.rxexample.ui.ZipOperatorActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.firstExample).setOnClickListener(this);
        findViewById(R.id.mapOperator).setOnClickListener(this);
        findViewById(R.id.zipOperator).setOnClickListener(this);
        findViewById(R.id.disposableOperator).setOnClickListener(this);
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

            case R.id.disposableOperator:
                Intent disposableIntent = new Intent(this, DisposableActivity.class);
                startActivity(disposableIntent);
                break;
        }
    }
}
