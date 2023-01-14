package com.example.hm_3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class First_fragment extends Fragment {
    private TextView zero;
    private Button minus;
    private Button reset;
    private Button plus;
    private Integer counter;

    private final View.OnClickListener onClickListener = view -> {
        switch (view.getId()){
            case R.id.minusBtn:
                counter--;
                zero.setText(Integer.toString(counter));
                break;
            case R.id.plusBtn:
                counter++;
                zero.setText(Integer.toString(counter));
                break;
            case R.id.resetBtn:
                initCounter();
                break;
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
        initCounter();
    }

    private void initCounter() {
        counter = 0;
        zero.setText(Integer.toString(counter));
    }

    private void initListener() {
        minus.setOnClickListener(onClickListener);
        plus.setOnClickListener(onClickListener);
        reset.setOnClickListener(onClickListener);
    }

    private void initView() {
        zero = requireActivity().findViewById(R.id.counterTxt);
        minus = requireActivity().findViewById(R.id.minusBtn);
        reset = requireActivity().findViewById(R.id.resetBtn);
        plus = requireActivity().findViewById(R.id.plusBtn);

    }
}