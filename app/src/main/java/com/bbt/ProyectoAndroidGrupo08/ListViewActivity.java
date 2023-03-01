package com.bbt.ProyectoAndroidGrupo08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        
        lv = (ListView) findViewById(R.id.listView);
        ArrayList<String> listado = new ArrayList<String>();
        listado.add("uno");
        listado.add("dos");
        for(int i = 3; i<=20; i++){
            listado.add("Espacio " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, listado);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext() ,"Pos: "+ position + "-" + lv.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}