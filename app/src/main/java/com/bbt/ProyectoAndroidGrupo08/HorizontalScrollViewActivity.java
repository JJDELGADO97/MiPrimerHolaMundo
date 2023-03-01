package com.bbt.ProyectoAndroidGrupo08;

import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class HorizontalScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontalscrollview);
        //activar soporte action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //Inicio metodos flecha volver en el menu
    public void onBackPressed(){
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();
        if(id == android.R.id.home){
            onBackPressed();//Funcion para flecha regresar
        }
        return super.onOptionsItemSelected(menuItem);
    }
    //fin metodos flecha volver en el menu
}