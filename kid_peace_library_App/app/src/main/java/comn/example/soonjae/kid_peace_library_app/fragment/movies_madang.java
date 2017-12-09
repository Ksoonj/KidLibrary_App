package comn.example.soonjae.kid_peace_library_app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.movies_recyclerview);
        rv.setHasFixedSize(true);
        CardContentAdapter adapter = new CardContentAdapter();
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return view;

    }
}
