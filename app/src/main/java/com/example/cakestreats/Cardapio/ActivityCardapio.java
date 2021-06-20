package com.example.cakestreats.Cardapio;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.BundleCompat;

import com.example.cakestreats.R;
import com.example.cakestreats.auxiliares.ResourcesSupport;
import com.example.cakestreats.dialogos.Produtos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ActivityCardapio extends AppCompatActivity {
    private Menu menu;
    private ResourcesSupport resourcesSupport;
    private Bundle bundle;
    private static String fragmentAtivo="bolos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cardapio);
        resourcesSupport=ResourcesSupport.getInstance(getResources());
        menu=new Menu(getLayoutInflater(),findViewById(R.id.linhaMenuSelecionado),findViewById(R.id.fragment),
                findViewById(R.id.linearLayoutFragment));
        if(savedInstanceState!=null){
            bundle=savedInstanceState;
            recuperarEstado();
        }else {
            clickBolos(null);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("recEstScrollY",findViewById(R.id.linearLayoutFragment).getScrollY());
        FrameLayout frame=(FrameLayout) findViewById(R.id.linearLayoutFragment).getParent();
        outState.putString("recEstFragmento",frame.getTag().toString());
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
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    //Recuperar Estado
    public void recuperarEstado(){
        switch (bundle.getString("recEstFragmento")){
            case "bolos":
                menu.clickBolos(findViewById(R.id.button_bolos));
                findViewById(R.id.linearLayoutFragment).setScrollY(bundle.getInt("recEstScrollY"));
                break;
            case "doces":
                menu.clickDoces(findViewById(R.id.button_doces));
                findViewById(R.id.linearLayoutFragment).setScrollY(bundle.getInt("recEstScrollY"));
                break;
            case "pascoa":
                menu.clickPascoa(findViewById(R.id.button_pascoa));
                findViewById(R.id.linearLayoutFragment).setScrollY(bundle.getInt("recEstScrollY"));
                break;
        }

    }
}
