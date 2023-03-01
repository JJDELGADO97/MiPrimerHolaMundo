package com.bbt.ProyectoAndroidGrupo08;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    private static final long SPLASH_SCREEN_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Bloquear orientacion de pantalla!
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Ocultar barra de notificaciones
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Ocultar ActionBar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);

        //Crear una tarea de temporizacion
        TimerTask timerTask =  new TimerTask() {
            @Override
            public void run() {
                Intent newIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(newIntent);
                finish();
            }
        };

        //Crear timer para ejecutar la tarea de temporizacion
        Timer timer = new Timer();
        timer.schedule(timerTask, SPLASH_SCREEN_DELAY);
    }
}