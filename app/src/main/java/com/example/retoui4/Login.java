package com.example.retoui4;

import android.content.Intent;
import android.widget.Toast;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    TextView tvVerificador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void cambiarLayout(View view) {
        Intent intent = new Intent(this, CrearCuenta.class);
        startActivity(intent);
    }

    public void cambiarLayout2(View view) {
        IniciarSesion();
    }

    private void IniciarSesion() {
        // Obtener el texto ingresado en los EditText
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("usuario", email);
            jsonBody.put("password", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        new FetchDataTask().execute(jsonBody.toString());
    }

    private class FetchDataTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String jsonData = params[0];
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL("https://apionlypark.onrender.com/api/login/user");
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);
                connection.getOutputStream().write(jsonData.getBytes());
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            if (response != null) {
                // Mostrar un Toast indicando que el inicio de sesión fue exitoso
                Toast.makeText(Login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            } else {

                // Mostrar un Toast indicando que hubo un error al iniciar sesión
                Toast.makeText(Login.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
