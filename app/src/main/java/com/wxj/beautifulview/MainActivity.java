package com.wxj.beautifulview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wxj.beautifulview.adapter.MainListAdapter;
import com.wxj.beautifulview.adapter.SpanItemDecoration;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar tb;
    private MyDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = (Toolbar) findViewById(R.id.tb_main);
        tb.setNavigationIcon(R.drawable.face_add);
        tb.setTitle("BeautifulView");
        setSupportActionBar(tb);

        dialog = new MyDialog(this);

        RecyclerView rv_list = (RecyclerView) findViewById(R.id.rv_main_list);
        MainListAdapter adapter = new MainListAdapter(this);
        View headView = LayoutInflater.from(this).inflate(R.layout.item_main_list_head, null);
        List<String> beanList = Arrays.asList("角度看", "daf", "大师傅", "发的", "发的说法", "dasfdasf ", "jdlkasfj", "jdalkf", "aadasfdsf");
        adapter.setHeadView(headView);
        adapter.setBeanList(beanList);

        rv_list.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        rv_list.setAdapter(adapter);
        rv_list.addItemDecoration(new SpanItemDecoration(10));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Log.e("MainActivity:", "返回键");
                dialog.show();
                break;
            }
            case R.id.id_select_local_picture_item: {
                Log.e("MainActivity:", "本地");
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("呵呵哒");
                progressDialog.setIndeterminate(false);
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(true);
                progressDialog.getWindow().setGravity(Gravity.CENTER);
                progressDialog.show();
                break;
            }
            case R.id.id_edit_item: {
                Log.e("MainActivity:", "编辑");
                break;
            }
            case android.R.id.title: {
                Log.e("MainActivity:", "大标题");
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
