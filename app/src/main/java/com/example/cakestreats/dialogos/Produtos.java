package com.example.cakestreats.dialogos;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.BundleCompat;
import androidx.core.content.res.ResourcesCompat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cakestreats.Cardapio.ActivityCardapio;
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
    private Button adicionarAoCarrinho;
    private TextView cascaSelecionada;
    private TextView cascaSelecionadaEspecial;
    private ImageView tamanhoSelecionado;
    private List<Integer> valores;

    //Recuperar Estado antigo com botão voltar;
    private String recEstLayoutAntigo;
    private String recEstScrollY;

    //Construtor
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
        recEstLayoutAntigo=in.getStringExtra("recEstFragment");
        recEstScrollY=in.getStringExtra("recEstScrollY");
        setContentView(idLayout);
        atualizarLayout();
    }
    //Atualiza o layout para o layout clicado
    public void atualizarLayout(){
        switch (layoutAtivo){
            case "Bolos tipo 1":
                atualizarBolos1();
                break;
            case "Bolos tipo 2":
                atualizarBolos2();
                break;
            case "Bolos tipo 3":
                atualizarBolos3();
                break;
            case "Bolos tipo 4":
                atualizarBolos4();
                break;
            case "Bolos No Pote":
                atualizarBolosDePote();
                break;
            case "Bombons No Pote":
                atualizarBombonsNoPote();
                break;
            case "Copo Da Felicidade":
                atualizarCopoDaFelicidade();
                break;
            case "Pão De Mel":
                atualizarPaoDeMel();
                break;
            case "Brigadeiro Gourmet":
                atualizarBrigadeiroGourmet();
                break;
            case "Taças":
                atualizarTacas();
                break;
            case "Barra recheada":
                atualizarBarraRecheada();
                break;
            case "Ovo Simples":
                atualizarOvoSimples();
                break;
            case "Ovo Trufado":
                atualizarOvoTrufado();
                break;
            case "Ovo De Colher":
                atualizarOvoDeColher();
                break;
        }
    }

    public void atualizarBolos1(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Bolos tipo 1"));
        tituloLayout.setText("Bolos tipo 1");
        precoLayout.setText("R$ 50,00");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO R$ 50,00");
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
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Bolos tipo 2"));
        tituloLayout.setText("Bolos tipo 2");
        precoLayout.setText("R$ 55,00");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO R$ 55,00");
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
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Bolos tipo 3"));
        tituloLayout.setText("Bolos tipo 3");
        precoLayout.setText("P R$ 15,00    M R$ 16,00   G R$ 25,00");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Bolos tipo 3");
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

    private void atualizarBolos4() {
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Bolos tipo 4"));
        tituloLayout.setText("Bolos tipo 4");
        precoLayout.setText("R$ 65,00");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO R$ 65,00");
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

    private void atualizarBolosDePote(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Bolos No Pote"));
        tituloLayout.setText("Bolos No Pote");
        precoLayout.setText("145ml R$ 5,00 210ml R$7,00");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Bolos No Pote");
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

    private void atualizarBombonsNoPote(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Bombons No Pote"));
        tituloLayout.setText("Bombons No Pote");
        precoLayout.setText("145ml R$ 5,00 210ml R$7,00");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Bombons No Pote");
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

    private void atualizarCopoDaFelicidade(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Copo Da Felicidade"));
        tituloLayout.setText("Copo Da Felicidade");
        precoLayout.setText("400ml R$ 18,00 590ml R$25,00");
        ImageView imagemMl400=(ImageView) findViewById(R.id.ml145);
        ImageView imagemMl590=(ImageView) findViewById(R.id.ml210);
        imagemMl400.setTag("R$ 18,00");
        imagemMl590.setTag("R$ 25,00");
        imagemMl400.setContentDescription("400ml");
        imagemMl590.setContentDescription("590ml");
        imagemMl400.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.ml400_branco,null));
        imagemMl590.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.ml590_branco,null));
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Copo Da Felicidade");
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

    private void atualizarPaoDeMel(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Pão De Mel"));
        tituloLayout.setText("Pão De Mel");
        precoLayout.setText("R$ 5,00");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO R$ 5,00");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Pão De Mel");
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

    private void atualizarBrigadeiroGourmet(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Brigadeiro Gourmet"));
        tituloLayout.setText("Brigadeiro Gourmet");
        precoLayout.setText("caixa 4u R$ 10,00  caixa 6u R$ 15,00  caixa 9u R$ 20,00  caixa 12u R$ 25,00");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Brigadeiro Gourmet");
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

    private void atualizarTacas(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Taças"));
        tituloLayout.setText("Taças");
        precoLayout.setText("R$ 85,00 - R$ 95,00");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Taças1");
        List<String> listSabores2=resources.retornarListaDeSaboresPorTitulo("Taças2");
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
                    valores.add(85);
                    adicionarAoCarrinho.setText(adicionarAoCarrinho.getText().subSequence(0,20)+" R$"+
                            String.valueOf(calcTotal())+",00");
                }
            });
            scrollView.addView(tx);
        }
        for(String s:listSabores2){
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
                    valores.add(95);
                    adicionarAoCarrinho.setText(adicionarAoCarrinho.getText().subSequence(0,20)+" R$"+
                            String.valueOf(calcTotal())+",00");
                }
            });
            scrollView.addView(tx);
        }
    }

    private void atualizarBarraRecheada(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        TextView precoLayout=(TextView)findViewById(R.id.precoProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Barra recheada"));
        tituloLayout.setText("Barra recheada");
        precoLayout.setText("P R$ 15,00  G R$ 25,00");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO");
    }

    private void atualizarOvoSimples(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        ImageView gramas250=(ImageView) findViewById(R.id.gramas250);
        ImageView gramas350=(ImageView) findViewById(R.id.gramas350);
        ImageView gramas500=(ImageView) findViewById(R.id.gramas500);
        ImageView gramas700=(ImageView) findViewById(R.id.gramas700);
        gramas250.setTag("R$22,00/R$27,00");
        gramas350.setTag("R$32,00/R$37,00");
        gramas500.setTag("R$42,00/R$47,00");
        gramas700.setTag("R$62,00/R$67,00");
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollViewCascas=(LinearLayout) findViewById(R.id.LinearLayoutCascas);
        LinearLayout scrollViewSabores=(LinearLayout) findViewById(R.id.linearLayoutSabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Ovo Simples"));
        tituloLayout.setText("Ovo Simples");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO");
        List<String> listCascas=resources.retornarListaDeSaboresPorTitulo("Cascas Especiais");
        List<String> listCascas2=resources.retornarListaDeSaboresPorTitulo("Cascas Comuns");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Ovo Simples");
        for(String s:listCascas2){
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
                    if(cascaSelecionada!=null) {
                        cascaSelecionada.setTextColor(Color.parseColor("#4F4F4F"));
                        cascaSelecionada.setBackgroundColor(Color.parseColor("#FFFAFA"));
                    }TextView tx=(TextView)v;
                    tx.setElevation(20f);
                    tx.setBackgroundColor(Color.parseColor("#8B4513"));
                    tx.setTextColor(Color.parseColor("#FFFAFA"));
                    cascaSelecionada=tx;
                    calcularTotalPascoa();
                }
            });
            scrollViewCascas.addView(tx);
        }
        for(String s:listCascas){
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
                    TextView tx=(TextView) v;
                    if(cascaSelecionadaEspecial==null){
                        tx.setElevation(20f);
                        Logger.getLogger(Produtos.class.getName()).log(Level.WARNING,"Entrou else");
                        tx.setBackgroundColor(Color.parseColor("#8B4513"));
                        tx.setTextColor(Color.parseColor("#FFFAFA"));
                        cascaSelecionadaEspecial = tx;
                    }else{
                        if(cascaSelecionadaEspecial!=null && cascaSelecionadaEspecial.getText().toString().equals(tx.getText().toString())) {
                            cascaSelecionadaEspecial.setTextColor(Color.parseColor("#4F4F4F"));
                            Logger.getLogger(Produtos.class.getName()).log(Level.WARNING,"Entrou if 1");
                            cascaSelecionadaEspecial.setBackgroundColor(Color.parseColor("#FFFAFA"));
                            cascaSelecionadaEspecial = null;
                        }
                        if(cascaSelecionadaEspecial!=null && !cascaSelecionadaEspecial.getText().toString().equals(tx.getText().toString())) {
                            cascaSelecionadaEspecial.setTextColor(Color.parseColor("#4F4F4F"));
                            cascaSelecionadaEspecial.setBackgroundColor(Color.parseColor("#FFFAFA"));
                            Logger.getLogger(Produtos.class.getName()).log(Level.WARNING,"Entrou if 2");
                            tx.setElevation(20f);
                            tx.setBackgroundColor(Color.parseColor("#8B4513"));
                            tx.setTextColor(Color.parseColor("#FFFAFA"));
                            cascaSelecionadaEspecial = tx;
                        }
                    }
                    calcularTotalPascoa();
                }
            });
            scrollViewCascas.addView(tx);
        }
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
                    calcularTotalPascoa();
                }
            });
            scrollViewSabores.addView(tx);
        }
    }

    private void atualizarOvoTrufado(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        ImageView gramas250=(ImageView) findViewById(R.id.gramas250);
        ImageView gramas350=(ImageView) findViewById(R.id.gramas350);
        ImageView gramas500=(ImageView) findViewById(R.id.gramas500);
        ConstraintLayout ct= findViewById(R.id.constraintLayout);
        ct.removeView(findViewById(R.id.gramas700));
        gramas250.setTag("R$32,00/R$37,00");
        gramas350.setTag("R$42,00/R$47,00");
        gramas500.setTag("R$52,00/R$57,00");
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollViewCascas=(LinearLayout) findViewById(R.id.LinearLayoutCascas);
        LinearLayout scrollViewSabores=(LinearLayout) findViewById(R.id.linearLayoutSabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Ovo Trufado"));
        tituloLayout.setText("Ovo Trufado");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO");
        List<String> listCascas=resources.retornarListaDeSaboresPorTitulo("Cascas Especiais");
        List<String> listCascas2=resources.retornarListaDeSaboresPorTitulo("Cascas Comuns");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Ovo Trufado");
        for(String s:listCascas2){
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
                    if(cascaSelecionada!=null) {
                        cascaSelecionada.setTextColor(Color.parseColor("#4F4F4F"));
                        cascaSelecionada.setBackgroundColor(Color.parseColor("#FFFAFA"));
                    }TextView tx=(TextView)v;
                    tx.setElevation(20f);
                    tx.setBackgroundColor(Color.parseColor("#8B4513"));
                    tx.setTextColor(Color.parseColor("#FFFAFA"));
                    cascaSelecionada=tx;
                    calcularTotalPascoa();
                }
            });
            scrollViewCascas.addView(tx);
        }
        for(String s:listCascas){
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
                    TextView tx=(TextView) v;
                    if(cascaSelecionadaEspecial==null){
                        tx.setElevation(20f);
                        Logger.getLogger(Produtos.class.getName()).log(Level.WARNING,"Entrou else");
                        tx.setBackgroundColor(Color.parseColor("#8B4513"));
                        tx.setTextColor(Color.parseColor("#FFFAFA"));
                        cascaSelecionadaEspecial = tx;
                    }else{
                        if(cascaSelecionadaEspecial!=null && cascaSelecionadaEspecial.getText().toString().equals(tx.getText().toString())) {
                            cascaSelecionadaEspecial.setTextColor(Color.parseColor("#4F4F4F"));
                            Logger.getLogger(Produtos.class.getName()).log(Level.WARNING,"Entrou if 1");
                            cascaSelecionadaEspecial.setBackgroundColor(Color.parseColor("#FFFAFA"));
                            cascaSelecionadaEspecial = null;
                        }
                        if(cascaSelecionadaEspecial!=null && !cascaSelecionadaEspecial.getText().toString().equals(tx.getText().toString())) {
                            cascaSelecionadaEspecial.setTextColor(Color.parseColor("#4F4F4F"));
                            cascaSelecionadaEspecial.setBackgroundColor(Color.parseColor("#FFFAFA"));
                            Logger.getLogger(Produtos.class.getName()).log(Level.WARNING,"Entrou if 2");
                            tx.setElevation(20f);
                            tx.setBackgroundColor(Color.parseColor("#8B4513"));
                            tx.setTextColor(Color.parseColor("#FFFAFA"));
                            cascaSelecionadaEspecial = tx;
                        }
                    }
                    calcularTotalPascoa();
                }
            });
            scrollViewCascas.addView(tx);
        }
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
                    calcularTotalPascoa();
                }
            });
            scrollViewSabores.addView(tx);
        }
    }

    private void atualizarOvoDeColher(){
        ImageView imageViewLayout=(ImageView) findViewById(R.id.imagemBoloProdutos);
        ImageView gramas350=(ImageView) findViewById(R.id.gramas350);
        ImageView gramas500=(ImageView) findViewById(R.id.gramas500);
        ConstraintLayout ct= findViewById(R.id.constraintLayout);
        ct.removeView(findViewById(R.id.gramas250));
        ct.removeView(findViewById(R.id.gramas700));
        TextView tituloLayout=(TextView)findViewById(R.id.tituloBoloProdutos);
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollViewCascas=(LinearLayout) findViewById(R.id.LinearLayoutCascas);
        LinearLayout scrollViewSabores=(LinearLayout) findViewById(R.id.linearLayoutSabores);
        ResourcesSupport resources=new ResourcesSupport(getResources());
        imageViewLayout.setImageDrawable(resources.retornarDrawablePorTitulo("Ovo De Colher"));
        tituloLayout.setText("Ovo De Colher");
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO");
        List<String> listCascas2=resources.retornarListaDeSaboresPorTitulo("Cascas Comuns");
        List<String> listCascas=resources.retornarListaDeSaboresPorTitulo("Cascas Especiais");
        List<String> listSabores=resources.retornarListaDeSaboresPorTitulo("Ovo De Colher1");
        List<String> listSabores2=resources.retornarListaDeSaboresPorTitulo("Ovo De Colher2");
        for(String s:listCascas2){
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
                    if(cascaSelecionada!=null) {
                        cascaSelecionada.setTextColor(Color.parseColor("#4F4F4F"));
                        cascaSelecionada.setBackgroundColor(Color.parseColor("#FFFAFA"));
                    }TextView tx=(TextView)v;
                    tx.setElevation(20f);
                    tx.setBackgroundColor(Color.parseColor("#8B4513"));
                    tx.setTextColor(Color.parseColor("#FFFAFA"));
                    cascaSelecionada=tx;
                    calcularTotalPascoa();
                }
            });
            scrollViewCascas.addView(tx);
        }
        for(String s:listCascas){
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
                    TextView tx=(TextView) v;
                    if(cascaSelecionadaEspecial==null){
                        tx.setElevation(20f);
                        Logger.getLogger(Produtos.class.getName()).log(Level.WARNING,"Entrou else");
                        tx.setBackgroundColor(Color.parseColor("#8B4513"));
                        tx.setTextColor(Color.parseColor("#FFFAFA"));
                        cascaSelecionadaEspecial = tx;
                    }else{
                        if(cascaSelecionadaEspecial!=null && cascaSelecionadaEspecial.getText().toString().equals(tx.getText().toString())) {
                            cascaSelecionadaEspecial.setTextColor(Color.parseColor("#4F4F4F"));
                            Logger.getLogger(Produtos.class.getName()).log(Level.WARNING,"Entrou if 1");
                            cascaSelecionadaEspecial.setBackgroundColor(Color.parseColor("#FFFAFA"));
                            cascaSelecionadaEspecial = null;
                        }
                        if(cascaSelecionadaEspecial!=null && !cascaSelecionadaEspecial.getText().toString().equals(tx.getText().toString())) {
                            cascaSelecionadaEspecial.setTextColor(Color.parseColor("#4F4F4F"));
                            cascaSelecionadaEspecial.setBackgroundColor(Color.parseColor("#FFFAFA"));
                            Logger.getLogger(Produtos.class.getName()).log(Level.WARNING,"Entrou if 2");
                            tx.setElevation(20f);
                            tx.setBackgroundColor(Color.parseColor("#8B4513"));
                            tx.setTextColor(Color.parseColor("#FFFAFA"));
                            cascaSelecionadaEspecial = tx;
                        }
                    }
                    calcularTotalPascoa();
                }
            });
            scrollViewCascas.addView(tx);
        }
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
                    gramas350.setTag("R$47,00/R$52,00");
                    gramas500.setTag("R$55,00/R$60,00");
                    calcularTotalPascoa();
                }
            });
            Logger.getLogger(Produtos.class.getName()).log(Level.WARNING,s);
            scrollViewSabores.addView(tx);
        }
        for(String s:listSabores2){
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
                    gramas350.setTag("R$70,00/R$75,00");
                    gramas500.setTag("R$80,00/R$85,00");
                    calcularTotalPascoa();
                }
            });
            scrollViewSabores.addView(tx);
        }
    }
    //Fim da construção do layout


    private Integer calcTotal(){
        int total = 0;
        for(Integer i:valores){
            total+=i;
        }
        return total;
    }
    public void calcularTotalPascoa(){
        if(saborSelecionado!=null && cascaSelecionada!=null && tamanhoSelecionado !=null){
            if(cascaSelecionadaEspecial!=null){
                int valor=3;
                String[] precos=tamanhoSelecionado.getTag().toString().split("/");
                switch (cascaSelecionada.getText().toString()){
                    case "Casca ao leite":
                        valor+=Integer.parseInt(precos[0].substring(2,4));
                        break;
                    case "Casca branca":
                        valor+=Integer.parseInt(precos[1].substring(2,4));
                        break;
                }
                adicionarAoCarrinho.setText(adicionarAoCarrinho.getText().toString()
                        .substring(0,20)+" R$"+valor+",00");
            }else{
                int valor=0;
                String[] precos=tamanhoSelecionado.getTag().toString().split("/");
                switch (cascaSelecionada.getText().toString()){
                    case "Casca ao leite":
                        valor+=Integer.parseInt(precos[0].substring(2,4));
                        break;
                    case "Casca branca":
                        valor+=Integer.parseInt(precos[1].substring(2,4));
                        break;
                }
                adicionarAoCarrinho.setText(adicionarAoCarrinho.getText().toString()
                        .substring(0,20)+" R$"+valor+",00");
            }
        }
    }

    //Adicionar e subtrair kilos
    public void AdicionarKilos(View view) {
        ImageView img=(ImageView)view;
        animarClick(img);
        TextView tx=(TextView)findViewById(R.id.kilosProdutoBolo1);
        TextView preco=(TextView)findViewById(R.id.precoProdutos);
        int soma=Integer.parseInt(tx.getText().toString())+1;
        tx.setText(String.valueOf(soma));
        adicionarAoCarrinho=findViewById(R.id.botaoAdicionarAoCarrinho);
        valores.add(Integer.parseInt(preco.getText().toString().substring(3,5))*soma);
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO R$ "+String.valueOf(calcTotal())+",00");
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
        adicionarAoCarrinho=findViewById(R.id.botaoAdicionarAoCarrinho);
        valores.add(Integer.parseInt(preco.getText().toString().substring(3,5))*subtracao);
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO R$ "+String.valueOf(calcTotal())+",00");
    }
    //Escolher tamanho
    public void escolherTamanho(View view){
        ImageView img=(ImageView)view;
        if(tamanhoSelecionado!=null){
            ImageView imagePreta=recuperarImagemPretaParaAnimacao(tamanhoSelecionado);
            imagePreta.setAlpha(0f);
        }
        tamanhoSelecionado=img;
        ImageView imagePreta=recuperarImagemPretaParaAnimacao(view);
        AnimarClickPermanente(imagePreta);
        adicionarAoCarrinho.setText("Adicionar ao Carrinho "+img.getTag());
    }
    public void escolherTamanhoVermelhos(View view){
        if(tamanhoSelecionado!=null){
            tamanhoSelecionado.setImageDrawable(recuperarImagemBrancaParaAnimacao(tamanhoSelecionado));
        }
        ImageView img=(ImageView)view;
        tamanhoSelecionado=img;
        img.setImageDrawable(recuperarImagemVermelhaParaAnimacao(tamanhoSelecionado));
        adicionarAoCarrinho.setText("Adicionar ao Carrinho "+img.getTag());
    }
    public void escolherTamanhoPascoa(View view){
        if(tamanhoSelecionado!=null){
            tamanhoSelecionado.setImageDrawable(recuperarImagemBrancaParaAnimacao(tamanhoSelecionado));
        }
        ImageView img=(ImageView)view;
        tamanhoSelecionado=img;
        img.setImageDrawable(recuperarImagemVermelhaParaAnimacao(tamanhoSelecionado));
        calcularTotalPascoa();
    }
    //Auxiliar do EscolherTamanho
    public ImageView recuperarImagemPretaParaAnimacao(View view){
        switch (view.getId()){
            case R.id.botaoTamanhoG:
                return (ImageView) findViewById(R.id.imagemPretaTamanhoG);
            case R.id.botaoTamanhoP:
                return (ImageView) findViewById(R.id.imagemPretaTamanhoP);
            case R.id.botaoTamanhoM:
                return (ImageView) findViewById(R.id.imagemPretaTamanhoM);
        }
        return null;
    }
    public Drawable recuperarImagemVermelhaParaAnimacao(View view){
        switch (view.getId()){
            case R.id.botao4Unidades:
                return (Drawable) getResources().getDrawable(R.drawable.unidades4_vermelho,null);
            case R.id.botao6Unidades:
                return (Drawable) getResources().getDrawable(R.drawable.unidades6_vermelho,null);
            case R.id.botao9Unidades:
                return (Drawable) getResources().getDrawable(R.drawable.unidades9_vermelho,null);
            case R.id.botao12Unidades:
                return (Drawable) getResources().getDrawable(R.drawable.unidades12_vermelho,null);
            case R.id.gramas250:
                return (Drawable) getResources().getDrawable(R.drawable.gramas250_preto,null);
            case R.id.gramas350:
                return (Drawable) getResources().getDrawable(R.drawable.gramas350_preto,null);
            case R.id.gramas500:
                return (Drawable) getResources().getDrawable(R.drawable.gramas500_preto,null);
            case R.id.gramas700:
                return (Drawable) getResources().getDrawable(R.drawable.gramas700_preto,null);
        }
        switch (view.getContentDescription().toString()){
            case "145ml":
                return (Drawable) getResources().getDrawable(R.drawable.ml145_vermelho,null);
            case "210ml":
                return (Drawable) getResources().getDrawable(R.drawable.ml210_vermelho,null);
            case "400ml":
                return (Drawable) getResources().getDrawable(R.drawable.ml400_vermelho,null);
            case "590ml":
                return (Drawable) getResources().getDrawable(R.drawable.ml590_vermelho,null);
        }
        return null;
    }
    public Drawable recuperarImagemBrancaParaAnimacao(View view){
        switch (view.getId()){
            case R.id.botao4Unidades:
                return (Drawable) getResources().getDrawable(R.drawable.unidades4_branco,null);
            case R.id.botao6Unidades:
                return (Drawable) getResources().getDrawable(R.drawable.unidades6_branco,null);
            case R.id.botao9Unidades:
                return (Drawable) getResources().getDrawable(R.drawable.unidades9_branco,null);
            case R.id.botao12Unidades:
                return (Drawable) getResources().getDrawable(R.drawable.unidades12_branco,null);
            case R.id.gramas250:
                return (Drawable) getResources().getDrawable(R.drawable.gramas250_branco,null);
            case R.id.gramas350:
                return (Drawable) getResources().getDrawable(R.drawable.gramas350_branco,null);
            case R.id.gramas500:
                return (Drawable) getResources().getDrawable(R.drawable.gramas500_branco,null);
            case R.id.gramas700:
                return (Drawable) getResources().getDrawable(R.drawable.gramas700_branco,null);
        }
        switch (view.getContentDescription().toString()){
            case "145ml":
                return (Drawable) getResources().getDrawable(R.drawable.ml145_branco,null);
            case "210ml":
                return (Drawable) getResources().getDrawable(R.drawable.ml210_branco,null);
            case "400ml":
                return (Drawable) getResources().getDrawable(R.drawable.ml400_branco,null);
            case "590ml":
                return (Drawable) getResources().getDrawable(R.drawable.ml590_branco,null);
        }
        return null;
    }
    public void AnimarClickPermanente(ImageView img){
        ObjectAnimator objImagem= ObjectAnimator.ofFloat(img,"alpha",0.5f);
        objImagem.setDuration(80);
        objImagem.start();
    }
    //Animar Cliques
    public void animarClick(ImageView img){
        ObjectAnimator objImagem= ObjectAnimator.ofFloat(img,"alpha",0.3f);
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