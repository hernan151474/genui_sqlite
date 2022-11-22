package com.example.genui_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.genui_sqlite.DB.MyDbHelper;

public class AgregarUser extends AppCompatActivity {

    private EditText registrar_user, registrar_password, confirmar_password;
    private MyDbHelper dbHelper;
    private Button user_registrar;
    private String user, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_user);

        registrar_user = findViewById(R.id.registrar_user);
        registrar_password = findViewById(R.id.registrar_password);
        confirmar_password = findViewById(R.id.confirmar_password);
        dbHelper = new MyDbHelper(this);
    }

    public void registrar(View view) {
        String email_resgitrar = registrar_user.getText().toString();
        String password_registrar = registrar_password.getText().toString();
        String password_confirmar = confirmar_password.getText().toString();
        Intent registrar = new Intent(this, MainActivity.class);
        if (email_resgitrar.isEmpty() && password_registrar.isEmpty() && password_confirmar.isEmpty()) {
            Toast.makeText(this, "Ingrese un correo y una contraseña!!!", Toast.LENGTH_SHORT).show();
        } else {
            if (!email_resgitrar.isEmpty() && password_registrar.isEmpty() && password_confirmar.isEmpty()) {
                Toast.makeText(this, "Ingrese una contraseña y confirme contraseña!!!", Toast.LENGTH_SHORT).show();
            } else {
                if (!email_resgitrar.isEmpty() && password_registrar.contentEquals(password_confirmar)) {
                    user = "" + registrar_user.getText().toString().trim();
                    password = "" + registrar_password.getText().toString().trim();
                    dbHelper.insertUser(
                            "" + user,
                            "" + password
                    );
                    Toast.makeText(this, "Se Registro con Exito!!", Toast.LENGTH_SHORT).show();
                    startActivity(registrar);
                } else {
                    Toast.makeText(this, "No Coincide las Contraseñas, Ingrese Nuevamente", Toast.LENGTH_SHORT).show();
                    registrar_password.setText("");
                    confirmar_password.setText("");
                }
            }
        }
    }
}