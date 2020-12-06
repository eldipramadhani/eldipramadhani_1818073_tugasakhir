package com.example.tugasakhir;

public class Anime {
    private String _id, _judul, _durasi, _rating, _rated;
    public Anime (String id, String judul, String durasi, String rating, String rated) {
        this._id = id;
        this._judul = judul;
        this._durasi = durasi;
        this._rating = rating;
        this._rated = rated;
    }
    public Anime() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_judul() {
        return _judul;
    }
    public void set_judul(String _judul) {
        this._judul = _judul;
    }
    public String get_durasi() {
        return _durasi;
    }
    public void set_durasi(String _durasi) {
        this._durasi = _durasi;
    }
    public String get_rating() {
        return _rating;
    }
    public void set_rating(String _rating) {
        this._rating = _rating;
    }
    public String get_rated() {
        return _rated;
    }
    public void set_rated(String _rated) {
        this._rated = _rated;
    }
}