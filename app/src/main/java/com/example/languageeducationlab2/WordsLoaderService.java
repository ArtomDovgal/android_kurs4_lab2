package com.example.languageeducationlab2;

import static android.content.Intent.getIntent;

import android.app.IntentService;
import android.content.Intent;
import android.os.ResultReceiver;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordsLoaderService extends IntentService {
    public static final String ACTION_LOAD_WORDS = "com.example.your-app.LOAD_WORDS";

    public WordsLoaderService() {
        super("WordLoaderService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {

            Language lg = Language.fromInt(intent.getIntExtra("language",0));
            loadWordsFromFile();

        }
    }

    private void loadWordsFromFile() {
        App app = (App) getApplication();
        String[] wordsEng,wordsGerm, translateEng,translateGerm;

        wordsEng = getResources().getStringArray(R.array.english_word);
        translateEng = getResources().getStringArray(R.array.english_translate);
        wordsGerm = getResources().getStringArray(R.array.german_word);
        translateGerm = getResources().getStringArray(R.array.german_translate);

        Map<String, String> wordsAndTranslateMapEng = IntStream.range(0, wordsEng.length).boxed()
                .collect(Collectors.toMap(i -> wordsEng[i], i -> translateEng[i]));

        Map<String, String> wordsAndTranslateMapGerm = IntStream.range(0, wordsGerm.length).boxed()
                .collect(Collectors.toMap(i -> wordsGerm[i], i -> translateGerm[i]));

        app.publishSaveWordMap(wordsAndTranslateMapEng,wordsAndTranslateMapGerm);


    }

}