package com.info.pellesam.securityproject.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.info.pellesam.securityproject.Database.CategoryDB;
import com.info.pellesam.securityproject.Entity.Category;
import com.info.pellesam.securityproject.Entity.Item;

import java.util.ArrayList;

/**
 * Created by pellesam on 05/10/2017.
 */

public class CategoryDataSource {

    // Database fields
    private SQLiteDatabase database;
    private CategoryDB dbHelper;
    private String[] allColumns = { CategoryDB.TITLE_CATEGORY,CategoryDB.TITLE_ITEM, CategoryDB.URL_LOGO_ITEM, CategoryDB.URL_IMAGE_ITEM,CategoryDB.REGLE_ITEM,CategoryDB.DESCRIPTION_ITEM };
    public CategoryDataSource(Context context) {
        dbHelper = new CategoryDB(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }

    public Category createCategory(String title_category,String title_item, String url_logo_item, String url_image_item, String regle_item, String description_item) {
        ContentValues values = new ContentValues();
        values.put(CategoryDB.TITLE_CATEGORY, title_category);
        values.put(CategoryDB.TITLE_ITEM, title_item);
        values.put(CategoryDB.URL_LOGO_ITEM, url_logo_item);
        values.put(CategoryDB.URL_IMAGE_ITEM, url_image_item);
        values.put(CategoryDB.REGLE_ITEM, regle_item);
        values.put(CategoryDB.DESCRIPTION_ITEM, description_item);
        database.insert(CategoryDB.CATEGORY_TABLE_NAME, null,
                values);
        Cursor cursor = database.query(CategoryDB.CATEGORY_TABLE_NAME,
                allColumns, CategoryDB.TITLE_CATEGORY + " = \"" +title_category+"\"", null, null, null, null);
        cursor.moveToFirst();
        Category newCategory = cursorToCategory(cursor);
        cursor.close();
        return newCategory;
    }

    public ArrayList<String> getAllCategoriesTitle() {
        ArrayList<String> categoriesTitles = new ArrayList<String>();
        Cursor cursor = database.rawQuery("SELECT DISTINCT "+CategoryDB.TITLE_CATEGORY+" FROM "+CategoryDB.CATEGORY_TABLE_NAME,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String categoriesTitle = cursorToString(cursor);
            categoriesTitles.add(categoriesTitle);
            cursor.moveToNext();
        }
        cursor.close();
        return categoriesTitles;
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categories = new ArrayList<Category>();
        ArrayList<String> categoriesTitles = getAllCategoriesTitle();
        for(int i =0; i< categoriesTitles.size();i++) {
            ArrayList<Item> items = new ArrayList<Item>();
            Cursor cursor = database.query(CategoryDB.CATEGORY_TABLE_NAME,
                    allColumns, null, null, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Category category = cursorToCategory(cursor);
                if (category.getTitle().equals(categoriesTitles.get(i))) {
                    items.add(category.getItems().get(0));
                }
                cursor.moveToNext();
            }
            Category finalCategory = new Category();
            finalCategory.setTitle(categoriesTitles.get(i));
            finalCategory.setItems(items);
            categories.add(finalCategory);
            cursor.close();
        }
        return categories;
    }

    private Category cursorToCategory(Cursor cursor) {
        Category category = new Category();
        Item item = new Item();
        category.setTitle(cursor.getString(0));
        item.setTitle(cursor.getString(1));
        item.setUrlLogo(cursor.getString(2));
        item.setUrlImage(cursor.getString(3));
        item.setRegle(cursor.getString(4));
        item.setDescription(cursor.getString(5));
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item);
        category.setItems(items);
        return category;
    }

    private String cursorToString(Cursor cursor) {
        String string = new String();
        string = cursor.getString(0);
        return string;
    }

    public void deleteCategory(Category category) {
        database.delete(CategoryDB.CATEGORY_TABLE_NAME, CategoryDB.TITLE_CATEGORY
                + " = \"" + String.valueOf(category.getTitle())+"\"", null);
    }

    public void deleteAll() {
        database.delete(CategoryDB.CATEGORY_TABLE_NAME, "1", null);
    }
}
