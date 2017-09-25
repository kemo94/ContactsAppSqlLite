package kemo.example.com.contactsapp;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactItem {

    private String name ;
    private String number ;
    private String address ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
