package com.example.invoices.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Invoice implements Parcelable {
    private String number;
    private String recipient;
    private String date;
    private String value;

    public Invoice(String number, String recipient, String date, String value) {
        this.number = number;
        this.recipient = recipient;
        this.date = date;
        this.value = value;
    }

    public Invoice() {
    }

    protected Invoice(Parcel in) {
        number = in.readString();
        recipient = in.readString();
        date = in.readString();
        value = in.readString();
    }

    public static final Creator<Invoice> CREATOR = new Creator<Invoice>() {
        @Override
        public Invoice createFromParcel(Parcel in) {
            return new Invoice(in);
        }

        @Override
        public Invoice[] newArray(int size) {
            return new Invoice[size];
        }
    };

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "number='" + number + '\'' +
                ", recipient='" + recipient + '\'' +
                ", date='" + date + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(number);
        dest.writeString(recipient);
        dest.writeString(date);
        dest.writeString(value);
    }
}
