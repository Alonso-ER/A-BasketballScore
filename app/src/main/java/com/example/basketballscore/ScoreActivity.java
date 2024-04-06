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

        int localScore = Integer.parseInt(extras.getString(LOCAL));
        int visitorScore = Integer.parseInt(extras.getString(VISITOR));

        binding.resultScoreText.setText(localScore + " - " + visitorScore);

        if(localScore > visitorScore){
            binding.resultText.setText(R.string.localWins); }
        else if(localScore < visitorScore) {
            binding.resultText.setText(R.string.visitorWins); }
        else { binding.resultText.setText(R.string.draw); }


    }


}