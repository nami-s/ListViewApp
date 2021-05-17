package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
            users.add(user);
        }

        //　Adapter - ArrayAdapter - UserAdapter
        UserAdapter adapter = new UserAdapter(this, 0, users);

        //ListViewに表示
        myListView.setAdapter(adapter);
    }

    public class UserAdapter extends ArrayAdapter<User> {
        private LayoutInflater layoutInflater;

        public UserAdapter(Context c, int id, ArrayList<User> users){
            super(c, id, users);
            this.layoutInflater = (LayoutInflater) c.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent){
            if (convertView == null) {
                convertView = layoutInflater.inflate(
                        R.layout.list_item,
                        parent,
                        false
                );
            }

            User user = (User) getItem(pos);// getItem() 何番目を引っ張ってくるかのメソッド
            ((ImageView) convertView.findViewById(R.id.icon)).setImageBitmap(user.getIcon());
            ((TextView) convertView.findViewById(R.id.name)).setText(user.getName());
            ((TextView) convertView.findViewById(R.id.loc)).setText(user.getLoc());
            return convertView;
        }
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