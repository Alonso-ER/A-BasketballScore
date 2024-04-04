package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballscore.databinding.ActivityScoreBinding;

import android.os.Bundle;

public class ScoreActivity extends AppCompatActivity {

    private ActivityScoreBinding binding;

    public static final String LOCAL = "local";
    public static final String VISITOR = "visitor";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        String localScore = extras.getString(LOCAL);
        String visitorScore = extras.getString(VISITOR);

        String result = localScore + " - " + visitorScore;
        binding.resultScoreText.setText(result);

        int localScoreInt = Integer.parseInt(localScore);
        int visitorScoreInt = Integer.parseInt(visitorScore);



    }


}