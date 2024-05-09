package com.example.retoui4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.content.Intent;
import android.widget.DatePicker;
import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.app.DatePickerDialog;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button buttonAutomovil, buttonMotocicleta;
    EditText yourTextInputEditText;
    EditText secondTextInputEditText;
    Button timePickerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasajes);
        buttonAutomovil = findViewById(R.id.buttonAutomovil);
       buttonMotocicleta = findViewById(R.id.buttonMotocicleta);
        yourTextInputEditText = findViewById(R.id.yourTextInputEditText);
        secondTextInputEditText = findViewById(R.id.secondTextInputEditText);

        buttonAutomovil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAutomovil.setBackgroundColor(Color.parseColor("#FE0036"));
                buttonMotocicleta.setBackgroundColor(Color.TRANSPARENT);
                mostrarTextoBotonSeleccionado(buttonAutomovil);
            }
        });

        buttonMotocicleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonMotocicleta.setBackgroundColor(Color.parseColor("#FE0036"));
                buttonAutomovil.setBackgroundColor(Color.TRANSPARENT);
                mostrarTextoBotonSeleccionado(buttonMotocicleta);
            }
        });
    }



    public void showDatePickerDialog(View v) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Set the selected date to the EditText
                        yourTextInputEditText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, dayOfMonth);
        datePickerDialog.show();
    }

    public void showDatePickerDialog2(View v) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Set the selected date to the EditText
                        secondTextInputEditText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, dayOfMonth);
        datePickerDialog.show();
    }
    private void mostrarTextoBotonSeleccionado(Button button) {
        String textoBoton = button.getText().toString();
        // Aquí puedes hacer lo que quieras con el texto del botón seleccionado, como mostrarlo en un Toast o asignarlo a una variable.
        Toast.makeText(MainActivity.this, "Botón seleccionado: " + textoBoton, Toast.LENGTH_SHORT).show();
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
