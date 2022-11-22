package com.example.genui_sqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.genui_sqlite.DB.MyDbHelper;

public class ComercioActivity extends AppCompatActivity {

    private RecyclerView recordsRv;
    TextView count;
    int cantidad=0;



    //DB Helper
    private MyDbHelper dbHelper;

    ActionBar actionBar;
    SearchView searchview2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercio);
        recordsRv = findViewById(R.id.recordsRv);
        count = (TextView) findViewById(R.id.count1);
        searchview2=(SearchView) findViewById(R.id.searchView2);
        int numberOfColumns = 2;
        recordsRv.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        //Inicializamos db helper Clase
        dbHelper = new MyDbHelper(this);



        loadRecords();


        searchview2.setQueryHint("Buscar");

        searchview2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

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
        AdapterRecord adapterRecord = new AdapterRecord(ComercioActivity.this,
                dbHelper.searchRecords(query));

        recordsRv.setAdapter(adapterRecord);

    }


    private void loadRecords(){
        AdapterRecord adapterRecord = new AdapterRecord(ComercioActivity.this,
                dbHelper.getAllRecords(Constants.C_ADDED_TIMESTAMP + " DESC"));

        recordsRv.setAdapter(adapterRecord);

        //Establecer el numero de Registros

        cantidad=dbHelper.getRecordsCount();
        count.setText(String.valueOf(cantidad));
    }


    @Override
    protected void onResume(){
        super.onResume();
        loadRecords();// Refresca o actualiza la lista de registros
    }
}