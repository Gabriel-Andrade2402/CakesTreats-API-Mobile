package com.example.cakestreats.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.fragment.app.DialogFragment;

import com.example.cakestreats.R;

public class Dialogos extends DialogFragment {
    public Integer idLayout;
    public Dialogos(int id){
        idLayout=id;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(idLayout,null));
        return builder.create();
    }
    public void fechar(){
        dismiss();
    }

}
