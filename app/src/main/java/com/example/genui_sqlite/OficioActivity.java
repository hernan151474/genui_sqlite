package com.example.genui_sqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.genui_sqlite.DB.MyDbHelper;

public class OficioActivity extends AppCompatActivity {

    private RecyclerView recordsRv;
    TextView count;
    int cantidad=0;
    int consulta;



    //DB Helper
    private MyDbHelper dbHelper;
    SearchView searchview3;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficio);
        recordsRv = findViewById(R.id.recordsRv);
        count = (TextView) findViewById(R.id.count2);
        searchview3=(SearchView) findViewById(R.id.searchView3);
        int numberOfColumns = 2;
        recordsRv.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        Bundle bundle= getIntent().getExtras();
        consulta=bundle.getInt("iduser");

        //Inicializamos db helper Clase
        dbHelper = new MyDbHelper(this);

        loadRecords();

        searchview3.setQueryHint("Buscar");

        searchview3.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                searchRecords(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchRecords(newText);
                return false;
            }
        });

    }

    private void searchRecords(String query){
        AdapterRecord adapterRecord = new AdapterRecord(OficioActivity.this,
                dbHelper.searchRecords1(query));

        recordsRv.setAdapter(adapterRecord);

    }

    private void loadRecords(){


        AdapterPosteo adapterRecord = new AdapterPosteo(OficioActivity.this,
                dbHelper.getAllRecords1(Constants.C_ADDED_TIMESTAMP + " DESC"));

        recordsRv.setAdapter(adapterRecord);

        //Establecer el numero de Registros
        cantidad=dbHelper.getRecordsCountPosteo(consulta);
        count.setText(String.valueOf(cantidad));
    }

    @Override
    protected void onResume(){
        super.onResume();
        loadRecords();// Refresca o actualiza la lista de registros
    }
}