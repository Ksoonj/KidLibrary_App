package comn.example.soonjae.kid_peace_library_app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import comn.example.soonjae.kid_peace_library_app.R;

/**
 * Created by qtae on 17. 12. 13.
 */

public class CommentlistAdapter extends RecyclerView.Adapter<CommentlistAdapter.ViewHolder>{

    private static final int LENGTH = 10;



    @Override
    public CommentlistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentlistAdapter.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(CommentlistAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() { return LENGTH; }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.comment_list, parent, false));
        }
    }
}
