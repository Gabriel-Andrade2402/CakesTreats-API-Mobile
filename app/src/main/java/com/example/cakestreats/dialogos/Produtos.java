package com.example.cakestreats.dialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cakestreats.Builder.BuilderProduct;
import com.example.cakestreats.R;
import com.example.cakestreats.auxiliares.ModelProducts;
import com.example.cakestreats.auxiliares.ResourcesSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produtos extends AppCompatActivity {
    private Integer idLayout;
    private String layoutAtivo;
    private ResourcesSupport resourcesSupport=ResourcesSupport.getInstance(null);
    private TextView saborSelecionado;
    private Button adicionarAoCarrinho;
    private TextView cascaSelecionada;
    private TextView cascaSelecionadaEspecial;
    private ImageView tamanhoSelecionado;
    private List<Integer> valores=new ArrayList<>();

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
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setExitTransition(new Fade());
        getWindow().setEnterTransition(new Explode());
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
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Bolos tipo 1","R$ 50,00");
        builder.show();
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Bolos tipo 1");
        preencherLinearLayout(listSabores,scrollView,new View.OnClickListener() {
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
    }

    private void atualizarBolos2() {
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Bolos tipo 2","R$ 55,00");
        builder.show();
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Bolos tipo 2");
        preencherLinearLayout(listSabores,scrollView,new View.OnClickListener() {
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
    }

    private void atualizarBolos3() {
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Bolos tipo 3"
                ,"P R$ 15,00    M R$ 16,00   G R$ 25,00");
        builder.show();
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Bolos tipo 3");
        preencherLinearLayout(listSabores,scrollView,new View.OnClickListener() {
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
    }

    private void atualizarBolos4() {
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Bolos tipo 4"
                ,"R$ 65,00");
        builder.show();
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Bolos tipo 4");
        preencherLinearLayout(listSabores,scrollView,new View.OnClickListener() {
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
    }

    private void atualizarBolosDePote(){
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Bolos No Pote"
                ,"145ml R$ 5,00 210ml R$7,00");
        builder.show();
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Bolos No Pote");
        preencherLinearLayout(listSabores,scrollView,new View.OnClickListener() {
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
    }

    private void atualizarBombonsNoPote(){
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Bombons No Pote"
                ,"145ml R$ 5,00 210ml R$7,00");
        builder.show();
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Bombons No Pote");
        preencherLinearLayout(listSabores,scrollView,new View.OnClickListener() {
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
    }

    private void atualizarBrigadeiroGourmet(){
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Brigadeiro Gourmet"
                ,"caixa 4u R$ 10,00  caixa 6u R$ 15,00  caixa 9u R$ 20,00  caixa 12u R$ 25,00");
        builder.show();
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Brigadeiro Gourmet");
        preencherLinearLayout(listSabores,scrollView,new View.OnClickListener() {
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
    }

    private void atualizarCopoDaFelicidade(){
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Copo Da Felicidade"
                ,"400ml R$ 18,00 590ml R$25,00");
        builder.show();
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        ImageView imagemMl400=(ImageView) findViewById(R.id.ml145);
        ImageView imagemMl590=(ImageView) findViewById(R.id.ml210);
        imagemMl400.setTag("R$ 18,00");
        imagemMl590.setTag("R$ 25,00");
        imagemMl400.setContentDescription("400ml");
        imagemMl590.setContentDescription("590ml");
        imagemMl400.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.ml400_branco,null));
        imagemMl590.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.ml590_branco,null));
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO");
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Copo Da Felicidade");
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
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Pão De Mel"
                ,"R$ 5,00");
        builder.show();
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO R$ 5,00");
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Pão De Mel");
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
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Taças"
                ,"R$ 85,00 - R$ 95,00");
        builder.show();
        LinearLayout scrollView=(LinearLayout) findViewById(R.id.sabores);
        //NÃO EXISTE DOIS TIPOS DE TAÇAS, EXISTEM APENAS DOIS TIPOS DE RETORNOS PARA SABORES POR CONTA DOS PREÇOS
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Taças1");
        List<String> listSabores2=resourcesSupport.retornarListaDeSaboresPorTitulo("Taças2");
        preencherLinearLayout(listSabores,scrollView,new View.OnClickListener() {
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
        preencherLinearLayout(listSabores2,scrollView,new View.OnClickListener() {
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
    }

    private void atualizarOvoSimples() {
        ImageView gramas250 = (ImageView) findViewById(R.id.gramas250);
        ImageView gramas350 = (ImageView) findViewById(R.id.gramas350);
        ImageView gramas500 = (ImageView) findViewById(R.id.gramas500);
        ImageView gramas700 = (ImageView) findViewById(R.id.gramas700);
        gramas250.setTag("R$22,00/R$27,00");
        gramas350.setTag("R$32,00/R$37,00");
        gramas500.setTag("R$42,00/R$47,00");
        gramas700.setTag("R$62,00/R$67,00");
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Ovo Simples"
                ,null);
        builder.show();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollViewCascas = (LinearLayout) findViewById(R.id.LinearLayoutCascas);
        LinearLayout scrollViewSabores = (LinearLayout) findViewById(R.id.linearLayoutSabores);
        List<String> listCascas = resourcesSupport.retornarListaDeSaboresPorTitulo("Cascas Especiais");
        List<String> listCascas2 = resourcesSupport.retornarListaDeSaboresPorTitulo("Cascas Comuns");
        List<String> listSabores = resourcesSupport.retornarListaDeSaboresPorTitulo("Ovo Simples");
        preencherLinearLayout(listCascas2, scrollViewCascas, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cascaSelecionada != null) {
                    cascaSelecionada.setTextColor(Color.parseColor("#4F4F4F"));
                    cascaSelecionada.setBackgroundColor(Color.parseColor("#FFFAFA"));
                }
                TextView tx = (TextView) v;
                tx.setElevation(20f);
                tx.setBackgroundColor(Color.parseColor("#8B4513"));
                tx.setTextColor(Color.parseColor("#FFFAFA"));
                cascaSelecionada = tx;
                calcularTotalPascoa();
            }
        });
        preencherLinearLayout(listCascas, scrollViewCascas, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tx = (TextView) v;
                if (cascaSelecionadaEspecial == null) {
                    tx.setElevation(20f);
                    Logger.getLogger(Produtos.class.getName()).log(Level.WARNING, "Entrou else");
                    tx.setBackgroundColor(Color.parseColor("#8B4513"));
                    tx.setTextColor(Color.parseColor("#FFFAFA"));
                    cascaSelecionadaEspecial = tx;
                } else {
                    if (cascaSelecionadaEspecial != null && cascaSelecionadaEspecial.getText().toString().equals(tx.getText().toString())) {
                        cascaSelecionadaEspecial.setTextColor(Color.parseColor("#4F4F4F"));
                        Logger.getLogger(Produtos.class.getName()).log(Level.WARNING, "Entrou if 1");
                        cascaSelecionadaEspecial.setBackgroundColor(Color.parseColor("#FFFAFA"));
                        cascaSelecionadaEspecial = null;
                    }
                    if (cascaSelecionadaEspecial != null && !cascaSelecionadaEspecial.getText().toString().equals(tx.getText().toString())) {
                        cascaSelecionadaEspecial.setTextColor(Color.parseColor("#4F4F4F"));
                        cascaSelecionadaEspecial.setBackgroundColor(Color.parseColor("#FFFAFA"));
                        Logger.getLogger(Produtos.class.getName()).log(Level.WARNING, "Entrou if 2");
                        tx.setElevation(20f);
                        tx.setBackgroundColor(Color.parseColor("#8B4513"));
                        tx.setTextColor(Color.parseColor("#FFFAFA"));
                        cascaSelecionadaEspecial = tx;
                    }
                }
                calcularTotalPascoa();
            }
        });
        preencherLinearLayout(listSabores, scrollViewSabores, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (saborSelecionado != null) {
                    saborSelecionado.setTextColor(Color.parseColor("#4F4F4F"));
                    saborSelecionado.setBackgroundColor(Color.parseColor("#FFFAFA"));
                }
                TextView tx = (TextView) v;
                tx.setElevation(20f);
                tx.setBackgroundColor(Color.parseColor("#8B4513"));
                tx.setTextColor(Color.parseColor("#FFFAFA"));
                saborSelecionado = tx;
                calcularTotalPascoa();
            }
        });
    }

    private void atualizarBarraRecheada(){
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Barra recheada"
                ,"P R$ 15,00  G R$ 25,00");
        builder.show();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
    }

    private void atualizarOvoTrufado(){
        ImageView gramas250=(ImageView) findViewById(R.id.gramas250);
        ImageView gramas350=(ImageView) findViewById(R.id.gramas350);
        ImageView gramas500=(ImageView) findViewById(R.id.gramas500);
        ConstraintLayout ct= findViewById(R.id.constraintLayout);
        ct.removeView(findViewById(R.id.gramas700));
        gramas250.setTag("R$32,00/R$37,00");
        gramas350.setTag("R$42,00/R$47,00");
        gramas500.setTag("R$52,00/R$57,00");
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Ovo Trufado"
                ,null);
        builder.show();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollViewCascas=(LinearLayout) findViewById(R.id.LinearLayoutCascas);
        LinearLayout scrollViewSabores=(LinearLayout) findViewById(R.id.linearLayoutSabores);
        List<String> listCascas=resourcesSupport.retornarListaDeSaboresPorTitulo("Cascas Especiais");
        List<String> listCascas2=resourcesSupport.retornarListaDeSaboresPorTitulo("Cascas Comuns");
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Ovo Trufado");
        preencherLinearLayout(listCascas2,scrollViewCascas,new View.OnClickListener() {
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
        preencherLinearLayout(listCascas,scrollViewCascas,new View.OnClickListener() {
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
        preencherLinearLayout(listSabores,scrollViewSabores,new View.OnClickListener() {
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
    }

    private void atualizarOvoDeColher(){
        ImageView gramas350=(ImageView) findViewById(R.id.gramas350);
        ImageView gramas500=(ImageView) findViewById(R.id.gramas500);
        ConstraintLayout ct= findViewById(R.id.constraintLayout);
        ct.removeView(findViewById(R.id.gramas250));
        ct.removeView(findViewById(R.id.gramas700));
        adicionarAoCarrinho=(Button)findViewById(R.id.botaoAdicionarAoCarrinho);
        BuilderProduct builder=new BuilderProduct((ImageView) findViewById(R.id.imagemBoloProdutos),(TextView)findViewById(R.id.tituloBoloProdutos)
                ,(TextView)findViewById(R.id.precoProdutos),adicionarAoCarrinho,resourcesSupport,"Ovo De Colher"
                ,null);
        builder.show();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        LinearLayout scrollViewCascas=(LinearLayout) findViewById(R.id.LinearLayoutCascas);
        LinearLayout scrollViewSabores=(LinearLayout) findViewById(R.id.linearLayoutSabores);
        List<String> listCascas2=resourcesSupport.retornarListaDeSaboresPorTitulo("Cascas Comuns");
        List<String> listCascas=resourcesSupport.retornarListaDeSaboresPorTitulo("Cascas Especiais");
        List<String> listSabores=resourcesSupport.retornarListaDeSaboresPorTitulo("Ovo De Colher1");
        List<String> listSabores2=resourcesSupport.retornarListaDeSaboresPorTitulo("Ovo De Colher2");
        preencherLinearLayout(listCascas2,scrollViewCascas,new View.OnClickListener() {
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
        preencherLinearLayout(listCascas,scrollViewCascas,new View.OnClickListener() {
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
        preencherLinearLayout(listSabores,scrollViewSabores,new View.OnClickListener() {
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
        preencherLinearLayout(listSabores2,scrollViewSabores,new View.OnClickListener() {
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
    }
    //Fim da construção do layout

    private void preencherLinearLayout(List<String> list, LinearLayout linear, View.OnClickListener on){
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMarginEnd(4);
        for(String s:list){
            TextView tx=new TextView(this);
            tx.setText(s);
            tx.setLayoutParams(params);
            tx.setBackgroundColor(Color.parseColor("#FFFAFA"));
            tx.setPadding(15,15,15,15);
            tx.setTextSize(20);
            tx.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tx.setTextColor(Color.parseColor("#4F4F4F"));
            tx.setOnClickListener(on);
            linear.addView(tx);
        }
    }
    private Integer calcTotal(){
        int total = 0;
        for(Integer i:valores){
            total+=i;
        }
        return total;
    }
    public void calcularTotalPascoa(){
        ModelProducts.calcularTotalPascoa(cascaSelecionada,cascaSelecionadaEspecial,tamanhoSelecionado
                ,saborSelecionado,adicionarAoCarrinho);
    }

    //Adicionar e subtrair kilos
    public void AdicionarKilos(View view) {
        ImageView img=(ImageView)view;
        animarClick(img);
        TextView tx=(TextView)findViewById(R.id.kilosProdutoBolo1);
        TextView preco=(TextView)findViewById(R.id.precoProdutos);
        int soma=Integer.parseInt(tx.getText().toString())+1;
        tx.setText(String.valueOf(soma));
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO R$ "+String.valueOf(Integer.parseInt(preco.getText().toString().substring(3,5))*soma)+",00");
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
        adicionarAoCarrinho.setText("ADICIONAR AO CARRINHO R$ "+String.valueOf(Integer.parseInt(preco.getText().toString().substring(3,5))*subtracao)+",00");
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


    //Auxiliares do EscolherTamanho e animações
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