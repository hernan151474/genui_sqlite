package com.example.genui_sqlite;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.example.genui_sqlite.DB.MyDbHelper;
import com.example.genui_sqlite.ui.posteo.PosteoFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.genui_sqlite.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;
    MyDbHelper dbHelper;
    Button button2;
    int consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new MyDbHelper(this);
        int consulta = dbHelper.ConsultaUser();
        Intent intent=getIntent();
        intent.putExtra("iduser", (Integer) consulta);
        Bundle bundle= getIntent().getExtras();
        int home=bundle.getInt("home");
        consulta=bundle.getInt("iduser");




        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        button2= (Button) findViewById(R.id.button2);

        if(home==0){
            button2.setVisibility(View.INVISIBLE);
        } else if (home==1){
            button2.setVisibility(View.VISIBLE);
        }

        setSupportActionBar(binding.appBarHome.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_contacto, R.id.nav_posteos)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



    public void Oficio (View view){
        Intent oficio = new Intent(this, OficioActivity.class);
        startActivity(oficio);
    }

    public void Comercio (View view){
        Intent comercio = new Intent(this, ComercioActivity.class);
        startActivity(comercio);
    }

    public void registrar_genui (View view){
        Bundle bundle= getIntent().getExtras();
        consulta=bundle.getInt("iduser");
        Intent registrar_genui = new Intent (this, AgregarRegistroActivity.class);
        registrar_genui.putExtra("iduser", (Integer) consulta);
        startActivity(registrar_genui);
    }

    public void Objetivo (View view){
        Intent objetivo = new Intent(this, ObjetivosActivity.class);
        startActivity(objetivo);
    }

    public void Genui (View view){
        Intent genui = new Intent(this, Que_es_Genui.class);
        startActivity(genui);
    }

    public void Valor (View view){
        Intent valor = new Intent(this, Valor.class);
        startActivity(valor);
    }

    public void Vision_Hitos (View view){
        Intent vision_hitos = new Intent(this, Vision_Hitos.class);
        startActivity(vision_hitos);
    }

    public void Foco_Alcance (View view){
        Intent foco_alcance = new Intent(this, Foco_Alcance.class);
        startActivity(foco_alcance);
    }
}