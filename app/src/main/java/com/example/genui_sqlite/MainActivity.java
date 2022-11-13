package com.example.genui_sqlite;

import static android.view.View.INVISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.genui_sqlite.DB.MyDbHelper;
import com.example.genui_sqlite.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    EditText usuario_inicio;
    EditText password_inicio;
    int consulta;
    Button login,button2;
    MyDbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario_inicio = (EditText) findViewById(R.id.usuario_inicio);
        password_inicio = (EditText) findViewById(R.id.password_inicio);
        login = (Button) findViewById(R.id.login);
        dbHelper = new MyDbHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario_inicio.getText().toString();
                String password = password_inicio.getText().toString();
                if(user.equals("")||password.equals(""))
                    Toast.makeText(MainActivity.this, "Por favor, introduzca todos los campos", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = dbHelper.checkusernamepassword(user, password);
                    if(checkuserpass==true){
                       int consulta = dbHelper.ConsultaUser();
                        Toast.makeText(MainActivity.this, "Inicio de sesión con éxito", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("iduser", (Integer) consulta);
                        intent.putExtra("home", (Integer) 1);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Credenciales no válidas", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


    public void Invitado(View view){
        Intent invitado = new Intent(this, Home.class);
        invitado.putExtra("home", (Integer) 0);
        startActivity(invitado);
    }

    public void Registrar(View view){
        Intent registrar = new Intent(this, AgregarUser.class);
        startActivity(registrar);
    }

    public void Recuperar(View view){
        Intent recuperar = new Intent(this, RecuperarPassword.class);
        startActivity(recuperar);
    }
}