package com.u1fukui.android.demo.dagger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.u1fukui.android.demo.dagger.yasashi.YasashiSampleActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerItemClickListener<DemoItem> {

    private DemoItemRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        adapter = new DemoItemRecyclerAdapter();
        adapter.setListener(this);
        adapter.addAll(createList());
        recyclerView.setAdapter(adapter);
    }

    private List<DemoItem> createList() {
        List<DemoItem> list = new ArrayList<>();
        list.add(new DemoItem(YasashiSampleActivity.class, "やさしいDagger2"));
        return list;
    }

    @Override
    protected void onDestroy() {
        adapter.setListener(null);
        super.onDestroy();
    }

    //region RecyclerItemClickListener<DemoItem>
    @Override
    public void onItemClick(DemoItem item) {
        startActivity(new Intent(this, item.getActivityClass()));
    }
    //endregion
}

