package kemo.example.com.contactsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView contactRecycler;


    private ContactOperations contactOperations;
    ArrayList<ContactItem> contactItems ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactOperations = new ContactOperations(this);
        try {
            contactOperations.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        contactRecycler = (RecyclerView) findViewById(R.id.contact_recycler);

        contactItems = contactOperations.getContacts();
        ContactsAdapter contactsAdapter = new ContactsAdapter(contactItems);

        contactRecycler.setAdapter(contactsAdapter);
    }
}
