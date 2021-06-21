package com.example.cakestreats;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.cakestreats.Cardapio.ActivityCardapio;
import com.example.cakestreats.Cardapio.Menu;
import com.example.cakestreats.auxiliares.ResourcesSupport;
import com.example.cakestreats.dialogos.Produtos;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout ct;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.introduction);
        findViewById(R.id.mainLayoutIntroduction);
        ct= (ConstraintLayout)findViewById(R.id.mainLayoutIntroduction);
        animator();
    }
    public void animator(){
        ObjectAnimator objImagem= ObjectAnimator.ofFloat(findViewById(R.id.logomarcaIntroduction),"alpha",1f);
        objImagem.setDuration(3000);
        ObjectAnimator objImagem2= ObjectAnimator.ofFloat(findViewById(R.id.nomeLogomarcaIntroduction),"alpha",1f);
        objImagem.setDuration(3000);
        AnimatorSet anm=new AnimatorSet();
        anm.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                introduction();
            }
        });
        anm.play(objImagem).with(objImagem2);
        anm.start();
    }

    public void introduction(){
        ct.removeAllViews();
        getLayoutInflater().inflate(R.layout.login,ct);
    }
    public void logar(View view) {
        Intent intent=new Intent(this, ActivityCardapio.class);
        startActivity(intent);
    }

    public void botaoVoltar(View view) {
        ct.removeAllViews();
        getLayoutInflater().inflate(R.layout.login,ct);
    }

    public void iniciarCadastro(View view) {
        ct.removeAllViews();
        getLayoutInflater().inflate(R.layout.cadastrar,ct);
    }
}