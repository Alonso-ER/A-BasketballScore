package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getLocalScore().observe(this, localScoreInt -> {
            binding.localScore.setText(String.valueOf(localScoreInt));
        });

        viewModel.getVisitorScore().observe(this, visitorScoreInt -> {
            binding.visitorScore.setText(String.valueOf(visitorScoreInt));
        });

        setUpButtons();

    }

    private void setUpButtons() {
        binding.localPlus1.setOnClickListener( v -> {
            viewModel.increaseLocalPlusOne();
        });

        binding.localPlus2.setOnClickListener( v -> {
            viewModel.increaseLocalPlusTwo();
        });

        binding.localMinus1.setOnClickListener( v -> {
            viewModel.decreaseLocal();
        });

        binding.visitorPlus1.setOnClickListener( v -> {
            viewModel.increaseVisitorPlusOne();
        });

        binding.visitorPlus2.setOnClickListener( v -> {
            viewModel.increaseVisitorPlusTwo();
        });

        binding.visitorMinus1.setOnClickListener( v -> {
            viewModel.decreaseVisitor();
        });

        binding.results.setOnClickListener( v -> {
            updateResults(viewModel.getLocalScore().getValue(), viewModel.getVisitorScore().getValue());
        });

        binding.restart.setOnClickListener( v -> {
            viewModel.resetScores();
        });
    };
    private void updateResults(
            int local,
            int visitor
    ) {
        Intent intent = new Intent(this, ScoreActivity.class);

        intent.putExtra(ScoreActivity.LOCAL, String.valueOf(local));
        intent.putExtra(ScoreActivity.VISITOR, String.valueOf(visitor));
        startActivity(intent);
    }






}