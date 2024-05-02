package com.example.retoui4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

    }
    public void cambiarLayout(View view) {

        Intent intent = new Intent(this, CrearCuenta.class);
        startActivity(intent);
    }

    public void cambiarLayout2(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}