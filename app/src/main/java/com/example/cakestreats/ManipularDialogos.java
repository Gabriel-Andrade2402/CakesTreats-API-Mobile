package com.example.cakestreats;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.cakestreats.dialogos.Produtos;


public class ManipularDialogos {
    private FragmentManager fragmentManager;
    private Resources resources;
    private LayoutInflater layoutInflater;
    private Context applicationContext;
    private ConstraintLayout layoutAtivo;
    public ManipularDialogos(FragmentManager fragmentManager,Resources resources,LayoutInflater layoutInflater,
                             Context applicationContext){
        this.fragmentManager=fragmentManager;
        this.resources=resources;
        this.layoutInflater=layoutInflater;
        this.applicationContext=applicationContext;
    }
    //Animando todos Produtos
    public Produtos animationClick(View view) {
        ConstraintLayout cl=(ConstraintLayout)view;
        layoutAtivo=cl;
        float positionZ=cl.getZ();
        cl.setZ(1);
        ImageView img=(ImageView)cl.getChildAt(cl.getChildCount()-1);
        ObjectAnimator objImagem= ObjectAnimator.ofFloat(img,"alpha",0.3f);
        objImagem.setDuration(80);
        ObjectAnimator objLayoutX=ObjectAnimator.ofFloat(cl,"scaleX",1.3f);
        objLayoutX.setDuration(90);
        ObjectAnimator objLayoutY=ObjectAnimator.ofFloat(cl,"scaleY",1.3f);
        objLayoutY.setDuration(90);
        ObjectAnimator objLayoutXVoltar=ObjectAnimator.ofFloat(cl,"scaleX",1f);
        objLayoutX.setDuration(90);
        ObjectAnimator objLayoutYVoltar=ObjectAnimator.ofFloat(cl,"scaleY",1f);
        objLayoutY.setDuration(90);
        ObjectAnimator objImagem2= ObjectAnimator.ofFloat(img,"alpha",0f);
        objImagem.setDuration(80);
        AnimatorSet bouncer= new AnimatorSet();
        bouncer.play(objImagem2).after(objImagem);
        bouncer.play(objLayoutX).with(objLayoutY);
        bouncer.play(objLayoutXVoltar).with(objLayoutYVoltar).after(objLayoutX);
        bouncer.start();
        cl.setZ(positionZ);
        TextView tx=(TextView)cl.getChildAt(0);
        Produtos p=recuperarProduto(tx.getText().toString());
        return p;
    }
    //Criar produtos
    public Produtos recuperarProduto(String titulo){
        switch (titulo){
            case "Bolos tipo 1":
                return new Produtos(R.layout.activity_produtos,"bolos1");
            case "Bolos tipo 2":
                return new Produtos(R.layout.activity_produtos,"bolos2");
            case "Bolos tipo 3":
                return new Produtos(R.layout.activity_produtos_bolo2,"bolos3");
            case "Bolos tipo 4":
                return new Produtos(R.layout.activity_produtos,"bolos4");
        }
        return null;
    }
    //Recuperar ScrollY
    public void AtualizarScrollY(Integer scroll){
        layoutAtivo.setScrollY(scroll);
    }
    //recuperarLayoutAtivo

    public ConstraintLayout getLayoutAtivo() {
        return layoutAtivo;
    }
}
