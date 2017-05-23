package com.example.kirchhoff.rxexample.ui.pagination;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kirchhoff.rxexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirchhoff-
 */

public class PaginationAdapter extends RecyclerView.Adapter<PaginationAdapter.ItemViewHolder> {

    List<String> items = new ArrayList<>();

    public PaginationAdapter() {
    }

    void addItems(List<String> items) {
        this.items.addAll(items);
    }


    @Override
    public PaginationAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.r_pagination, parent, false));
    }

    @Override
    public void onBindViewHolder(PaginationAdapter.ItemViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);
        }

        void bind(String text) {
            ((TextView) itemView).setText(text);
        }
    }
}
