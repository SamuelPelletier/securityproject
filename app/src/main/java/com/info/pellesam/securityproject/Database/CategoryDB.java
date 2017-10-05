package com.info.pellesam.securityproject.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import com.info.pellesam.securityproject.Entity.Item;

import java.util.ArrayList;

/**
 * Created by pellesam on 05/10/2017.
 */

public class CategoryDB extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyDB.db";
    public static final String CATEGORY_TABLE_NAME = "category";
    public static final String TITLE_CATEGORY = "title";
    public static final String TITLE_ITEM = "title_item";
    public static final String URL_LOGO_ITEM = "url_logo_item";
    public static final String URL_IMAGE_ITEM = "url_image_item";
    public static final String REGLE_ITEM = "regle_item";
    public static final String DESCRIPTION_ITEM = "description_item";
    private static final String CATEGORY_TABLE_CREATE = "CREATE TABLE " + CATEGORY_TABLE_NAME + " (" + TITLE_CATEGORY + " CHAR, " + TITLE_ITEM + " CHAR" + URL_LOGO_ITEM + " CHAR" + URL_IMAGE_ITEM + " CHAR" + REGLE_ITEM + " CHAR" + DESCRIPTION_ITEM + " CHAR);";
    public CategoryDB(Context context) {
        super(context, Environment.getExternalStorageDirectory()+"/"+DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CATEGORY_TABLE_NAME);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {db.execSQL("DROP TABLE IF EXISTS " +
            CATEGORY_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_TABLE_NAME);
        onCreate(db);
    }
}
