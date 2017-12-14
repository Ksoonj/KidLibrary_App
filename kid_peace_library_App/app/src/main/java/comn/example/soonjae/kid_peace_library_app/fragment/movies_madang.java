package comn.example.soonjae.kid_peace_library_app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comn.example.soonjae.kid_peace_library_app.R;
import comn.example.soonjae.kid_peace_library_app.adapter.CardContentAdapter;
import comn.example.soonjae.kid_peace_library_app.adapter.ListContentAdapter;

/**
 * Created by soonjae on 17. 12. 5.
 */

public class movies_madang extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.activity_movies_madang,container,false);


        RecyclerView mRecylerView = (RecyclerView) view.findViewById(R.id.movies_recyclerview);
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRecylerView.setHasFixedSize(true);
        mRecylerView.setLayoutManager(mLayoutManager);

        CardContentAdapter adapter = new CardContentAdapter();

        mRecylerView.setAdapter(adapter);

        return view;

    }
}
