package comn.example.soonjae.kid_peace_library_app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import comn.example.soonjae.kid_peace_library_app.R;
import comn.example.soonjae.kid_peace_library_app.adapter.CardContentAdapter;

/**
 * Created by soonjae on 17. 12. 5.
 */

public class books_madang extends Fragment {

<<<<<<< HEAD
=======

    @Nullable
>>>>>>> b2ac5a375521cc7071ef8d99f364f0b95125ad80
    @Override


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.activity_books_madang,container,false);




        RecyclerView mRecylerView = (RecyclerView) view.findViewById(R.id.book_recyclerview);
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRecylerView.setHasFixedSize(true);
        mRecylerView.setLayoutManager(mLayoutManager);

        CardContentAdapter adapter = new CardContentAdapter();
<<<<<<< HEAD

        mRecylerView.setAdapter(adapter);
=======
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
>>>>>>> b2ac5a375521cc7071ef8d99f364f0b95125ad80

        return view;
    }




}
