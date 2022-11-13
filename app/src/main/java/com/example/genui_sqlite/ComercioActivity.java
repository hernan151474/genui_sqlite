package com.example.genui_sqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.genui_sqlite.DB.MyDbHelper;
import com.example.genui_sqlite.databinding.ActivityHomeBinding;
import com.google.android.material.navigation.NavigationView;

public class ComercioActivity extends AppCompatActivity {

    private RecyclerView recordsRv;
    TextView count;
    int cantidad=0;



    //DB Helper
    private MyDbHelper dbHelper;

    ActionBar actionBar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercio);
        recordsRv = findViewById(R.id.recordsRv);
        count = (TextView) findViewById(R.id.count1);
        int numberOfColumns = 2;
        recordsRv.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        //Inicializamos db helper Clase
        dbHelper = new MyDbHelper(this);



        loadRecords();
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