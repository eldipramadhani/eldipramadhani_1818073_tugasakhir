package com.example.tugasakhir;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_anime";
    private static final String tb_anime = "tb_anime";
    private static final String tb_anime_id = "id";
    private static final String tb_anime_judul = "judul";
    private static final String tb_anime_durasi = "durasi";
    private static final String tb_anime_rating = "rating";
    private static final String tb_anime_rated = "rated";
    private static final String CREATE_TABLE_ANIME = "CREATE TABLE " +
            tb_anime + "("
            + tb_anime_id + " INTEGER PRIMARY KEY ,"
            + tb_anime_judul + " TEXT,"
            + tb_anime_durasi + " TEXT,"
            + tb_anime_rating + " TEXT " + ")"
            + tb_anime_rated + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ANIME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateAnime (Anime mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_anime_id, mdNotif.get_id());
        values.put(tb_anime_judul, mdNotif.get_judul());
        values.put(tb_anime_durasi, mdNotif.get_durasi());
        values.put(tb_anime_rating, mdNotif.get_rating());
        values.put(tb_anime_rated, mdNotif.get_rated());
        db.insert(tb_anime, null, values);
        db.close();
    }

    public List<Anime> ReadAnime() {
        List<Anime> judulModelList = new ArrayList<Anime>();
        String selectQuery = "SELECT * FROM " + tb_anime;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Anime mdKontak = new Anime();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_judul(cursor.getString(1));
                mdKontak.set_durasi(cursor.getString(2));
                mdKontak.set_rating(cursor.getString(3));
                mdKontak.set_rated(cursor.getString(4));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateAnime (Anime mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_anime_judul, mdNotif.get_judul());
        values.put(tb_anime_durasi, mdNotif.get_durasi());
        values.put(tb_anime_rating, mdNotif.get_rating());
        values.put(tb_anime_rated, mdNotif.get_rated());
        return db.update(tb_anime, values, tb_anime_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteAnime (Anime mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_anime, tb_anime_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}