package com.example.genui_sqlite;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.genui_sqlite.DB.MyDbHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class AgregarRegistroActivity extends AppCompatActivity {

    //View
    private CircleImageView profileIv;
    private EditText nameEt;
    private Spinner modaEt;
    private EditText direEt;
    private Spinner locaEt;
    private Spinner zonaEt;
    private EditText phoneEt;
    private EditText faceEt;
    private EditText instaEt;
    private EditText linkeEt;
    private EditText descriEt;
    private FloatingActionButton saveBtn;
    private Spinner cateEt;
    private Spinner modaateEt;
    private Spinner deliEt;
    private Spinner producEt;
    private RadioButton radioprofe;
    private RadioButton radioempre;
    private RadioGroup radio_grup;
    //Actionbar
    //private ActionBar actionBar;
    //Permiso de la clase Constants
    private  static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;
    //selección de imagen Constants
    private static final int IMAGE_PICK_CAMERA_CODE = 102;
    private static final int IMAGE_PICK_GALLERY_CODE = 103;
    // matrices de permisos
    private String[] cameraPermissions; // cámara y almacenamiento
    private String [] storagePermissions;// solo almacenamiento
    // variables (constain datos para guardar)
    private Uri imageUri;
    private String name;
    private int id_user;
    private String regis;
    private String cate;
    private String moda;
    private String moda_ate;
    private String deli;
    private String produc;
    private String dire;
    private String loca;
    private String zona;
    private String phone;
    private String face;
    private String insta;
    private String linke;
    private String descri;
    private String estado;

    int consulta;

    //db helper
    private MyDbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_registro);
        Bundle bundle= getIntent().getExtras();
        consulta=bundle.getInt("iduser");
        radio_grup = (RadioGroup) findViewById(R.id.radio_grup);
        radioprofe=(RadioButton) findViewById(R.id.radioprofe);
        radioempre=(RadioButton) findViewById(R.id.radioempre);
        cateEt=(Spinner)findViewById(R.id.cateEt);
        modaEt=(Spinner)findViewById(R.id.modaEt);
        locaEt=(Spinner)findViewById(R.id.locaEt);
        zonaEt=(Spinner)findViewById(R.id.zonaEt);
        modaateEt=(Spinner)findViewById(R.id.modaateEt);
        deliEt=(Spinner)findViewById(R.id.deliEt);
        producEt=(Spinner)findViewById(R.id.producEt);
        String[] opciones3 = {"Modalidad de Servicio", "A Domicilio", "Remota (Teleconsulta)", "En Oficina/Consultorio", "A Domicilio/Remota (Teleconsulta)",
                "A Domicilio/Remota (Teleconsulta)/En Oficina/Consultorio", "A Domicilio/En Oficina/Consultorio", "Remota (Teleconsulta)/En Oficina/Consultorio"};
        String [] opciones4={"Localidad", "El Cármen", "Humahuaca", "La Quiaca", "Libertador Gral. San Martín", "Palpalá", "Perico",
                "Purmamarca", "San Antonio", "San Salvador de Jujuy", "San Pedro de Jujuy", "Tilcara"};
        String [] opciones5={"Zona de la Localidad", "Norte", "Sur", "Este", "Oeste", "Centro"};
        String [] opciones6={"Modalidad de atención", "Local físico", "Tienda virtual", "Tienda Virtual/Local Fisico"};
        String [] opciones7={"Delivery", "Si", "No"};
        String [] opciones8={"¿Comercias alguno de estos productos?", "Sin TACC", "Contra el Covid-19", "Eco Productos (mejorar el medio ambiente)"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter <String> (this, R.layout.spner_item_color,opciones3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter <String> (this, R.layout.spner_item_color,opciones4);
        ArrayAdapter<String> adapter5 = new ArrayAdapter <String> (this, R.layout.spner_item_color,opciones5);
        ArrayAdapter<String> adapter6= new ArrayAdapter<String> (this, R.layout.spner_item_color,opciones6);
        ArrayAdapter<String> adapter7= new ArrayAdapter<String> (this, R.layout.spner_item_color,opciones7);
        ArrayAdapter<String> adapter8= new ArrayAdapter<String> (this, R.layout.spner_item_color, opciones8);
        modaEt.setAdapter(adapter3);
        locaEt.setAdapter(adapter4);
        zonaEt.setAdapter(adapter5);
        modaateEt.setAdapter(adapter6);
        deliEt.setAdapter(adapter7);
        producEt.setAdapter(adapter8);
        //Inicializacion
        //actionBar = getSupportActionBar();
        //Titulo
        //actionBar.setTitle("Agregar Registro");
        //Boton Negro
        //actionBar.setDisplayHomeAsUpEnabled(true);
        //actionBar.setDisplayShowHomeEnabled(true);

        profileIv = findViewById(R.id.profileIv);
        nameEt = findViewById(R.id.nameEt);
        cateEt = findViewById(R.id.cateEt);
        modaEt = findViewById(R.id.modaEt);
        locaEt = findViewById(R.id.locaEt);
        zonaEt = findViewById(R.id.zonaEt);
        direEt = findViewById(R.id.direEt);
        phoneEt = findViewById(R.id.phoneEt);
        faceEt = findViewById(R.id.faceEt);
        instaEt = findViewById(R.id.instaEt);
        linkeEt = findViewById(R.id.linkeEt);
        descriEt = findViewById(R.id.descriEt);
        saveBtn = findViewById(R.id.saveBtn);
        modaEt.setEnabled(false);
        modaateEt.setEnabled(false);
        deliEt.setEnabled(false);
        producEt.setEnabled(false);


        //Inicializar BD Helper
        dbHelper = new MyDbHelper(this);

        //Inicializamos Permisos arrays
        cameraPermissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        profileIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // muestra el cuadro de diálogo de selección de imagen
                imagePickDialog();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputData();
            }
        });
    }

    public void radioprofe (View view){
        String[] opciones1 = {"Categoria", "Asesoramiento Contable y Legal", "Asesoramiento Inmobiliario", "Belleza y Cuidado Personal", "Comunicación y Diseño",
                "Cursos y Clases", "Delivery", "Fiestas y Eventos", "Fotografía, Música y Cine", "Hogar y Construcción", "Higiene y Seguridad",
                "Imprenta", "Mantenimiento de Vehículos", "Medicina, Salud y Asistentes Domiciliarios", "Mecánico automotriz", "Prestamo", "Ropa y Moda",
                "Servicios para Mascotas", "Servicios para Oficinas", "Servicios de Traducción", "Tecnología", "Transporte", "Viajes y Turismo", "Arte"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter <String> (this, R.layout.spner_item_color,opciones1);
        cateEt.setAdapter(adapter1);
        modaEt.setEnabled(true);
        modaateEt.setEnabled(false);
        deliEt.setEnabled(false);
        producEt.setEnabled(false);
        regis="0";
        id_user= consulta;
    }


    public void radioempre (View view){
        String[] opciones2 = {"Categoria", "Accesorios para Motos", "Accesorios para Vehículos", "Agro", "Alimentos y Bebidas", "Almohadones y tejidos en general",
                "Animales y Mascotas", "Antigüedades y Colecciones", "Arte, Librería y Mercería", "Artículos de limpieza", "Autos, Motos y Otros",
                "Bebés", "Belleza y Cuidado Personal", "Celulares y Teléfonos", "Computación", "Consolas y Videojuegos",
                "Cámaras y Accesorios", "Deportes y Fitness", "Electrodomésticos", "Electrónica, Audio y Video", "Entradas para Eventos",
                "Herramientas y Construcción", "Hogar, Muebles y Jardín", "Industrias y Oficinas", "Inmuebles", "Instrumentos Musicales",
                "Joyas y Relojes", "Juegos y Juguetes", "Libros, Revistas y Comics", "Música, Películas y Series", "Ropa y Accesorios",
                "Salud y Equipamiento Médico", "Souvenirs, Cotillón y Fiestas", "Alimentos Vegetarianos", "Marroquineria", "Fotografía/Videografía/Edición de Video"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spner_item_color, opciones2);
        cateEt.setAdapter(adapter2);
        modaEt.setEnabled(false);
        modaateEt.setEnabled(true);
        deliEt.setEnabled(true);
        producEt.setEnabled(true);
        regis="1";
        id_user=consulta;
    }

    private void inputData(){
        //get data

        name = ""+nameEt.getText().toString().trim();
        cate = ""+cateEt.getSelectedItem().toString().trim();
        moda = ""+modaEt.getSelectedItem().toString().trim();
        moda_ate= ""+modaateEt.getSelectedItem().toString().trim();
        deli= ""+deliEt.getSelectedItem().toString().trim();
        produc= ""+producEt.getSelectedItem().toString().trim();
        dire = ""+direEt.getText().toString().trim();
        loca = ""+locaEt.getSelectedItem().toString().trim();
        zona= ""+zonaEt.getSelectedItem().toString().trim();
        phone = ""+phoneEt.getText().toString().trim();
        face = ""+faceEt.getText().toString().trim();
        insta = ""+instaEt.getText().toString().trim();
        linke = ""+linkeEt.getText().toString().trim();
        descri = ""+descriEt.getText().toString().trim();
        estado="1";


        //guarda en la base de datos
        String timestamp = ""+System.currentTimeMillis();
        long id = dbHelper.insertRecord(
                ""+name,
                ""+id_user,
                ""+regis,
                ""+cate,
                ""+moda,
                ""+moda_ate,
                ""+deli,
                ""+produc,
                ""+dire,
                ""+loca,
                ""+zona,
                ""+phone,
                ""+face,
                ""+insta,
                ""+linke,
                ""+descri,
                ""+imageUri,
                ""+estado,
                ""+timestamp,
                ""+timestamp
        );

        Toast.makeText(this, "Registro agregado contra ID: "+id, Toast.LENGTH_SHORT).show();
    }
    private void imagePickDialog(){
        // opciones para mostrar en el diálogo
        String[] options = {"Camara", "Galeria"};
        //dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Titulo
        builder.setTitle("Seleccionar imagen");
        // establecer elementos / opciones
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // manejar clicks
                if (which==0){
                    //click en camara
                    if (!checkCameraPermission()){
                        requestCameraPermission();
                    }
                    else{
                        // permiso ya otorgado
                        PickFromCamera();
                    }

                }
                else if (which==1){
                    if (!checkStoragePermission()){
                        requestStoragePermission();
                    }
                    else{
                        // permiso ya otorgado
                        PickFromGallery();
                    }
                }
            }
        });

        // Crear / mostrar diálogo
        builder.create().show();
    }

    private void PickFromGallery() {
        // intento de elegir la imagen de la galería, la imagen se devolverá en el método onActivityResult
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, IMAGE_PICK_GALLERY_CODE);
    }

    private void PickFromCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Titulo de la Imagen");
        values.put(MediaStore.Images.Media.DESCRIPTION, "Descripción de la imagen");
        //put image Uri
        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        // Intento de abrir la cámara para la imagen
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, IMAGE_PICK_CAMERA_CODE);
    }

    private boolean checkStoragePermission(){
        //comprobar si el permiso de almacenamiento está habilitado o no
        boolean result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);

        return result;
    }

    private  void requestStoragePermission(){
        // solicita el permiso de almacenamiento
        ActivityCompat.requestPermissions(this, storagePermissions, STORAGE_REQUEST_CODE);
    }

    private boolean checkCameraPermission(){
        // verifica si el permiso de la cámara está habilitado o no
        boolean result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);

        return result && result1;
    }

    private void requestCameraPermission(){
        // solicita el permiso de la cámara
        ActivityCompat.requestPermissions(this, cameraPermissions, CAMERA_REQUEST_CODE);
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed(); //regrese haciendo clic en el botón de barra de acción
        return super.onSupportNavigateUp();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // resultado del permiso permitido / denegado

        switch (requestCode){
            case CAMERA_REQUEST_CODE:{
                if (grantResults.length>0){

                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if(cameraAccepted && storageAccepted){
                        // ambos permisos permitidos
                        PickFromCamera();
                    }
                    else{
                        Toast.makeText(this, "Se requieren permisos de cámara y almacenamiento", Toast.LENGTH_SHORT).show();
                    }
                }

            }
            break;
            case STORAGE_REQUEST_CODE:{
                if (grantResults.length>0){

                    // si se permite devolver verdadero de lo contrario falso
                    boolean storageAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (storageAccepted){
                        // permiso de almacenamiento permitido
                        PickFromGallery();
                    }
                    else{
                        Toast.makeText(this, "Se requiere permiso de almacenamiento", Toast.LENGTH_SHORT).show();
                    }
                }

            }
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //image picked from camera or gallery will be received hare
        super.onActivityResult(requestCode, resultCode, data);
        imageUri = data.getData();
        profileIv.setImageURI(imageUri);
    }

}