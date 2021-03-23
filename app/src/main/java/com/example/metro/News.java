package com.example.metro;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class News extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tabs);

        tabLayout.addTab(tabLayout.newTab().setText("Важное"));
        tabLayout.addTab(tabLayout.newTab().setText("Статьи"));
        tabLayout.addTab(tabLayout.newTab().setText("Twitter"));

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        PagerFragment adapter = new PagerFragment(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        //установка adapter to pager
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //метод прослушивания свайпа по view
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

}
