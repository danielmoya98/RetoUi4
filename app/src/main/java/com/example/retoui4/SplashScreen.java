package com.example.retoui4;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        // Referencia al ImageView que deseas animar
        ImageView logoImageView = findViewById(R.id.logoImageView);

        // Configurar la animación de fade in
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(2000); // Duración en milisegundos (ajusta según tus necesidades)

        // Asignar la animación al ImageView
        logoImageView.startAnimation(fadeIn);

        // Configurar un listener para la animación
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // La animación ha comenzado
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // La animación ha terminado, transicionar a la siguiente actividad
                startActivity(new Intent(SplashScreen.this, Login.class));
                finish(); // Opcional: cerrar la actividad actual si no la necesitas más
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // La animación se repite (si está configurada para repetirse)
            }
        });


    }
}