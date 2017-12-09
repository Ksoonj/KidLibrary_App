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
import comn.example.soonjae.kid_peace_library_app.adapter.ListContentAdapter;

/**
 * Created by soonjae on 17. 12. 5.
 */

public class peace_news_madang extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.activity_peace_news_madang,container,false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.news_recyclerview);
        rv.setHasFixedSize(true);
        ListContentAdapter adapter = new ListContentAdapter();
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return view;
    }
}
