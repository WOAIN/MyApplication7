package com.example.administrator.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout sw;
    private FruitAdapter ftu;
    private List<Fruit> fruitList=new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar1);
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        mDrawerLayout=((DrawerLayout)findViewById(R.id.dra));



        NavigationView nv= (NavigationView) findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        ActionBar ab=getSupportActionBar();
        if (ab!=null){
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeAsUpIndicator(R.mipmap.homea);
            ab.setTitle(R.string.app_name);

        }
        nv.setCheckedItem(R.id.lianxiren);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();

                return true;
            }
        });
        init();
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ftu=new FruitAdapter(fruitList,MainActivity.this);
        recyclerView.setAdapter(ftu);
       sw=((SwipeRefreshLayout)findViewById(R.id.swi));
        sw.setColorSchemeResources(R.color.hongse);
        sw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refre();
            }





        });
    }
    private void refre() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        init();
                        ftu.notifyDataSetChanged();
                        sw.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
    private void init() {

        int[] img = new int[]{R.mipmap.aaa, R.mipmap.bbb, R.mipmap.ccc, R.mipmap.ddd, R.mipmap.fff, R.mipmap.aaa, R.mipmap.bbb, R.mipmap.ccc, R.mipmap.ddd, R.mipmap.fff, R.mipmap.aaa, R.mipmap.bbb, R.mipmap.ccc, R.mipmap.ddd, R.mipmap.fff};
        String[] name = new String[]{"橙子", "樱桃", "草莓", "橘子", "油桃", "橙子", "樱桃", "草莓", "橘子", "油桃", "橙子", "樱桃", "草莓", "橘子", "油桃"};
        for (int i = 0; i < img.length; i++) {
           fruitList.add(new Fruit(img[i],name[i]));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}