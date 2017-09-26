package com.jorgereina.jpmorganchallenge;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity{

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchFragment = new SearchFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, searchFragment);
        fragmentTransaction.commit();

    }
}
