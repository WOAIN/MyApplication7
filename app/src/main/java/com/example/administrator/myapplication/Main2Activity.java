package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView imageView;
    private TextView textView;
    private  android.support.v7.widget.Toolbar toolbar;
    public static final String FRUIT_NAME="fruit_name";
    public static final String FRUIT_NAME_ID="fruit_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        int fruitImageId=intent.getIntExtra(FRUIT_NAME_ID,R.mipmap.ic_launcher);
        String fruitName=intent.getStringExtra(FRUIT_NAME);
        imageView= (ImageView) findViewById(R.id.fruit_image_view);
        textView= (TextView) findViewById(R.id.mian2_text);
        //用toolbar替换ActionBar
        toolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<5000;i++){
            buffer.append(fruitName+"");
        }
        textView.setText(buffer.toString());
        imageView.setImageResource(fruitImageId);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            //为左上角加上一个返回图标
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //collapsingToolbarLayout.setTitle(fruitName);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);//指定要创建的菜单
        return true;
    }
    @Override//处理点击事件
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        switch (item.getItemId()){
            case R.id.backup:
                Toast.makeText(this,"Backup",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;

    }
}

