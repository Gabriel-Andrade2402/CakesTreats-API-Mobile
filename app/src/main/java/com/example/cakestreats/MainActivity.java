package com.example.cakestreats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.hardware.ConsumerIrManager;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cakestreats.fragments.CardapioBolos;
import com.example.cakestreats.fragments.CardapioDoces;
import com.example.cakestreats.fragments.CardapioPascoa;

public class MainActivity extends AppCompatActivity {
    private String fragmentAtivo="CardapioBolos";
    private FragmentManager fragmentManager=getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        clickBolos(null);
    }
    public void clickDoces(View view){
        //  removeFragment();
        CardapioDoces cd=new CardapioDoces();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,cd).addToBackStack(null).commit();
        fragmentAtivo="CardapioDoces";
    }
    public void clickPascoa(View view){
        //removeFragment();
        CardapioPascoa cp=new CardapioPascoa();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,cp).addToBackStack(null).commit();
        fragmentAtivo="CardapioPascoa";
    }

    public void clickBolos(View view) {
        //removeFragment();
        CardapioBolos cb=new CardapioBolos();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,cb).addToBackStack(null).commit();
        fragmentAtivo="CardapioBolos";
    }
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
    }
    //Animando todos Produtos
    public void animationClick(View view) {
        ConstraintLayout cl=(ConstraintLayout)view;
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
    }
    //Animando o menu selecionado
}