package com.samelody.samples.modapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.samelody.modapter.ModularAdapter;
import com.samelody.modapter.AdapterItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listView;

    private ModularAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        adapter = new ModularAdapter();
        listView.setAdapter(adapter);

        adapter.getManager()
                .register(R.layout.item_gallery_image, ImageViewHolder.class)
                .register(R.layout.item_gallery_date, DateViewHolder.class);

        adapter.getManager().unregister(R.layout.item_gallery_image);

        List<AdapterItem> list = new ArrayList<>();
        list.add(new ImageItem());
        list.add(new DateItem());
        list.add(new ImageItem());
        list.add(new ImageItem());
        adapter.getManager().setList(list);
        adapter.notifyDataSetChanged();
    }
}
