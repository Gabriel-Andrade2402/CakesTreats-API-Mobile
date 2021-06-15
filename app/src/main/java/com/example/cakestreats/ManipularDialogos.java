package com.example.cakestreats;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Application;
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

import java.util.logging.Level;
import java.util.logging.Logger;


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
    public Produtos ClickProduto(View view) {
        ConstraintLayout cl=(ConstraintLayout)view;
        layoutAtivo=cl;
        float positionZ=cl.getZ();
        cl.setZ(1);
        ImageView img=(ImageView)retornarImagemPretaDoLayout(cl);
        animarLayoutComZoom(cl,img);
        cl.setZ(positionZ);
        TextView tx=retornarTituloDoLayout(cl);
        Produtos p=recuperarProduto(tx.getText().toString());
        return p;
    }
    //AnimarLayout com zoom
    public void animarLayoutComZoom(ConstraintLayout cl,ImageView img){
        ObjectAnimator objImagem= ObjectAnimator.ofFloat(img,"alpha",1f);
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
    }
    //Criar produtos
    public Produtos recuperarProduto(String titulo){
        switch (titulo){
            case "Bolos tipo 1":
                return new Produtos(R.layout.activity_produtos,"Bolos tipo 1");
            case "Bolos tipo 2":
                return new Produtos(R.layout.activity_produtos,"Bolos tipo 2");
            case "Bolos tipo 3":
                return new Produtos(R.layout.activity_produtos_bolo2,"Bolos tipo 3");
            case "Bolos tipo 4":
                return new Produtos(R.layout.activity_produtos,"Bolos tipo 4");
            case "Bolos No Pote":
                return new Produtos(R.layout.activity_produtos_padrao1,"Bolos No Pote");
            case "Bombons No Pote":
                return new Produtos(R.layout.activity_produtos_padrao1,"Bombons No Pote");
            case "copoDaFelicidade":
                return new Produtos(R.layout.activity_produtos_padrao1,"Bombons No Pote");
            case "Pão De Mel":
                return new Produtos(R.layout.activity_produtos_padrao2,"Pão De Mel");
            case "Brigadeiro Gourmet":
                return new Produtos(R.layout.activity_produtos_padrao3,"Brigadeiro Gourmet");
            case "Taças":
                return new Produtos(R.layout.activity_produtos_padrao2,"Taças");
            case "Barra recheada":
                return new Produtos(R.layout.activity_produtos_padrao4,"Barra recheada");
        }
        return null;
    }
    //Auxiliares

    /*Este método é baseado na hierarquia dos XMLS ConstraintsLayouts dos produtos
    sendo uma má pratica, e deve ser refatorada. a unica finalidade deste método é encotrar
    onde está o titulo do produto para que o Layout certo seja criado
     */
    public TextView retornarTituloDoLayout(ConstraintLayout cl){
        try{
            return (TextView)cl.getChildAt(0);
        }catch (Exception e){
            ConstraintLayout cons=(ConstraintLayout) cl.getChildAt(1);
            return (TextView)cons.getChildAt(1);
        }
    }
    /*Este método é baseado na hierarquia dos XMLS ConstraintsLayouts dos produtos
    sendo uma má pratica, e deve ser refatorada. a unica finalidade deste método é encotrar
    onde está a imagem preta
     */
    public ImageView retornarImagemPretaDoLayout(ConstraintLayout cl){
        try{
            return (ImageView) cl.getChildAt(cl.getChildCount()-1);
        }catch (Exception e){
            try{
                ConstraintLayout cons=(ConstraintLayout) cl.getChildAt(1);
                return (ImageView) cons.getChildAt(cl.getChildCount()-1);
            }catch (Exception ee){

            }
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
