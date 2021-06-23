package com.example.cakestreats.Cardapio;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.example.cakestreats.R;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    private String fragmentAtivo;
    private LayoutInflater layoutInflater;
    private Spinner spinner;
    private FrameLayout frame;
    public Menu(LayoutInflater layoutInflater, Spinner spinner, FrameLayout fragment, ScrollView scrollView){
        this.layoutInflater=layoutInflater;
        this.spinner=(Spinner)spinner;
        frame=fragment;
    }
    //Animação botão "MENU"
    public void clickMenu(View view,ImageView image){
        ImageView imagemPreta=image;
        ObjectAnimator animacaoI=ObjectAnimator.ofFloat(imagemPreta,"alpha",0.3f);
        ObjectAnimator animacaoII=ObjectAnimator.ofFloat(imagemPreta,"alpha",0f);
        animacaoI.setDuration(80);
        animacaoII.setDuration(80);
        AnimatorSet bouncer=new AnimatorSet();
        bouncer.play(animacaoI).before(animacaoII);
        bouncer.start();
    }
    public void clickBolos(View view) {
        if(fragmentAtivo!=null){
            frame.removeAllViews();
        }
        layoutInflater.inflate(R.layout.fragment_cardapio_bolos,frame);
        if(view!=null){
            ObjectAnimator objectAnimator= ObjectAnimator.ofFloat(spinner,"translationX",view.getX());
            objectAnimator.setDuration(500);
            objectAnimator.start();
        }
        fragmentAtivo="bolos";
    }
    public void clickDoces(View view){
        if(fragmentAtivo!=null){
            frame.removeAllViews();
        }
        layoutInflater.inflate(R.layout.fragment_cardapio_doces,frame);
        fragmentAtivo="doces";
        ObjectAnimator objectAnimator= ObjectAnimator.ofFloat(spinner,"translationX",view.getX());
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }
    public void clickPascoa(View view){
        if(fragmentAtivo!=null){
            frame.removeAllViews();
        }
        layoutInflater.inflate(R.layout.fragment_cardapio_pascoa,frame);
        fragmentAtivo="pascoa";
        ObjectAnimator objectAnimator= ObjectAnimator.ofFloat(spinner,"translationX",view.getX());
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }

    public String getFragmentAtivo() {
        return fragmentAtivo;
    }

}
