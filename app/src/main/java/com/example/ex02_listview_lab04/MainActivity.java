package com.example.ex02_listview_lab04;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    ArrayList<String> data = new ArrayList<>();

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        int n = new Random().nextInt(20) + 1;

        for (int i = 0; i < n; i++){
            data.add("Item " + i);
        }

        adapter = new ArrayAdapter<String>(
                this,
                R.layout.item,
                R.id.textView,
                data)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View object = super.getView(position, convertView, parent);

                Button button = object.findViewById(R.id.button);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        data.remove(position);

                        adapter.notifyDataSetChanged();
                    }
                });

                TextView textView = object.findViewById(R.id.textView);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"Item " + position, Toast.LENGTH_SHORT).show();
                    }
                });
                return object;
            }
        };
        listView.setAdapter(adapter);
    }

}