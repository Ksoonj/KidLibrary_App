package comn.example.soonjae.kid_peace_library_app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import comn.example.soonjae.kid_peace_library_app.R;

/**
 * Created by soonjae on 21/12/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Data> dataList;
    public static final int WithoutImage=0,WithImage=1;

    public RecyclerViewAdapter(List<Data> list){
        this.dataList=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case WithImage:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_board,parent,false);
                ImageViewHolder imageViewHolder=new ImageViewHolder(view);
                return imageViewHolder;

            case WithoutImage:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_boardimage,parent,false);
                WithoutImageViewHolder withoutImageViewHolder=new WithoutImageViewHolder(view);
                return withoutImageViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (dataList.get(position).viewtype){
            case WithImage:

                ((ImageViewHolder) holder).title.setText(dataList.get(position).title);
                ((ImageViewHolder) holder).contents.setText(dataList.get(position).about);
                break;
            case WithoutImage:
                ((WithoutImageViewHolder) holder).imageView.setImageResource(dataList.get(position).photo);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position).viewtype == WithImage) {
            return WithImage;}
        return WithoutImage;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        TextView title,contents;

        public ImageViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.board_title);
            contents = (TextView)itemView.findViewById(R.id.board_contents);
        }


    }
    public class WithoutImageViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;


        public WithoutImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.card_image);
        }
    }
}