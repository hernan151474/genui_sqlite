package com.example.genui_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.genui_sqlite.DB.MyDbHelper;

public class RecuperarPassword extends AppCompatActivity {
    private EditText email_recuperar, nuevopass_recuperar, confirmarpass_recuperar;
    private MyDbHelper dbHelper;
    private Button enviar_recuperar;
    private String user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_password);

        email_recuperar = findViewById(R.id.email_recuperar);
        nuevopass_recuperar = findViewById(R.id.nuevopass_recuperar);
        confirmarpass_recuperar = findViewById(R.id.confirmarpass_recuperar);
        dbHelper = new MyDbHelper(this);
    }

    public void recuperar(View view) {
        String email = email_recuperar.getText().toString();
        String recuperar_pass = nuevopass_recuperar.getText().toString();
        String confi_recuperar_pass = confirmarpass_recuperar.getText().toString();
        Intent recuperar = new Intent(this, MainActivity.class);
        if (email.isEmpty() && recuperar_pass.isEmpty() && confi_recuperar_pass.isEmpty()) {
            Toast.makeText(this, "Ingrese un correo y una contraseña!!!", Toast.LENGTH_SHORT).show();
        } else {
            if (!email.isEmpty() && recuperar_pass.isEmpty() && confi_recuperar_pass.isEmpty()) {
                Toast.makeText(this, "Ingrese una contraseña y confirme contraseña!!!", Toast.LENGTH_SHORT).show();
            } else {
                String user = email;
                Boolean checkusername = dbHelper.checkusername(user);
                if (checkusername==true && recuperar_pass.contentEquals(confi_recuperar_pass)) {
                    password = "" + nuevopass_recuperar.getText().toString().trim();
                    dbHelper.onUpgradeUser(
                            "" + user,
                            "" + password
                    );
                    Toast.makeText(this, "Se Modifico con Exito!!", Toast.LENGTH_SHORT).show();
                    startActivity(recuperar);
                } else {
                    Toast.makeText(this, "No Coincide las Contraseñas, Ingrese Nuevamente", Toast.LENGTH_SHORT).show();
                    nuevopass_recuperar.setText("");
                    confirmarpass_recuperar.setText("");
                }
            }
        }

    }
}