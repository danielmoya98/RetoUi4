package com.example.retoui4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasajes);
    }

    public void cambiarLayout(View view) {

        Intent intent = new Intent(this, Estacionamiento.class);
        startActivity(intent);
    }
    public void cambiarLayout3(View view) {

        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }

    public void cambiarLayout4(View view) {

        Intent intent = new Intent(this, Reservas.class);
        startActivity(intent);
    }
}
