package com.mzw.soundmark;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.text.TextUtils;

import java.io.IOException;

/**
 * Created by think on 2018/9/12.
 */

public class StartAssetsMP3 {
    static MediaPlayer mediaPlayer;

    public StartAssetsMP3() {
        synchronized(this){
            mediaPlayer = new MediaPlayer();
        }
    }

    public static void startAssetsMP3(Context context, String audioName){
        if(!TextUtils.isEmpty(audioName)){
            try {
                //播放 assets 音频文件
                AssetFileDescriptor fd = context.getAssets().openFd(audioName);

                mediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
