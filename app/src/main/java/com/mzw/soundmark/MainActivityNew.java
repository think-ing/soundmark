package com.mzw.soundmark;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityNew extends AppCompatActivity implements View.OnClickListener {

    private MyGridView grid_yuan_yin,grid_fu_yin;
    private List<Bean> list_yuan = new ArrayList<Bean>();
    private List<Bean> list_fu = new ArrayList<Bean>();
    private GridAdapter yuanGridAdapter;
    private GridAdapter fuGridAdapter;
    private TextView biao_er;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        mContext = this;
        grid_yuan_yin = (MyGridView)findViewById(R.id.id_grid_yuan_yin);
        grid_fu_yin = (MyGridView)findViewById(R.id.id_grid_fu_yin);
        biao_er = (TextView)findViewById(R.id.id_biao_er);

        getYinBiaoList();

        init();
    }

    private void init() {
        yuanGridAdapter = new GridAdapter(list_yuan,getLayoutInflater());
        fuGridAdapter = new GridAdapter(list_fu,getLayoutInflater());

        grid_yuan_yin.setAdapter(yuanGridAdapter);
        grid_fu_yin.setAdapter(fuGridAdapter);


        biao_er.setOnClickListener(this);
        grid_yuan_yin.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bean bean = yuanGridAdapter.getItem(position);
                StartAssetsAudio.getInstance().playAssetsAudio(mContext,bean.audio);
            }
        });
        grid_yuan_yin.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Bean bean = yuanGridAdapter.getItem(position);
                Intent intent = new Intent(mContext,YinBiaoFaYinActivity.class);
                intent.putExtra("audioName",bean.audio);
                intent.putExtra("name",bean.name);
                startActivity(intent);
                return true;
            }
        });


        grid_fu_yin.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bean bean = fuGridAdapter.getItem(position);
                StartAssetsAudio.getInstance().playAssetsAudio(mContext,bean.audio);
            }
        });
        grid_fu_yin.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Bean bean = fuGridAdapter.getItem(position);
                Intent intent = new Intent(mContext,YinBiaoFaYinActivity.class);
                intent.putExtra("audioName",bean.audio);
                intent.putExtra("name",bean.name);
                startActivity(intent);
                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,BiaoErActivity.class));
    }


    private void getYinBiaoList() {
        if(list_yuan != null){
            list_yuan.clear();
        }else{
            list_yuan = new ArrayList<Bean>();
        }

        if(list_fu != null){
            list_fu.clear();
        }else{
            list_fu = new ArrayList<Bean>();
        }

        //元音	单元音	前元音
        list_yuan.add(new Bean("/iː/","i-sound2"));
        list_yuan.add(new Bean("/i/","i-sound"));
        list_yuan.add(new Bean("/e/","e-sound"));
        list_yuan.add(new Bean("/æ/","an-sound"));

        //中元音
        list_yuan.add(new Bean("/ɜː/","er-sound"));
        list_yuan.add(new Bean("/ə/","e5E-sound"));
        list_yuan.add(new Bean("/ʌ/","5E-sound"));

        //后元音
        list_yuan.add(new Bean("/uː/","u-sound2"));
        list_yuan.add(new Bean("/ʊ/","u-sound"));
        list_yuan.add(new Bean("/ɔː/","o-sound2"));
        list_yuan.add(new Bean("/ɒ/","o-sound"));
        list_yuan.add(new Bean("/ɑː/","a-sound2"));

        //双元音	开合双元音
        list_yuan.add(new Bean("/ei/","ei"));
        list_yuan.add(new Bean("/ai/","ai"));
        list_yuan.add(new Bean("/ɔi/","oi"));
        list_yuan.add(new Bean("/aʊ/","ao"));
        list_yuan.add(new Bean("/əʊ/","eu"));

        //集中双元音
        list_yuan.add(new Bean("/iə/","ir"));
        list_yuan.add(new Bean("/eə/","er"));
        list_yuan.add(new Bean("/ʊə/","uer"));

// ------------------------------------------------------------------------------------------------
        //辅音	爆破音	清辅音
        list_fu.add(new Bean("/p/","p"));
        list_fu.add(new Bean("/t/","t"));
        list_fu.add(new Bean("/k/","k"));

        //浊辅音
        list_fu.add(new Bean("/b/","b"));
        list_fu.add(new Bean("/d/","d"));
        list_fu.add(new Bean("/ɡ/","g"));

        //摩擦音	清辅音
        list_fu.add(new Bean("/f/","f"));
        list_fu.add(new Bean("/s/","s"));
        list_fu.add(new Bean("/ʃ/","ss"));
        list_fu.add(new Bean("/θ/","si"));
        list_fu.add(new Bean("/h/","h"));

        //浊辅音
        list_fu.add(new Bean("/v/","v"));
        list_fu.add(new Bean("/z/","z"));
        list_fu.add(new Bean("/ʒ/","n3"));
        list_fu.add(new Bean("/ð/","qq"));
        list_fu.add(new Bean("/r/","r"));

        //破擦音	清辅音
        list_fu.add(new Bean("/tʃ/","tss"));
        list_fu.add(new Bean("/tr/","tr"));
        list_fu.add(new Bean("/ts/","ts"));

        //浊辅音
        list_fu.add(new Bean("/dʒ/","d3"));
        list_fu.add(new Bean("/dr/","dr"));
        list_fu.add(new Bean("/dz/","dz"));

        //鼻音	（浊辅音）
        list_fu.add(new Bean("/m/","m"));
        list_fu.add(new Bean("/n/","n"));
        list_fu.add(new Bean("/ŋ/","ng"));

        //舌则音	（浊辅音）
        list_fu.add(new Bean("/l/","l"));

        //半元音	（浊辅音）
        list_fu.add(new Bean("/j/","j"));
        list_fu.add(new Bean("/w/","w"));

    }


}
