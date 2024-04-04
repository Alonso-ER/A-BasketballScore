package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.localPlus1.setOnClickListener( v -> {
            int score = Integer.parseInt(binding.localScore.getText().toString());
            score++;
            binding.localScore.setText(String.valueOf(score));
        });

        binding.localPlus2.setOnClickListener( v -> {
            int score = Integer.parseInt(binding.localScore.getText().toString());
            score += 2;
            binding.localScore.setText(String.valueOf(score));
        });

        binding.localMinus1.setOnClickListener( v -> {
            int score = Integer.parseInt(binding.localScore.getText().toString());
            if( score > 0 ){
                score--;
                binding.localScore.setText(String.valueOf(score));
            } else {
                score = 0;
            }
             });

        binding.visitorPlus1.setOnClickListener( v -> {
            int score = Integer.parseInt(binding.visitorScore.getText().toString());
            score++;
            binding.visitorScore.setText(String.valueOf(score));
        });

        binding.visitorPlus2.setOnClickListener( v -> {
            int score = Integer.parseInt(binding.visitorScore.getText().toString());
            score += 2;
            binding.visitorScore.setText(String.valueOf(score));
        });

        binding.visitorMinus1.setOnClickListener( v -> {
            int score = Integer.parseInt(binding.visitorScore.getText().toString());
            if (score > 0) {
                score--;
                binding.visitorScore.setText(String.valueOf(score));
            } else {
                score = 0;
            }
        });

        binding.results.setOnClickListener( v -> {
            int localScore = Integer.parseInt(binding.localScore.getText().toString());
            int visitorScore = Integer.parseInt(binding.visitorScore.getText().toString());
            updateResults(localScore, visitorScore);
        });

        binding.restart.setOnClickListener( v -> {
            binding.localScore.setText("0");
            binding.visitorScore.setText("0");
            binding.results.setText("");
        });
    }
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