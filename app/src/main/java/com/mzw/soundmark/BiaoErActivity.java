package com.mzw.soundmark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by think on 2018/9/12.
 */

public class BiaoErActivity extends Activity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biao_er_activity);
        mContext = this;
    }

    public void textClick(View view) {
        String audioName = "";
        switch (view.getId()){
            case R.id.id_text_i_sound2: audioName ="i-sound2"; break;
            case R.id.id_text_i_sound: audioName ="i-sound"; break;
            case R.id.id_text_e_sound: audioName ="e-sound"; break;
            case R.id.id_text_an_sound: audioName ="an-sound"; break;
            case R.id.id_text_er_sound: audioName ="er-sound"; break;

            case R.id.id_text_eE_sound: audioName ="e5E-sound"; break;
            case R.id.id_text_E_sound: audioName ="5E-sound"; break;
            case R.id.id_text_u_sound2: audioName ="u-sound2"; break;
            case R.id.id_text_u_sound: audioName ="u-sound"; break;
            case R.id.id_text_o_sound2: audioName ="o-sound2"; break;

            case R.id.id_text_o_sound: audioName ="o-sound"; break;
            case R.id.id_text_a_sound2: audioName ="a-sound2"; break;
            case R.id.id_text_ei: audioName ="ei"; break;
            case R.id.id_text_ai: audioName ="ai"; break;
            case R.id.id_text_oi: audioName ="oi"; break;

            case R.id.id_text_ao: audioName ="ao"; break;
            case R.id.id_text_eu: audioName ="eu"; break;
            case R.id.id_text_ir: audioName ="ir"; break;
            case R.id.id_text_er: audioName ="er"; break;
            case R.id.id_text_uer: audioName ="uer"; break;

            case R.id.id_text_p: audioName ="p"; break;
            case R.id.id_text_t: audioName ="t"; break;
            case R.id.id_text_k: audioName ="k"; break;
            case R.id.id_text_b: audioName ="b"; break;
            case R.id.id_text_d: audioName ="d"; break;

            case R.id.id_text_g: audioName ="g"; break;
            case R.id.id_text_f: audioName ="f"; break;
            case R.id.id_text_s: audioName ="s"; break;
            case R.id.id_text_ss: audioName ="ss"; break;
            case R.id.id_text_si: audioName ="si"; break;

            case R.id.id_text_h: audioName ="h"; break;
            case R.id.id_text_v: audioName ="v"; break;
            case R.id.id_text_z: audioName ="z"; break;
            case R.id.id_text_n3: audioName ="n3"; break;
            case R.id.id_text_qq: audioName ="qq"; break;

            case R.id.id_text_r: audioName ="r"; break;
            case R.id.id_text_tss: audioName ="tss"; break;
            case R.id.id_text_tr: audioName ="tr"; break;
            case R.id.id_text_ts: audioName ="ts"; break;
            case R.id.id_text_d3: audioName ="d3"; break;

            case R.id.id_text_dr: audioName ="dr"; break;
            case R.id.id_text_dz: audioName ="dz"; break;
            case R.id.id_text_m: audioName ="m"; break;
            case R.id.id_text_n: audioName ="n"; break;
            case R.id.id_text_ng: audioName ="ng"; break;

            case R.id.id_text_l: audioName ="l"; break;
            case R.id.id_text_j: audioName ="j"; break;
            case R.id.id_text_w: audioName ="w"; break;
        }

        String name = ((TextView)view).getText().toString();
        StartAssetsAudio.getInstance().playAssetsAudio(mContext,audioName);

        Intent intent = new Intent(mContext,YinBiaoFaYinActivity.class);
        intent.putExtra("audioName",audioName);
        intent.putExtra("name",name);
        startActivity(intent);
    }
}
