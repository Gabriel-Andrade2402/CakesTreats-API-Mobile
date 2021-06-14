package com.example.cakestreats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.hardware.ConsumerIrManager;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.cakestreats.dialogos.Produtos;
import com.example.cakestreats.fragments.CardapioBolos;
import com.example.cakestreats.fragments.CardapioDoces;
import com.example.cakestreats.fragments.CardapioPascoa;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private Menu menu;
    private ManipularDialogos manipularDialogos;
    private static String fragmentAtivo="bolo";
    private static Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        manipularDialogos= new ManipularDialogos(getSupportFragmentManager(),getResources(),getLayoutInflater(),getApplicationContext());
        menu=new Menu(getSupportFragmentManager(),findViewById(R.id.linhaMenuSelecionado));
        clickBolos(null);
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        outState.putString("fragmentAtivo",menu.getFragmentAtivo());
        outState.putInt("scrollY",manipularDialogos.getLayoutAtivo().getScrollY());
        super.onSaveInstanceState(outState);
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
    public void clickMenu(View view){ menu.clickMenu(view,findViewById(R.id.backgroundPretoMenu));}
    //Iniciando fragmentDialog com animação
    public void animationClick(View view) {
        Produtos p=manipularDialogos.animationClick(view);
        Intent intent= new Intent(this,Produtos.class);
        String layoutId=String.valueOf(p.getIdLayout());
        intent.putExtra("layoutId",layoutId);
        intent.putExtra("layoutAtivo",p.getLayoutAtivo());
        startActivity(intent);

    }
    //Recuperar Estado
    public void recuperarEstado(String fragmentAtivo){
        switch (fragmentAtivo){
            case "bolos":
                menu.clickBolos(findViewById(R.id.button_bolos));
                break;case "doces":
                menu.clickDoces(findViewById(R.id.button_doces));
                break;
            case "pascoa":
                menu.clickDoces(findViewById(R.id.button_pascoa));
                break;
        }
        manipularDialogos.AtualizarScrollY(bundle.getInt("scrollY"));
        Logger.getLogger(MainActivity.class.getName()).log(Level.WARNING,"Entrou recuperae");
    }
    public void gerarIntent(Produtos p){
        setContentView(R.layout.activity_produtos);
        Intent intent=new Intent(this,p.getClass());
        //startActivity(intent);
    }
    public static void SetarFragmentAtivo(String produtoAtivo){
        fragmentAtivo=produtoAtivo;
    }
}