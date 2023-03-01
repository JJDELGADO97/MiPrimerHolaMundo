package com.bbt.ProyectoAndroidGrupo08;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.text.HtmlCompat;

public class LoginActivity extends AppCompatActivity {
    //Variables locales
    private TextView t1, t2, t3;
    private EditText et1, et2;
    private ImageView iv1;
    private Button b1;

    //SharedPreferences
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Ocultar ActionBar
        getSupportActionBar().hide();

        settings = getSharedPreferences("id", Context.MODE_PRIVATE); //SharedPreferences

        t1 = (TextView) findViewById(R.id.textView);
        t1.setText("¡So High!");
        t1.setTextSize(20);

        et1 = (EditText) findViewById(R.id.editTextTextPersonName);
        et2 = (EditText) findViewById(R.id.editTextTextPassword);

        iv1 = (ImageView) findViewById(R.id.imageView3);
        b1 = (Button) findViewById(R.id.iniciarSesion);


        t2 = (TextView) findViewById(R.id.textView2);

        //String link = "<a href='https://www.google.com/'>Recordar contraseña</a>";
        String texto = "Recordar contraseña";
        t2.setText(HtmlCompat.fromHtml(texto, HtmlCompat.FROM_HTML_MODE_COMPACT));
        t2.setMovementMethod(LinkMovementMethod.getInstance());

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    if (et1.getText().toString().equals("admin"))
                        Toast.makeText(LoginActivity.this,
                                "Su contraseña es: " + settings.getString("pass", ""),
                                Toast.LENGTH_SHORT).show();
                }
            }
        });

        t3 = (TextView) findViewById(R.id.textView5);
        t3.setText(HtmlCompat.fromHtml("Registrarse", HtmlCompat.FROM_HTML_MODE_COMPACT));
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("user", et1.getText().toString());
                editor.putString("pass", et2.getText().toString());
                editor.commit();
            }
        });
    }



    public void iniciarSesion(View view){
        String usuario = et1.getText().toString();
        String clave = et2.getText().toString();
        Toast.makeText(this, settings.getString("user", ""), Toast.LENGTH_SHORT).show();
        if(usuario.equals(settings.getString("user", "")) &&
                clave.equals(settings.getString("pass", "")) &&
                !usuario.equals("") && !clave.equals("")){
            Intent newIntent = new Intent(this, MainActivity.class);
            startActivity(newIntent);
            finish();
        }
        /*if(usuario.equals("admin") && clave.equals("admin")){
            Intent newIntent = new Intent(this, MainActivity.class);
            startActivity(newIntent);
            finish();
        }*/
        else if(usuario.equals("") && clave.equals("")){
            Toast.makeText(LoginActivity.this,
                    "Por favor ingrese los datos",
                    Toast.LENGTH_SHORT).show();
            et1.requestFocus();
        }
        else if(usuario.equals("")){
            Toast.makeText(LoginActivity.this,
                    "Por favor ingrese el usuario",
                    Toast.LENGTH_SHORT).show();
            et2.requestFocus();
        }
        else if(clave.equals("")){
            Toast.makeText(LoginActivity.this,
                    "Por favor ingrese la contraseña",
                    Toast.LENGTH_SHORT).show();
            et2.requestFocus();
        }
        else{
            Toast.makeText(LoginActivity.this,
                    "datos incorrectos",
                    Toast.LENGTH_SHORT).show();

        }
    }

    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        /*Toast.makeText(this,
                "Top" + iv1.getTop()+
                        "\nLeft" + iv1.getLeft(),
                Toast.LENGTH_SHORT).show();*/
        Toast.makeText(this,
                "Width" + b1.getWidth()+
                        "\nHeight" + b1.getHeight(),
                Toast.LENGTH_SHORT).show();
    }
}