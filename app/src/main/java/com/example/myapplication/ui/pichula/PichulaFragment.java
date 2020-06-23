package com.example.myapplication.ui.pichula;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ui.pichula.PichulaViewModel;

public class PichulaFragment extends Fragment {

    private PichulaViewModel pichulaViewModel;

    public static PichulaFragment newInstance() {
        return new PichulaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        pichulaViewModel =
                ViewModelProviders.of(this).get(PichulaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pichula, container, false);
        final TextView textView = root.findViewById(R.id.text_pichula);
        pichulaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
//        return inflater.inflate(R.layout.pichula_fragment, container, false);
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(PichulaViewModel.class);
//        // TODO: Use the ViewModel
//    }

}