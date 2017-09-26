package com.jorgereina.jpmorganchallenge;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jorgereina.jpmorganchallenge.Models.Track;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    @BindView(R.id.search_button) Button searchButton;
    @BindView(R.id.search_input) EditText searchInput;
    private List<Track> trackList;
    OnTrackSelected onTrackSelected;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        onTrackSelected = (OnTrackSelected) getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        trackList = new ArrayList<>();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchResultsFragment searchResultFragment = new SearchResultsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, searchResultFragment);
                fragmentTransaction.commit();

                String input = searchInput.getText().toString();

                onTrackSelected.sendQueryParam(input);

            }
        });
    }
}
