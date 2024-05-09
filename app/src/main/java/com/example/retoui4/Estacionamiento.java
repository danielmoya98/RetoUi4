package com.example.retoui4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;

public class Estacionamiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.compra_tickets);
        LinearLayout linearLayoutAdd = findViewById(R.id.add);

        // Crear y agregar 10 instancias de la estructura
        for (int i = 0; i < 10; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            layoutParams.setMargins(0, 0, 0, 20); // Margen inferior entre cada instancia

            LinearLayout exampleLayout = new LinearLayout(this);
            exampleLayout.setLayoutParams(layoutParams);
            exampleLayout.setOrientation(LinearLayout.VERTICAL);

            // Añadir contenido similar al que proporcionaste en cada instancia
            LinearLayout innerLinearLayout = new LinearLayout(this);
            innerLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            innerLinearLayout.setOrientation(LinearLayout.VERTICAL);
            innerLinearLayout.setBackground(getResources().getDrawable(R.drawable.subtract));

            // Aquí añade los TextViews, ImageButtons y MaterialButtons a innerLinearLayout
            // Cada iteración del bucle creará una instancia única de estos elementos

            exampleLayout.addView(innerLinearLayout); // Agregar innerLinearLayout a cada instancia de exampleLayout

            // Agregar cada instancia de exampleLayout al LinearLayout principal
            linearLayoutAdd.addView(exampleLayout);
        }

    }

    public void cambiarLayout(View view) {
        Intent intent = new Intent(this, Asientos.class);
        startActivity(intent);
    }
}