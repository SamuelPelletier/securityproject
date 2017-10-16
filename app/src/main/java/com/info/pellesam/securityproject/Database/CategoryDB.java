package com.info.pellesam.securityproject.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

public class CategoryDB extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SecurityProject.db";
    public static final String CATEGORY_TABLE_NAME = "category";
    public static final String TITLE_CATEGORY = "title";
    public static final String TITLE_ITEM = "title_item";
    public static final String URL_LOGO_ITEM = "url_logo_item";
    public static final String URL_IMAGE_ITEM = "url_image_item";
    public static final String REGLE_ITEM = "regle_item";
    public static final String DESCRIPTION_ITEM = "description_item";
    private static final String CATEGORY_TABLE_CREATE = "CREATE TABLE " + CATEGORY_TABLE_NAME + " (" + TITLE_CATEGORY + " TEXT, " + TITLE_ITEM + " TEXT," + URL_LOGO_ITEM + " TEXT," + URL_IMAGE_ITEM + " TEXT," + REGLE_ITEM + " TEXT," + DESCRIPTION_ITEM + " TEXT);";

    public CategoryDB(Context context)
    {
        super(context, Environment.getExternalStorageDirectory()+"/"+DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CATEGORY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_TABLE_NAME);
        onCreate(db);
    }
}
