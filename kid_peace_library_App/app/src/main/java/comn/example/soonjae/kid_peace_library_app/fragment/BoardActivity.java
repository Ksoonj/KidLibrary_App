package comn.example.soonjae.kid_peace_library_app.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comn.example.soonjae.kid_peace_library_app.R;
import comn.example.soonjae.kid_peace_library_app.adapter.CommentlistAdapter;
import comn.example.soonjae.kid_peace_library_app.adapter.ListContentAdapter;

public class BoardActivity extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.activity_board,container,false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.comments_RV);
        rv.setHasFixedSize(true);
        CommentlistAdapter adapter = new CommentlistAdapter();
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return view;
    }
}
