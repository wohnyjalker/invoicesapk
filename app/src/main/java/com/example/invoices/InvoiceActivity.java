package com.example.invoices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.invoices.models.Invoice;

public class InvoiceActivity extends AppCompatActivity {
    private static final String TAG = "InvoiceActivity";


    private Invoice mInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        TextView mValueTextView;
        TextView mInvoiceTitle;


        if (getIntent().hasExtra("selected_invoice")) {
            mInvoice = getIntent().getParcelableExtra("selected_invoice");
            Toast.makeText(this, "Faktura " + mInvoice.toString(), Toast.LENGTH_LONG).show();
            //Log.d(TAG, "onCreate: " + invoice.toString());
        }



        mInvoiceTitle = findViewById(R.id.invoiceTextTitle);
        mInvoiceTitle.setText(String.format("Faktura nr %s", mInvoice.getNumber()));

        mValueTextView = findViewById(R.id.valueTextView);
        mValueTextView.setText(mInvoice.getValue());
    }
}
