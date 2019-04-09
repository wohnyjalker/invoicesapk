package com.example.invoices;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.invoices.adapters.InvoicesRecycleAdapter;
import com.example.invoices.models.Invoice;
import com.example.invoices.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class invoices_fragment extends Fragment implements InvoicesRecycleAdapter.OnInvoiceListener {
    private static final String TAG = "Faktury";

    //UI
    private RecyclerView mRecyclerView;

    //VAR
    private ArrayList<Invoice> mInvoices = new ArrayList<>();
    private InvoicesRecycleAdapter mInvoicesRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.invoices_fragment, container, false);

        //Invoice invoice = new Invoice("1", "Agat", "12-01-2019", "4000");
        //Log.d(TAG, "onCreateView: invoice " + invoice.toString());
        mRecyclerView = view.findViewById(R.id.recycleView);

        initRecyclerView();
        insertFakeInvoices();
        return view;



    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //decorator z /util/VerticalSpacingItemDecorator
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mInvoicesRecyclerAdapter = new InvoicesRecycleAdapter(mInvoices, this);
        mRecyclerView.setAdapter(mInvoicesRecyclerAdapter);
        // vertical default decorator decorator
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));


    }

    private void insertFakeInvoices(){
        for(int i=1; i<31; i++){
            Invoice invoice = new Invoice();
            invoice.setNumber(Integer.toString(i));
            invoice.setDate(Integer.toString(i*10) + ".2019");
            invoice.setRecipient("Faktura #" + Integer.toString(i));
            invoice.setValue(Integer.toString(i*100) + "PLN");
            mInvoices.add(invoice);
        }
        mInvoicesRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onInvoiceClick(int i) {
        //Toast.makeText(getContext(),"faktura " + Integer.toString(i), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), InvoiceActivity.class);
        intent.putExtra("selected_invoice", mInvoices.get(i));
        startActivity(intent);
    }
}
