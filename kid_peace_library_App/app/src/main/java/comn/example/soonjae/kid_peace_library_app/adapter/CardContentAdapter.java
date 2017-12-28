package comn.example.soonjae.kid_peace_library_app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import comn.example.soonjae.kid_peace_library_app.R;

/**
 * Created by soonjae on 19/12/17.
 */
public class CardContentAdapter extends RecyclerView.Adapter<CardContentAdapter.ViewHolder> {

    // Set numbers of List in RecyclerView.
    private static final int LENGTH = 18;

    public CardContentAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // no-op
    }

    @Override
    public int getItemCount() {
        return LENGTH;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
        }
    }
}