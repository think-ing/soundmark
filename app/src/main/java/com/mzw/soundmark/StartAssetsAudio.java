package com.mzw.soundmark;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

/**
 * 播放音频
 * Created by think on 2018/9/12.
 */

public class StartAssetsAudio {
    private static StartAssetsAudio ourInstance = null;
    private static MediaPlayer mediaPlayer = null;

    public static synchronized StartAssetsAudio getInstance() {
        if (ourInstance == null)
            ourInstance = new StartAssetsAudio();

        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();

        return ourInstance;
    }

    // 播放Assets中音频
    public static void playAssetsAudio(Context context, String audioName){
        if (mediaPlayer != null)//如果不为空  可能正在播放， 先释放
            mediaPlayer.release();
            mediaPlayer = new MediaPlayer();

        if(!TextUtils.isEmpty(audioName) && mediaPlayer != null){
            try {
                //播放 assets 音频文件
                AssetFileDescriptor fd = context.getAssets().openFd("audio/"+audioName+".mp3");
                mediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void playHttpAudio(Context context, String audioUrl) {
        Log.i("---mzw---","audioUrl : " + audioUrl);
        if (mediaPlayer != null)//如果不为空  可能正在播放， 先释放
            mediaPlayer.release();
            mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(audioUrl);
            mediaPlayer.prepare();    //准备
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
