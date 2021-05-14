package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
        ArrayList<User> users = new ArrayList<>();

        int[] icons = {
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
        };

        String[] names = {
                "Taguchi",
                "Tanaka",
                "Suzuki",
        };

        String[] locs = {
                "Ebisu",
                "Shibuya",
                "Tokyo",
        };

        for (int i = 0; i < icons.length; i++){
            User user = new User();
            user.setIcon(BitmapFactory.decodeResource(
                    getResources(),
                    icons[i]
            ));
            user.setName(names[i]);
            user.setLoc(locs[i]);
        }

        //　Adapter - ArrayAdapter

        //ListViewに表示
    }

    public class User{
        private Bitmap icon;
        private String name;
        private String loc;

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Bitmap getIcon() {
            return icon;
        }

        public void setIcon(Bitmap icon) {
            this.icon = icon;
        }
    }
}