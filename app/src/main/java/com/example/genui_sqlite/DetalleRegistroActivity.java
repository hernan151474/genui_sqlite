package com.example.genui_sqlite;

import static com.example.genui_sqlite.R.drawable.logochico;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.genui_sqlite.DB.MyDbHelper;

import java.util.Calendar;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;


public class DetalleRegistroActivity extends AppCompatActivity {

    //vistas
    private CircleImageView profileIv;
    private TextView nameTv,cateTv,modaTv, modaateTv, deliTv, producTv, direTv, locaTv, zonaTv, phoneTv, faceTv, instaTv, linkeTv, descriTv, addedTimeTv, updatedTimeTv;

    //ActionBar
    private ActionBar actionBar;

    //
    private String recordID;

    //BDHelper
    private MyDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_registro);

        //setting up actionbar with title and back button
        actionBar = getSupportActionBar();
        actionBar.setTitle("Detalle del Registro");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //obtener la identificación de registro del adaptador mediante la intención
        Intent intent = getIntent();
        recordID = intent.getStringExtra("RECORD_ID");

        //Inicializacion BD Helper Clase
        dbHelper = new MyDbHelper(this);

        //Inicializamos las vistas
        profileIv = findViewById(R.id.profileIv);
        descriTv = findViewById(R.id.descriTv);
        nameTv = findViewById(R.id.nameTv);
        cateTv = findViewById(R.id.cateTv);
        modaTv = findViewById(R.id.modaTv);
        modaateTv = findViewById(R.id.modaateTv);
        deliTv = findViewById(R.id.deliTv);
        producTv = findViewById(R.id.producTv);
        direTv = findViewById(R.id.direTv);
        locaTv = findViewById(R.id.locaTv);
        zonaTv = findViewById(R.id.zonaTv);
        phoneTv = findViewById(R.id.phoneTv);
        faceTv = findViewById(R.id.faceTv);
        instaTv = findViewById(R.id.instaTv);
        linkeTv = findViewById(R.id.linkeTv);
        addedTimeTv = findViewById(R.id.addedTimeTv);
        updatedTimeTv = findViewById(R.id.updateTimeTv);

        showRecordDetails();
    }

    private void showRecordDetails() {
        //obtener detalles de registro
        //consulta para seleccionar el registro basado en la identificación del registro
        String selectQuery = " SELECT * FROM " + Constants.TABLE_NAME + " WHERE " + Constants.C_ID +" =\""+ recordID+"\"";

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // mantener comprobando toda la base de datos para ese registro
        if (cursor.moveToFirst()){
            do {

                //Obtenner datos
                String id = ""+ cursor.getInt(cursor.getColumnIndex(Constants.C_ID));
                String name = ""+ cursor.getString(cursor.getColumnIndex(Constants.C_NAME));
                String cate = ""+cursor.getString(cursor.getColumnIndex(Constants.C_CATE));
                String moda = ""+cursor.getString(cursor.getColumnIndex(Constants.C_MODA));
                String moda_ate = ""+cursor.getString(cursor.getColumnIndex(Constants.C_MODA_ATE));
                String deli = ""+cursor.getString(cursor.getColumnIndex(Constants.C_DELI));
                String produc = ""+cursor.getString(cursor.getColumnIndex(Constants.C_PRODUC));
                String dire = ""+cursor.getString(cursor.getColumnIndex(Constants.C_DIRE));
                String loca = ""+cursor.getString(cursor.getColumnIndex(Constants.C_LOCA));
                String zona = ""+cursor.getString(cursor.getColumnIndex(Constants.C_ZONA));
                String phone = ""+ cursor.getString(cursor.getColumnIndex(Constants.C_PHONE));
                String face = ""+cursor.getString(cursor.getColumnIndex(Constants.C_FACE));
                String insta = ""+cursor.getString(cursor.getColumnIndex(Constants.C_INSTA));
                String linke = ""+cursor.getString(cursor.getColumnIndex(Constants.C_LINKE));
                String descri = ""+cursor.getString(cursor.getColumnIndex(Constants.C_DESCRI));
                String image = ""+ cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE));
                String timestampAdded = ""+ cursor.getString(cursor.getColumnIndex(Constants.C_ADDED_TIMESTAMP));
                String timestampUpdated = ""+ cursor.getString(cursor.getColumnIndex(Constants.C_UPDATED_TIMESTAMP));

                //Convertir marca de tiempo a dd/mm/yyyy hh:mm por ejemplo 10/04/2020 08:22 AM
                Calendar calendar1 = Calendar.getInstance(Locale.getDefault());
                calendar1.setTimeInMillis(Long.parseLong(timestampAdded));
                String timeAdded = ""+ DateFormat.format("dd/MM/yyyy hh:mm:aa", calendar1);

                Calendar calendar2 = Calendar.getInstance(Locale.getDefault());
                calendar2.setTimeInMillis(Long.parseLong(timestampUpdated));
                String timeupdated = ""+ DateFormat.format("dd/MM/yyyy hh:mm:aa", calendar2);


                //Establecer datos
                nameTv.setText(name);
                cateTv.setText(cate);
                modaTv.setText(moda);
                modaateTv.setText(moda_ate);
                deliTv.setText(deli);
                producTv.setText(produc);
                direTv.setText(dire);
                locaTv.setText(loca);
                zonaTv.setText(zona);
                phoneTv.setText(phone);
                faceTv.setText(face);
                instaTv.setText(insta);
                linkeTv.setText(linke);
                descriTv.setText(descri);
                addedTimeTv.setText(timeAdded);
                updatedTimeTv.setText(timeupdated);

                // si el usuario no adjunta la imagen, imageUri será nulo, por lo tanto,
                // configure una imagen predeterminada en ese caso
                if (image.equals("null")){
                    // no hay imagen en el registro, establecer predeterminado
                    profileIv = findViewById(R.drawable.logochico);
                }
                else {
                    // tener imagen en el registro
                    profileIv.setImageURI(Uri.parse(image));
                }


            }while(cursor.moveToNext());
        }
        db.close();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();//ir a la actividad anterior
        return super.onSupportNavigateUp();
    }
}