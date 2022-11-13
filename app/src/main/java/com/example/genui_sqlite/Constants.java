package com.example.genui_sqlite;

public class Constants {
    // nombre base de datos
    public static final String DB_NAME = "My_RECORDS_DB";
    //version de base de datos

    public static final int DB_VERSION = 1;

    //nombre de la tabla
    public static final String TABLE_NAME = "MY_RECORDS_TABLE";
    public static final String TABLE_USER = "USER";
    //columnas/campos de la tabla
    public static final String C_USER = "USER";
    public static final String C_PASSWORD = "PASSWORD";
    public static final String C_ID = "ID";
    public static final String C_IDUSER = "IDUSER";
    public static final String C_ID_USER = "ID_USER";
    public static final String C_NAME = "NOMBRE";
    public static final String C_REGIS = "REGISTRO";
    public static final String C_CATE= "CATEGORIA";
    public static final String C_MODA = "MODALIDAD_DE_SERVICIO";
    public static final String C_MODA_ATE = "MODALIDAD_DE_ATENCION";
    public static final String C_DELI= "DELIVERY";
    public static final String C_PRODUC ="PRODUCTO";
    public static final String C_DIRE = "DIRECCION";
    public static final String C_LOCA = "LOCALIDAD";
    public static final String C_ZONA = "ZONA_DE_LA_LOCALIDAD";
    public static final String C_PHONE = "PHONE";
    public static final String C_FACE = "FACEBOOK";
    public static final String C_INSTA = "INSTAGRAM";
    public static final String C_LINKE = "LINKEDLN";
    public static final String C_DESCRI = "DESCRIPCION";
    public static  final String C_IMAGE = "IMAGE";
    public static final String C_ESTADO= "ESTADO";
    public static final String C_ADDED_TIMESTAMP = "ADDED_TIME_STAMP";
    public static final String C_UPDATED_TIMESTAMP = "UPDATED_TIME_STAMP";


    //Crea la tabla Query
    public static final String CREATE_USER = "CREATE TABLE " + TABLE_USER +"("
            +C_IDUSER + " INTEGER PRIMARY KEY,"
            +C_USER + " TEXT UNIQUE,"
            +C_PASSWORD+ " TEXT"
            +")";

    public static  final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +"("
            + C_ID+ " INTEGER PRIMARY KEY,"
            + C_ID_USER+ " INTEGER,"
            + C_NAME+ " TEXT,"
            + C_REGIS+ " TEXT,"
            + C_CATE+ " TEXT,"
            + C_MODA+ " TEXT,"
            + C_MODA_ATE+ " TEXT,"
            + C_DELI+ " TEXT,"
            + C_PRODUC+ " TEXT,"
            + C_DIRE+ " TEXT,"
            + C_LOCA+ " TEXT,"
            + C_ZONA+ " TEXT,"
            + C_PHONE+ " TEXT,"
            + C_FACE+ " TEXT,"
            + C_INSTA+ " TEXT,"
            + C_LINKE+ " TEXT,"
            + C_DESCRI+ " TEXT,"
            + C_IMAGE+ " TEXT,"
            + C_ESTADO+ " TEXT,"
            + C_ADDED_TIMESTAMP+ " TEXT,"
            + C_UPDATED_TIMESTAMP+ " TEXT,"
            + " FOREIGN KEY(" +C_ID_USER+ ") REFERENCES " +TABLE_USER+ "(" +C_IDUSER+"))";
}