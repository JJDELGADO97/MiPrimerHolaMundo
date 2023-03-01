package com.bbt.ProyectoAndroidGrupo08;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ProductoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        //activar soporte action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Funcion para flecha regresar
        getParametros();
    }

    public void getParametros(){
        /*Bundle extras = getIntent().getExtras();
        String msg = extras.getString("msg");
        int year = extras.getInt("year");
        Toast.makeText(this, msg + " " + year, Toast.LENGTH_LONG).show();*/
    }

    public void goToActivityMain(View view){
        Intent newIntent = new Intent( this, MainActivity.class);

        //paso de parametros
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // inicializacion de nueva activity
        startActivity(newIntent);
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