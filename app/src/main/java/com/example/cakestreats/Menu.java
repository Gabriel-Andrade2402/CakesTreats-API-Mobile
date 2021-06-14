package com.example.cakestreats;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.cakestreats.dialogos.Produtos;
import com.example.cakestreats.fragments.CardapioBolos;
import com.example.cakestreats.fragments.CardapioDoces;
import com.example.cakestreats.fragments.CardapioPascoa;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    private String fragmentAtivo;
    private FragmentManager fragmentManager;
    private Spinner spinner;
    public Menu(FragmentManager fragmentManager,Spinner spinner){
        this.fragmentManager=fragmentManager;
        this.spinner=(Spinner)spinner;
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
        //removeFragment();
        CardapioBolos cardapioBolos=new CardapioBolos();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,cardapioBolos).addToBackStack(null).commit();
        if(fragmentAtivo!=null){
            ObjectAnimator objectAnimator= ObjectAnimator.ofFloat(spinner,"translationX",view.getX());
            objectAnimator.setDuration(500);
            objectAnimator.start();
        }
        fragmentAtivo="bolos";
    }
    public void clickDoces(View view){
        //  removeFragment();
        CardapioDoces cardapioDoces=new CardapioDoces();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,cardapioDoces).addToBackStack(null).commit();
        fragmentAtivo="doces";
        ObjectAnimator objectAnimator= ObjectAnimator.ofFloat(spinner,"translationX",view.getX());
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }
    public void clickPascoa(View view){
        //removeFragment();
        CardapioPascoa cardapioPascoa=new CardapioPascoa();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,cardapioPascoa).addToBackStack(null).commit();
        fragmentAtivo="pascoa";
        ObjectAnimator objectAnimator= ObjectAnimator.ofFloat(spinner,"translationX",view.getX());
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }

    public String getFragmentAtivo() {
        return fragmentAtivo;
    }
    /*
    public void removeFragment(){
        FragmentTransaction ft=fragmentManager.beginTransaction();
        switch (fragmentAtivo){
            case "CardapioDoces":
                CardapioDoces fragmentDoces=(CardapioDoces) fragmentManager.findFragmentById(R.id.fragment);
                ft.remove(fragmentDoces).commit();
                break;
            case "CardapioBolos":
                CardapioBolos fragmentBolos=(CardapioBolos) fragmentManager.findFragmentById(R.id.fragment);
                ft.remove(fragmentBolos).commit();
                break;
            case "CardapioPascoa":
                CardapioPascoa fragmentPascoa=(CardapioPascoa) fragmentManager.findFragmentById(R.id.fragment);
                ft.remove(fragmentPascoa).commit();
                break;
        }
    }*/
}
