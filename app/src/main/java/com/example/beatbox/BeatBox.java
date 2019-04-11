package com.example.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class BeatBox {
    private static final String SOUND_FOLDER = "sample_sounds";
    private static final String TAG = "BeatBox";
    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();

    BeatBox(Context context) {
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;
        try {
            soundNames = mAssets.list(SOUND_FOLDER);
            assert soundNames != null;
            Log.i(TAG, "BeatBox: 找到了" + soundNames.length + "个音效文件");
        } catch (IOException e) {
            Log.e(TAG, "BeatBox: 无法列出资源", e);
            return;
        }

        for (String filename : soundNames) {
            String assetPath = SOUND_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    List<Sound> getSounds() {
        return mSounds;
    }
}
