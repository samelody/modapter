package com.samelody.samples.modapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.samelody.modapter.AdapterItem;
import com.samelody.modapter.ItemManager;
import com.samelody.modapter.ModularAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listView = findViewById(R.id.list);
        ModularAdapter<AdapterItem> adapter = new ModularAdapter<>();
        listView.setAdapter(adapter);

        ItemManager<AdapterItem> manager = adapter.getManager();
        manager.register(R.layout.item_gallery_image, ImageViewHolder.class)
                .register(R.layout.item_gallery_date, DateViewHolder.class);

        manager.unregister(R.layout.item_gallery_image);

        List<AdapterItem> list = new ArrayList<>();
        list.add(new ImageItem());
        list.add(new DateItem());
        list.add(new ImageItem());
        list.add(new DateItem());
        manager.submitList(list);
        adapter.notifyDataSetChanged();

        manager.getCurrentList();
        manager.getItem(0);
    }
}
