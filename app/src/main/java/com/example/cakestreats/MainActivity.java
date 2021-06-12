package com.example.cakestreats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
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
import android.widget.Spinner;
import android.widget.TextView;

import com.example.cakestreats.dialogs.Dialogos;
import com.example.cakestreats.fragments.CardapioBolos;
import com.example.cakestreats.fragments.CardapioDoces;
import com.example.cakestreats.fragments.CardapioPascoa;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private Menu menu;
    private ManipularDialogos manipularDialogos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        menu=new Menu(getSupportFragmentManager(),findViewById(R.id.linhaMenuSelecionado));
        manipularDialogos= new ManipularDialogos(getSupportFragmentManager());
        clickBolos(null);
    }
    //ClickesMenu
    public void clickBolos(View view) {
        menu.clickBolos(view);
    }
    public void clickDoces(View view){
        menu.clickDoces(view);
    }
    public void clickPascoa(View view){
       menu.clickPascoa(view);
    }
    public void clickMenu(View view){
        menu.clickMenu(view,findViewById(R.id.backgroundPretoMenu));
    }
    //Iniciando fragmentDialog com animação
    public void animationClick(View view) {
        manipularDialogos.animationClick(view);
    }
    public void clickFechar(View view) {
        manipularDialogos.clickFechar(view);
    }
}