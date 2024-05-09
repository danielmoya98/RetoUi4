package com.example.retoui4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class Reservas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);

        Button activosButton = findViewById(R.id.activos_button);
        Button expiradosButton = findViewById(R.id.expirados_button);
        ScrollView scrollActivos = findViewById(R.id.activos);
        ScrollView scrollExpirados = findViewById(R.id.expirados);

        activosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar ScrollView para Activos y ocultar ScrollView para Expirados
                activosButton.setBackgroundColor(getResources().getColor(R.color.white));
                activosButton.setTextColor(getResources().getColor(R.color.black));

                // Cambiar estilo del botón expirados
                expiradosButton.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                expiradosButton.setTextColor(getResources().getColor(R.color.white));

                scrollActivos.setVisibility(View.VISIBLE);
                scrollExpirados.setVisibility(View.GONE);
            }
        });

        expiradosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expiradosButton.setBackgroundColor(getResources().getColor(R.color.white));
                expiradosButton.setTextColor(getResources().getColor(R.color.black));

                // Cambiar estilo del botón activos
                activosButton.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                activosButton.setTextColor(getResources().getColor(R.color.white));
                // Mostrar ScrollView para Expirados y ocultar ScrollView para Activos
                scrollActivos.setVisibility(View.GONE);
                scrollExpirados.setVisibility(View.VISIBLE);
            }
        });

    }
}