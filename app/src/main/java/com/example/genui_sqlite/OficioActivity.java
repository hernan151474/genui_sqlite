package com.example.genui_sqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.genui_sqlite.DB.MyDbHelper;

public class OficioActivity extends AppCompatActivity {

    private RecyclerView recordsRv;
    TextView count;
    int cantidad=0;



    //DB Helper
    private MyDbHelper dbHelper;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficio);
        recordsRv = findViewById(R.id.recordsRv);
        count = (TextView) findViewById(R.id.count2);
        int numberOfColumns = 2;
        recordsRv.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        //Inicializamos db helper Clase
        dbHelper = new MyDbHelper(this);

        //Inicializacion ActionBar

    }

    private void loadRecords(){
        AdapterRecord adapterRecord = new AdapterRecord(OficioActivity.this,
                dbHelper.getAllRecords1(Constants.C_ADDED_TIMESTAMP + " DESC"));

        recordsRv.setAdapter(adapterRecord);

        //Establecer el numero de Registros
        cantidad=dbHelper.getRecordsCount1();
        count.setText(String.valueOf(cantidad));
    }

    @Override
    protected void onResume(){
        super.onResume();
        loadRecords();// Refresca o actualiza la lista de registros
    }
}