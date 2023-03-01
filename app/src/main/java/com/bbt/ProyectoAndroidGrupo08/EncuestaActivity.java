package com.bbt.ProyectoAndroidGrupo08;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class EncuestaActivity extends AppCompatActivity {
    private CheckBox ch1, ch2, ch3, ch4, ch5, ch6;
    private EditText et1, et2, et3, et4;
    private TextView tv1;
    private SeekBar sk1;
    private Spinner sp1;
    private Switch sw1;
    private RadioButton rb1, rb2, rb3;
    private TextInputEditText ti1;

    String textoDatos = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        ch1 = (CheckBox) findViewById(R.id.checkBox);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        ch3 = (CheckBox) findViewById(R.id.checkBox3);
        ch4 = (CheckBox) findViewById(R.id.checkBox4);
        ch5 = (CheckBox) findViewById(R.id.checkBox5);
        ch6 = (CheckBox) findViewById(R.id.checkBox6);

        et1 = (EditText) findViewById(R.id.editTextTextPersonName2);
        et2 = (EditText) findViewById(R.id.editTextDate);
        et3 = (EditText) findViewById(R.id.editTextPhone);
        et4 = (EditText) findViewById(R.id.editTextTextEmailAddress);

        ti1 = (TextInputEditText) findViewById(R.id.textInputEditText);
                
        tv1 = (TextView) findViewById(R.id.textView13);

        sp1 = (Spinner) findViewById(R.id.spinner);

        sw1 = (Switch) findViewById(R.id.switch1);

        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);

        sk1 = (SeekBar) findViewById(R.id.seekBar1);
        sk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv1.setText(""+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Toast.makeText(this, "" + ch1.isChecked(), Toast.LENGTH_SHORT).show();
    }

    public void obtenerDatos(View view){
        String nom = "Nombre: " + et1.getText().toString();
        String fnac = "Fnacimiento: " + et2.getText().toString();
        String tel = "Telefono: " + et3.getText().toString();
        String email = "Email: " + et4.getText().toString();
        String direccion = "Direccion: " + ti1.getText().toString();
        String niv_ingles = "Nivel de ingles: " + sp1.getSelectedItem();
        String gust_prog = "¿Te gusta programar? ";
        if (sw1.isChecked()){
            gust_prog+="Si";
        }else{
            gust_prog+="No";
        }
        String lenguajes = "Lenguajes de programacion conocidos: ";
        if(ch1.isChecked()){
            lenguajes += ch1.getText() + ", ";
        }
        if(ch2.isChecked()){
            lenguajes += ch2.getText() + ", ";
        }
        if(ch3.isChecked()){
            lenguajes += ch3.getText() + ", ";
        }
        if(ch4.isChecked()){
            lenguajes += ch4.getText() + ", ";
        }
        if(ch5.isChecked()){
            lenguajes += ch5.getText() + ", ";
        }

        String texperiencia = "Tiempo de experiencia: ";
        if(rb1.isChecked()){
             texperiencia += rb1.getText() + " años.";
        }else if(rb2.isChecked()){
            texperiencia += rb2.getText() + " años.";
        }else if(rb3.isChecked()){
            texperiencia += rb3.getText() + " años.";
        }

        String satisfaccion= "El nivel de satisfaccion es: " + tv1.getText();


        new AlertDialog.Builder(this, R.style.Theme_AppCompat_DayNight_Dialog_Alert )
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle("Datos")
                .setMessage(nom + "\n" + fnac + "\n" + tel + "\n" + email + "\n" + niv_ingles + "\n" + gust_prog + "\n" + lenguajes + "\n" + texperiencia  + "\n" + satisfaccion  + "\n" + direccion)
                .setPositiveButton("Aceptar", null).show();

    }
}