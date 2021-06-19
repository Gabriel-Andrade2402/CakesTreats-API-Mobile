package com.example.cakestreats.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.cakestreats.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardapioPascoa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardapioPascoa extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View layoutView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CardapioPascoa() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardapioPascoa.
     */
    // TODO: Rename and change types and number of parameters
    public static CardapioPascoa newInstance(String param1, String param2) {
        CardapioPascoa fragment = new CardapioPascoa();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutView=inflater.inflate(R.layout.fragment_cardapio_pascoa, container, false);
        return layoutView;
    }

    public FrameLayout getLayoutView() {
        return (FrameLayout) layoutView;
    }
}