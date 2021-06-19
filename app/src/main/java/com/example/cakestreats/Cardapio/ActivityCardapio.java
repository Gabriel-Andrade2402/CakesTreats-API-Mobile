package com.example.cakestreats.Cardapio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cakestreats.R;
import com.example.cakestreats.auxiliares.ResourcesSupport;
import com.example.cakestreats.dialogos.Produtos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ActivityCardapio extends AppCompatActivity {
    private Menu menu;
    private ResourcesSupport resourcesSupport;
    private static String fragmentAtivo="bolos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cardapio);
        resourcesSupport=new ResourcesSupport(getResources());
        menu=new Menu(getSupportFragmentManager(),findViewById(R.id.linhaMenuSelecionado));
        if(getIntent().getStringExtra("recEstFragment")!=null){
            Logger.getLogger(ActivityCardapio.class.getName()).log(Level.WARNING,findViewById(R.id.linearLayoutFragment)
            .getTag().toString());
        }else {
            clickBolos(null);
        }
    }
    //Clickes Menu Superior
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

    //Iniciando fragmentDialog com animação este metodo está em todos ConstraintsLayouts Dos Bolos
    public void animationClick(View view) {
        //Está instancia serve apenas para pegar os dados com getters e passar na intent
        Produtos p=resourcesSupport.ClickProduto(view);
        Intent intent= new Intent(this,Produtos.class);
        String layoutId=String.valueOf(p.getIdLayout());
        intent.putExtra("layoutId",layoutId);
        intent.putExtra("layoutAtivo",p.getLayoutAtivo());
        FrameLayout frameLayout=(FrameLayout) findViewById(R.id.linearLayoutFragment).getParent();
        intent.putExtra("recEstFragment",String.valueOf(frameLayout.getTag()));
        intent.putExtra("recEstScrollY",String.valueOf(findViewById(R.id.linearLayoutFragment).getScrollY()));
        startActivity(intent);
    }
    //Recuperar Estado
    public void recuperarEstado(String frame){
        switch (frame){
            case "bolos":
                menu.clickBolos(findViewById(R.id.button_bolos));
                break;
            case "doces":
                menu.clickDoces(findViewById(R.id.button_doces));
                break;
            case "pascoa":
                menu.clickPascoa(findViewById(R.id.button_pascoa));
                break;
        }
    }
}
