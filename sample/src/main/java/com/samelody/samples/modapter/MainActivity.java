package com.samelody.samples.modapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.samelody.modapter.AbstractItem;
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
        ModularAdapter<AbstractItem> adapter = new ModularAdapter<>();
        listView.setAdapter(adapter);

        ItemManager<AbstractItem> manager = adapter.getManager();
        manager.register(R.layout.item_gallery_image, ImageViewHolder.class)
                .register(R.layout.item_gallery_date, DateViewHolder.class);

        manager.unregister(R.layout.item_gallery_image);

        List<ImageItem> list = new ArrayList<>();
        list.add(new ImageItem());
        list.add(new ImageItem());
        list.add(new ImageItem());
        list.add(new ImageItem());
        manager.submitList(list);
        adapter.notifyDataSetChanged();

        manager.getCurrentList();
        manager.getItem(0);
    }
}
