package com.example.invoices.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.invoices.R;
import com.example.invoices.models.Invoice;

import java.util.ArrayList;

public class InvoicesRecycleAdapter extends RecyclerView.Adapter<InvoicesRecycleAdapter.ViewHolder> {

    private ArrayList<Invoice> mInvoices = new ArrayList<>();

    public InvoicesRecycleAdapter(ArrayList<Invoice> mInvoices) {
        this.mInvoices = mInvoices;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_invoice_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.numberTextView.setText(mInvoices.get(i).getNumber());
        viewHolder.recipientTextView.setText(mInvoices.get(i).getRecipient());
        viewHolder.valueTextView.setText(mInvoices.get(i).getValue());
        viewHolder.dateTextView.setText(mInvoices.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        return mInvoices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView numberTextView, recipientTextView, dateTextView, valueTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numberTextView = itemView.findViewById(R.id.invoiceNumber);
            recipientTextView = itemView.findViewById(R.id.invoiceRecipient);
            dateTextView = itemView.findViewById(R.id.invoiceDate);
            valueTextView = itemView.findViewById(R.id.invoiceValue);
        }
    }
}
