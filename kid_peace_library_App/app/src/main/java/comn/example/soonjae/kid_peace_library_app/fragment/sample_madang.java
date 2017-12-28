package comn.example.soonjae.kid_peace_library_app.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import comn.example.soonjae.kid_peace_library_app.R;
import comn.example.soonjae.kid_peace_library_app.adapter.Data;
import comn.example.soonjae.kid_peace_library_app.adapter.RecyclerViewAdapter;
import comn.example.soonjae.kid_peace_library_app.adapter.ViewPagerAdapter;

/**
 * Created by soonjae on 21/12/17.
 */

public class sample_madang extends Fragment {
    List<Data> dataList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter adapter;
    ViewPager viewPager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;


        view = inflater.inflate(R.layout.activity_sample,container,false);



        viewPager =(ViewPager)view.findViewById(R.id.pager);
        ViewPagerAdapter viewPagerAdapter  = new ViewPagerAdapter(getLayoutInflater());
        viewPager.setAdapter(viewPagerAdapter);



        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position;



                switch( v.getId() ){

                    case R.id.img_prev://이전버튼 클릭



                        position=viewPager.getCurrentItem();//현재 보여지는 아이템의 위치를 리턴



                        //현재 위치(position)에서 -1 을 해서 이전 position으로 변경

                        //이전 Item으로 현재의 아이템 변경 설정(가장 처음이면 더이상 이동하지 않음)

                        //첫번째 파라미터: 설정할 현재 위치

                        //두번째 파라미터: 변경할 때 부드럽게 이동하는가? false면 팍팍 바뀜

                        viewPager.setCurrentItem(position-1,true);



                        break;



                    case R.id.img_next://다음버튼 클릭



                        position=viewPager.getCurrentItem();//현재 보여지는 아이템의 위치를 리턴



                        //현재 위치(position)에서 +1 을 해서 다음 position으로 변경

                        //다음 Item으로 현재의 아이템 변경 설정(가장 마지막이면 더이상 이동하지 않음)

                        //첫번째 파라미터: 설정할 현재 위치

                        //두번째 파라미터: 변경할 때 부드럽게 이동하는가? false면 팍팍 바뀜

                        viewPager.setCurrentItem(position+1,true);



                        break;

                }



            }





        });






        dataList = new ArrayList<>();

        dataList.add(new Data("sibal","no",1));



        recyclerView=(RecyclerView)view.findViewById(R.id.sample_Recyclerview);


        layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter =new RecyclerViewAdapter(dataList);
        recyclerView.setAdapter(adapter);



        return view;

    }
}
