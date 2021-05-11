package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.listView);

        // データを準備
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            // items.add("item-" + i);
        }

        //　Adapter - ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item,
                items
        );

        //ListViewに表示
        myListView.setEmptyView(findViewById(R.id.emptyView));
        myListView.setAdapter(adapter);
    }
}