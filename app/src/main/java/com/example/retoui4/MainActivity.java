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

    // Método para cambiar de layout
    public void cambiarLayout(View view) {

        Intent intent = new Intent(this, Estacionamiento.class);
        startActivity(intent);
    }
}
