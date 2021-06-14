package com.example.cakestreats.dialogos;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cakestreats.MainActivity;
import com.example.cakestreats.R;
import com.example.cakestreats.auxiliares.ResourcesSupport;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produtos extends AppCompatActivity {
    private Integer idLayout;
    private String layoutAtivo;
    private TextView saborSelecionado;
    private Bundle bundle;
    public Produtos(Integer id,String layout){
        idLayout=id;
        layoutAtivo=layout;
    }
    public Produtos(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        Intent in=getIntent();
        idLayout=Integer.parseInt(in.getStringExtra("layoutId"));
        layoutAtivo=in.getStringExtra("layoutAtivo");
        setContentView(idLayout);
        bundle=savedInstanceState;
        atualizarLayout();
    }
    //Atualiza o layout para o layout clicado
    public void atualizarLayout(){
        switch (layoutAtivo){
            case "bolos1":
                atualizarBolos1();
                break;
            case "bolos2":
                atualizarBolos2();
                break;
            case "bolos3":
                atualizarBolos3();
                break;
            case "bolos4":
                atualizarBolos4();
                break;
        }
    }

    public void atualizarBolos1(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        Button botao=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Bolos tipo 1"));
        tituloLayout.setText("Bolos tipo 1");
        precoLayout.setText("R$ 50,00");
        botao.setText("ADICIONAR AO CARRINHO R$ 50,00");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Bolos tipo 1");
        for(String s:listSabores){
            TextView tx=new TextView(this);
            tx.setText(s);
            tx.setLayoutParams(params);
            tx.setBackgroundColor(Color.parseColor("#FFFAFA"));
            tx.setPadding(15,15,15,15);
            tx.setTextSize(20);
            tx.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tx.setTextColor(Color.parseColor("#4F4F4F"));
            tx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(saborSelecionado!=null) {
                        saborSelecionado.setTextColor(Color.parseColor("#4F4F4F"));
                        saborSelecionado.setBackgroundColor(Color.parseColor("#FFFAFA"));
                    }TextView tx=(TextView)v;
                    tx.setElevation(20f);
                    tx.setBackgroundColor(Color.parseColor("#8B4513"));
                    tx.setTextColor(Color.parseColor("#FFFAFA"));
                    saborSelecionado=tx;
                }
            });
            scrollView.addView(tx);
        }
    }

    private void atualizarBolos2() {
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        Button botao=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Bolos tipo 2"));
        tituloLayout.setText("Bolos tipo 2");
        precoLayout.setText("R$ 55,00");
        botao.setText("ADICIONAR AO CARRINHO R$ 55,00");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Bolos tipo 2");
        for(String s:listSabores){
            TextView tx=new TextView(this);
            tx.setText(s);
            tx.setLayoutParams(params);
            tx.setBackgroundColor(Color.parseColor("#FFFAFA"));
            tx.setPadding(15,15,15,15);
            tx.setTextSize(20);
            tx.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tx.setTextColor(Color.parseColor("#4F4F4F"));
            tx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(saborSelecionado!=null) {
                        saborSelecionado.setTextColor(Color.parseColor("#4F4F4F"));
                        saborSelecionado.setBackgroundColor(Color.parseColor("#FFFAFA"));
                    }TextView tx=(TextView)v;
                    tx.setElevation(20f);
                    tx.setBackgroundColor(Color.parseColor("#8B4513"));
                    tx.setTextColor(Color.parseColor("#FFFAFA"));
                    saborSelecionado=tx;
                }
            });
            scrollView.addView(tx);
        }
    }

    private void atualizarBolos3() {
    }

    private void atualizarBolos4() {
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        Button botao=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Bolos tipo 4"));
        tituloLayout.setText("Bolos tipo 4");
        precoLayout.setText("R$ 65,00");
        botao.setText("ADICIONAR AO CARRINHO R$ 65,00");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Bolos tipo 2");
        for(String s:listSabores){
            TextView tx=new TextView(this);
            tx.setText(s);
            tx.setLayoutParams(params);
            tx.setBackgroundColor(Color.parseColor("#FFFAFA"));
            tx.setPadding(15,20,15,15);
            tx.setTextSize(20);
            tx.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tx.setTextColor(Color.parseColor("#4F4F4F"));
            tx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(saborSelecionado!=null) {
                        saborSelecionado.setTextColor(Color.parseColor("#4F4F4F"));
                        saborSelecionado.setBackgroundColor(Color.parseColor("#FFFAFA"));
                    }TextView tx=(TextView)v;
                    tx.setElevation(20f);
                    tx.setBackgroundColor(Color.parseColor("#8B4513"));
                    tx.setTextColor(Color.parseColor("#FFFAFA"));
                    saborSelecionado=tx;
                }
            });
            scrollView.addView(tx);
        }
    }
    //Botão Voltar
    public void voltarCardapio(View view) {
        ImageView img=(ImageView)findViewById(R.id.imagemPretaBolo1Voltar);
        animarClick(img);
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //Adicionar e subtrair kilos
    public void AdicionarKilos(View view) {
        ImageView img=(ImageView)view;
        animarClick(img);
        TextView tx=(TextView)findViewById(R.id.kilosProdutoBolo1);
        TextView preco=(TextView)findViewById(R.id.precoProdutos);
        int soma=Integer.parseInt(tx.getText().toString())+1;
        tx.setText(String.valueOf(soma));
        Button botaoCarrinho=findViewById(R.id.botaoAdicionarAoCarrinho);
        int total=Integer.parseInt(preco.getText().toString().substring(3,5))*soma;
        botaoCarrinho.setText("ADICIONAR AO CARRINHO R$ "+String.valueOf(total)+",00");
    }
    public void SubtrairKilos(View view) {
        ImageView img=(ImageView)view;
        animarClick(img);
        TextView tx=(TextView)findViewById(R.id.kilosProdutoBolo1);
        TextView preco=(TextView)findViewById(R.id.precoProdutos);
        int subtracao=Integer.parseInt(tx.getText().toString())-1;
        if(subtracao==0){tx.setText("1");
        subtracao=1;}else{
        tx.setText(String.valueOf(subtracao));}
        Button botaoCarrinho=findViewById(R.id.botaoAdicionarAoCarrinho);
        int total=Integer.parseInt(preco.getText().toString().substring(3,5))*subtracao;
        botaoCarrinho.setText("ADICIONAR AO CARRINHO R$ "+String.valueOf(total)+",00");
    }
    //Animar Cliques
    public void animarClick(ImageView img){
        ObjectAnimator objImagem= ObjectAnimator.ofFloat(img,"alpha",0.5f);
        objImagem.setDuration(80);
        ObjectAnimator objImagem2= ObjectAnimator.ofFloat(img,"alpha",0f);
        objImagem.setDuration(80);
        AnimatorSet bouncer= new AnimatorSet();
        bouncer.play(objImagem2).after(objImagem);
        bouncer.start();
    }

    public Integer getIdLayout() {
        return idLayout;
    }
    public String getLayoutAtivo() {
        return layoutAtivo;
    }
}