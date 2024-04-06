package com.example.basketballscore;

import android.content.Intent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<Integer> localScore = new MutableLiveData<>();
    private MutableLiveData<Integer> visitorScore = new MutableLiveData<>();

    public MainViewModel(){
        resetScores();
    }

    public MutableLiveData<Integer> getLocalScore() {
        return localScore;
    }
    public MutableLiveData<Integer> getVisitorScore() {
        return visitorScore;
    }

    public void resetScores(){
        localScore.setValue(0);
        visitorScore.setValue(0);
    }
    void decreaseLocal(){
        if( localScore.getValue() > 0 ){
            localScore.setValue(localScore.getValue() - 1);
        } else {
            localScore.setValue(0);
        }
    }
    void increaseLocalPlusOne(){
        localScore.setValue(localScore.getValue() + 1);
    }
    void increaseLocalPlusTwo(){
        localScore.setValue(localScore.getValue() + 2);
    }
    void increaseVisitorPlusOne(){
        visitorScore.setValue(visitorScore.getValue() + 1);
    }
    void increaseVisitorPlusTwo(){
        visitorScore.setValue(visitorScore.getValue() + 2);
    }
    void decreaseVisitor(){
        if( visitorScore.getValue() > 0 ){
            visitorScore.setValue(visitorScore.getValue() - 1);
        } else {
            visitorScore.setValue(0);
        }
    }

}
