package com.jorgereina.jpmorganchallenge;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jorgereina.jpmorganchallenge.databinding.SearchFragmentBinding;

/**
 * Created by jreina on 9/25/17.
 */

public class SearchFragment extends Fragment {

    SearchFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false);
        return binding.getRoot();
    }
}
