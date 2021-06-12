package com.example.cakestreats;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.cakestreats.dialogs.Dialogos;

public class ManipularDialogos {
    private FragmentManager fragmentManager;
    public ManipularDialogos(FragmentManager fragmentManager){
        this.fragmentManager=fragmentManager;
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
        Dialogos dialogo=new Dialogos(R.layout.dialog_bolos);
        dialogo.show(fragmentManager,"produtoDialogo");
    }
    //Constrói o dialogo correto
    public void criarDialogo(View view,ConstraintLayout cl) {

    }
    //fechar dialogo
    public void clickFechar(View view) {
        DialogFragment dialog=(DialogFragment) fragmentManager.findFragmentByTag("produtoDialogo");
        dialog.dismiss();
    }

}
