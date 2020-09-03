package com.alfonso.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout srRefresh;
    ListView lvMyList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aggregateFAB();

        srRefresh = findViewById(R.id.srRefresh);
        lvMyList = findViewById(R.id.lvMyList);

        String[] planetas = getResources().getStringArray(R.array.planetas);
        lvMyList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));

        srRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
    }

    public void refreshContent(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lvMyList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        srRefresh.setRefreshing(false);
    }

    public void aggregateFAB(){
        FloatingActionButton miFAB = findViewById(R.id.fabMiFAB);

        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                Snackbar.make(view, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.txt_action), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR","Click en Snackbar");
                            }
                        })
                        .show();
            }
        });
    }
}