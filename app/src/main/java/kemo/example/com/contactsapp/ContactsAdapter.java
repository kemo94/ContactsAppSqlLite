package kemo.example.com.contactsapp;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {
    Activity activity;


    ArrayList<ContactItem> contactItems ;

    public ContactsAdapter(ArrayList<ContactItem> contactItems){
         this.contactItems = contactItems;
    }
    @Override
    public ContactsAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_contact, parent, false);

        return new ContactsAdapter.ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ContactsAdapter.ContactViewHolder holder, final int i) {
        holder.nameTxv.setText(contactItems.get(i).getName());
        holder.addressTxv.setText(contactItems.get(i).getAddress());
        holder.numberTxv.setText(contactItems.get(i).getNumber());

    }

    @Override
    public int getItemCount() {
        return contactItems.size();
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder   {

        //declaration
        public TextView nameTxv , numberTxv , addressTxv;
        public ContactViewHolder(View view) {
            super(view);
            nameTxv = (TextView) view.findViewById(R.id.name_txv);
            numberTxv = (TextView) view.findViewById(R.id.number_txv);
            addressTxv = (TextView) view.findViewById(R.id.address_txv);


        }
    }
}

