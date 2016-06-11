package com.gaurav.myreminder.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Gaurav Mathur on 29-May-16.
 */
public class BaseDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME = "MyReminder";

    /* Declaration of Table */
    private static final String CREATE_TABLE_USER_DETAIL = "create table user_detail " +
            "(id integer primary key, name text,phone text,email text, username text,place text)";

    private static final String CREATE_TABLE_USER_CREDENTIAL = "create table user_credential " +
            "(id integer primary key,phone text,email text, password text)";

    public BaseDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER_DETAIL);
        db.execSQL(CREATE_TABLE_USER_CREDENTIAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user_detail");
        db.execSQL("DROP TABLE IF EXISTS user_credential");
    }

    public boolean insertUserDetail(String name, String phone, String email, String username,String place)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", name);
            contentValues.put("phone", phone);
            contentValues.put("email", email);
            contentValues.put("username", username);
            contentValues.put("place", place);
            db.insertOrThrow("user_detail", null, contentValues);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return false;
        }
    }

    public boolean insertLocalUserCredential(String email, String phone, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("phone", phone);
            contentValues.put("email", email);
            contentValues.put("password", password);
            db.insertOrThrow("user_credential", null, contentValues);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return false;
        }
    }

    public Cursor validateUser(String cred,String email, String phone) throws SQLException {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCursor =
                db.rawQuery("SELECT * FROM user_credential WHERE password = ? AND (email = ? OR phone = ?)", new String[]{cred,email,phone});
        if(mCursor != null)
        {
            mCursor.moveToFirst();
        }

        return mCursor;

    }

    public Cursor getUser(String email, String phone) throws SQLException {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCursor =
                db.rawQuery("SELECT * FROM user_credential WHERE email = ? OR phone = ?", new String[]{email,phone});
        if(mCursor != null)
        {
            mCursor.moveToFirst();
        }

        return mCursor;
    }
}
