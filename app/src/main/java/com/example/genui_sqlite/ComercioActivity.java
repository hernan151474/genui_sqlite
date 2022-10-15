package com.example.genui_sqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.example.genui_sqlite.DB.MyDbHelper;

public class ComercioActivity extends AppCompatActivity {

    private RecyclerView recordsRv;



    //DB Helper
    private MyDbHelper dbHelper;

    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercio);
        recordsRv = findViewById(R.id.recordsRv);
        int numberOfColumns = 2;
        recordsRv.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        //Inicializamos db helper Clase
        dbHelper = new MyDbHelper(this);

        //Inicializacion ActionBar
        actionBar = getSupportActionBar();
        actionBar.setTitle("Registros");

        loadRecords();
    }

    private void loadRecords(){
        AdapterRecord adapterRecord = new AdapterRecord(ComercioActivity.this,
                dbHelper.getAllRecords(Constants.C_ADDED_TIMESTAMP + " DESC"));

        recordsRv.setAdapter(adapterRecord);

        //Establecer el numero de Registros
        actionBar.setSubtitle("Total: "+dbHelper.getRecordsCount());
    }

    @Override
    protected void onResume(){
        super.onResume();
        loadRecords();// Refresca o actualiza la lista de registros
    }
}