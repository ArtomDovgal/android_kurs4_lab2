package com.example.languageeducationlab2;

import android.app.Application;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App extends Application {
    private Set<TaskListener> listenerset = new HashSet<>();

    public void addListener(TaskListener listener){
        this.listenerset.add(listener);
    }

    public void removeListener(TaskListener listener){
        this.listenerset.remove(listener);
    }

    public void publishSaveWordMap(Map<String,String> engWords, Map<String, String> germWords){
        for (TaskListener taskListener : listenerset){
            taskListener.saveWordMap(engWords,germWords);
        }

    }

}
