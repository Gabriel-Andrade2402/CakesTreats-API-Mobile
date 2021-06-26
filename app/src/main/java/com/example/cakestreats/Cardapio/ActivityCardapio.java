package com.example.cakestreats.Cardapio;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.BundleCompat;

import com.example.cakestreats.Modelos.User;
import com.example.cakestreats.Profile.Profile;
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
        clickBolos(null);
    }

    //Clickes Menu Superior
    public void clickBolos(View view) {
        menu.clickBolos(view,0f);
        fragmentAtivo="bolos";
    }
    public void clickDoces(View view){
        menu.clickDoces(view,0f);
        fragmentAtivo="doces";
    }
    public void clickPascoa(View view){
        menu.clickPascoa(view,0f);
        fragmentAtivo="pascoa";
    }
    public void clickMenu(View view){ menu.clickMenu(view,findViewById(R.id.backgroundPretoMenu));
    irParaMenu(view);}

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

    public void irParaCarrinho(View view) {

    }
    public void irParaMenu(View view){
        ConstraintLayout constraintLayout=findViewById(R.id.cardapio);
        constraintLayout.removeAllViewsInLayout();
        getLayoutInflater().inflate(R.layout.activity_configurations,constraintLayout);
        TextView txNomeUsuario=findViewById(R.id.nomeUsuario);
        User user=Profile.getInstance(null).getUser();
        txNomeUsuario.setText(user.getNome());
    }

    public void voltarCardapio(View view) {
        Intent intent=new Intent(this,ActivityCardapio.class);
        startActivity(intent);
    }
}
