package com.example.kirchhoff.rxexample.network.screen.country;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Kirchhoff-
 */

public abstract class ViewModelActivity extends AppCompatActivity {

    private static final String VIEW_MODEL_STATE = "viewModelState";

    private ViewModel viewModel;

    @Nullable
    protected abstract ViewModel createViewModel(@Nullable ViewModel.SavedState savedViewModelState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModel.SavedState savedState = null;
        if (savedInstanceState != null) {
            savedState = savedInstanceState.getParcelable(VIEW_MODEL_STATE);
        }

        viewModel = createViewModel(savedState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (viewModel != null) {
            outState.putParcelable(VIEW_MODEL_STATE, viewModel.getInstanceState());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (viewModel != null) {
            viewModel.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (viewModel != null) {
            viewModel.onStop();
        }
    }
}
