package kemo.example.com.contactsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;


public class ContactOperations {

    private DataBaseWrapper dbHelper;

    private SQLiteDatabase database;

    public ContactOperations(Context context) {

        dbHelper = new DataBaseWrapper(context);

    }

    public void open() throws SQLException {

        database = dbHelper.getWritableDatabase();

    }
    public void close() {

        dbHelper.close();

    }

    public void addContact(String name , String address , String number) {
        ContentValues values = new ContentValues();

        values.put(DataBaseWrapper.NAME, name);
        values.put(DataBaseWrapper.ADDRESS, address);
        values.put(DataBaseWrapper.NUMBER, number);
        database.insert(DataBaseWrapper.TABLE_NAME, null, values);

    }

    public ArrayList<ContactItem> getContacts() {
        ArrayList<ContactItem> contactItemsList = new ArrayList<ContactItem>();

        Cursor cursor = database.query(DataBaseWrapper.TABLE_NAME,

                null, null , null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            ContactItem contactItem = parseContact(cursor);
            contactItemsList.add(contactItem);

            cursor.moveToNext();

        }
        cursor.close();
        return contactItemsList;

    }

    private ContactItem parseContact(Cursor cursor) {

        ContactItem contactItem = new ContactItem();

        contactItem.setNumber(cursor.getString(0));
        contactItem.setAddress(cursor.getString(1));
        contactItem.setName(cursor.getString(2));

        return contactItem;

    }

}
