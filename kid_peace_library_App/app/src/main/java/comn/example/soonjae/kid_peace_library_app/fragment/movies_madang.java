package comn.example.soonjae.kid_peace_library_app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> b2ac5a375521cc7071ef8d99f364f0b95125ad80
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import comn.example.soonjae.kid_peace_library_app.Activity.ApiUtlis;
import comn.example.soonjae.kid_peace_library_app.R;
import comn.example.soonjae.kid_peace_library_app.adapter.BoardAdapter;
import comn.example.soonjae.kid_peace_library_app.data.model.Item;
import comn.example.soonjae.kid_peace_library_app.data.model.SOAnswersResponse;
import comn.example.soonjae.kid_peace_library_app.data.model.remote.SOServiced;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by soonjae on 17. 12. 5.
 */

public class movies_madang extends Fragment {

    private SOServiced service;
    private RecyclerView recyclerView;
    private BoardAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.activity_movies_madang, container, false);


        service = ApiUtlis.getSOService();
        recyclerView = (RecyclerView) view.findViewById(R.id.movies_recyclerview);
        adapter = new BoardAdapter(this, new ArrayList<Item>(0), new BoardAdapter.PostItemListener() {
            @Override
            public void onPostClick(long id) {

<<<<<<< HEAD
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


        loadAnswers();

=======
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.movies_recyclerview);
        rv.setHasFixedSize(true);
        CardContentAdapter adapter = new CardContentAdapter();
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
>>>>>>> b2ac5a375521cc7071ef8d99f364f0b95125ad80

        return view;


    }





    private void loadAnswers() {

        service.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {
                if(response.isSuccessful()) {
                    adapter.updateAnswers(response.body().getItems());
                    Log.d("movies_madang", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {

                Log.d("MainActivity", "error loading from API");

            }
        });
    }
}
