package kemo.example.com.contactsapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseWrapper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "Contacts";
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String NUMBER = "number";
    private static final String DATABASE_NAME = "Contacts.db";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE = "create table " + TABLE_NAME

            + "(" + NAME + " text primary key , "
            + ADDRESS + " text not null , "
            + NUMBER + " text not null );" ;

    public DataBaseWrapper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);

    }

}
