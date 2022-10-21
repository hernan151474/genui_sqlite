package com.example.genui_sqlite;

public class ModelRecord {
    //Variables
    String user, password, id,id_user, name, regis, cate, moda, moda_ate, deli, produc, dire, loca, zona, phone, face, insta, linke, descri, image, addedTime, updatedTime;

    //Constructor

    public ModelRecord(String id, String id_user, String name, String regis, String cate, String moda, String moda_ate, String deli, String produc, String dire, String loca,
                       String zona, String phone, String face, String insta, String linke, String descri, String image, String addedTime, String updatedTime) {
        this.id = id;
        this.id_user= id_user;
        this.name = name;
        this.regis = regis;
        this.cate = cate;
        this.moda = moda;
        this.moda_ate = moda_ate;
        this.deli = deli;
        this.produc = produc;
        this.dire = dire;
        this.loca = loca;
        this.zona = zona;
        this.phone = phone;
        this.face = face;
        this.insta = insta;
        this.linke = linke;
        this.descri =descri;
        this.image = image;
        this.addedTime = addedTime;
        this.updatedTime = updatedTime;

    }

    public void ModelRecordUser(String user, String password){
        this.user = user;
        this.password = password;
    }

    //Getter y Setter


    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getRegis() { return regis; }

    public void setRegis(String regis) { this.regis = regis; }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModa_ate() {
        return moda_ate;
    }

    public void setModa_ate(String moda_ate) {
        this.moda_ate = moda_ate;
    }

    public String getDeli() {
        return deli;
    }

    public void setDeli(String deli) {
        this.deli = deli;
    }

    public String getProduc() {
        return produc;
    }

    public void setProduc(String produc) {
        this.produc = produc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getModa() {
        return moda;
    }

    public void setModa(String moda) {
        this.moda = moda;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }

    public String getLoca() {
        return loca;
    }

    public void setLoca(String loca) {
        this.loca = loca;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getLinke() {
        return linke;
    }

    public void setLinke(String linke) {
        this.linke = linke;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(String addedTime) {
        this.addedTime = addedTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}
