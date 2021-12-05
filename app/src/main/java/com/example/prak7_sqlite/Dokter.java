package com.example.prak7_sqlite;

public class Dokter {
    private String _id, _nama, _id_dokter, _spesialis;
    public Dokter (String id, String nama, String id_dokter, String spesialis) {
        this._id = id;
        this._nama = nama;
        this._id_dokter = id_dokter;
        this._spesialis = spesialis;
    }
    public Dokter() {
    }
    public String get_id() {

        return _id;
    }
    public void set_id(String _id) {

        this._id = _id;
    }
    public String get_nama() {

        return _nama;
    }
    public void set_nama(String _nama) {

        this._nama = _nama;
    }
    public String get_id_dokter() {
        return _id_dokter;
    }
    public void set_id_dokter(String _id_dokter) {

        this._id_dokter = _id_dokter;
    }
    public String get_spesialis() {

        return _spesialis;
    }
    public void set_spesialis(String _spesialis) {
        this._spesialis = _spesialis;
    }
}
