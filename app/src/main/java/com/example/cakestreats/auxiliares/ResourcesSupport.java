package com.example.cakestreats.auxiliares;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import com.example.cakestreats.R;
import com.example.cakestreats.dialogos.Produtos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResourcesSupport{
    private Resources resources;
    //Imagens
    private Drawable imagemDialogBolo1;
    private Drawable imagemDialogBolo2;
    private Drawable imagemDialogBolo3;
    private Drawable imagemDialogBolo4;
    private Drawable imagemDialogoBolosNoPote;
    private Drawable imagemDialogoBombonsNoPote;
    private Drawable imagemDialogoCopoDaFelicidade;
    private Drawable imagemDialogoPaoDeMel;
    private Drawable imagemDialogoBrigadeiroGourmet;
    private Drawable imagemDialogoTacas;
    private Drawable imagemDialogoBarraDeChocolate;
    private Drawable imagemDialogoOvoSimples;
    private Drawable imagemDialogoOvoTrufado;
    private Drawable imagemDialogoOvoDeColher;

    //Sabores e cascas
    private String[] saboresBolo1={"Limão","Maracujá","Abacaxi","Morango tradicional","Doce de leite"};
    private String[] saboresBolo2={"Ninho com morango","Ninho com abacaxi","Ganache","Brigadeiro","Beijinho","Paçoca",
    "Doce de leite com coco","Doce de leite com ameixa","Doce de leite com abacaxi"};
    private String[] saboresBolo3={"Fubá com goiabada","Laranja","Milho","Beijinho","Brigadeiro","Limão",
    "Maracujá","Pacoça","Churros","Ninho com nutella","Mandioca com coco","Banana caramelada","Abacaxi caramelado","Chocolate"};
    private String[] saboresBolo4={"Ninho com nutella","Sensação","Ferrero Rocher","Churros","Trufado de chocolate com maracujá"
    ,"Trufado de chocolate com limão","Kinder bueno"};
    private String[] saboresBolosNoPote={"Ninho com nutella","Morango,Abacaxi","Ganache","Beijinho","Maracujá","Limão","Brigadeiro",
            "Paçoca","Doce de leite com coco","Ameixa","Abacaxi"};
    private String[] saboresBombonsNoPote={"Morango com uva","Verrine de maracujá","Morango a base de ganache","Limão a base de ganache",
            "Bolacha champanhe e mousse","Delicia de abacaxi"};
    private String[] saboresCopoDaFelicidade={"Morango a base de brigadeiro","Kinder bueno a base de brigadeiro","Nutella","Creme de leite",
            "Ninho e chantininho"};
    private String[] saboresPaoDeMel={"Doce de leite","Beijinho","Ninho com nutella","Brigadeiro"};
    private String[] saboresBrigadeiroGourmet={"Ninho com nutella","Bicho de pé","Brigadeiro tradicional","Brigadeiro belga",
    "Brigadeiro branco","Doce de leite com amendoim","Churros","Cajuzinho","Beijinho"};
    private String[] Tacas1={"Diversos sabores"};
    private String[] Tacas2={"Kinder bueno","Ferrero rocher","Rafaello","milka"};

    //PASCOA
    private String[] cascasEspeciais={"Bolacha oreo + R$ 3,00","Amendoim + R$ 3,00"};
    private String[] cascasComuns={"Casca ao leite","Casca branca"};
    private String[] saboresOvoSimples={"Chocolate ao leite","Chocolate branco"};
    private String[] saboresOvoDeColher1={"Trufa de maracujá","Trufa de limão","Brigadeiro","Ganache","Trufa de morango"
            ,"Prestígio","Paçoca","Doce de leite"};
    private String[] saboresOvoDeColher2={"Kinger bueno","Brigadeiro de ninho com nutella","Sensação","Ferrero rocher",
            "Rafaello","Doce de leite com amendoim","Brigadeiro de chocolate belga","Oreo e M&Ms","Recheio da felicidade(Uma camada brigadeiro" +
            " tradicional,brigadeiro de leite ninho,nutella,geleia de morango e chantininho)"};
    private String[] saboresOvoTrufado={"sabor1","sabor2","sabor3"};
    //Construtor
    public ResourcesSupport(Resources res){
        resources=res;
        imagemDialogBolo1=ResourcesCompat.getDrawable(res,R.drawable.balcao_bolo1,null);
        imagemDialogBolo2=ResourcesCompat.getDrawable(res,R.drawable.balcao_bolo2,null);
        imagemDialogBolo3=ResourcesCompat.getDrawable(res,R.drawable.balcao_bolo3,null);
        imagemDialogBolo4=ResourcesCompat.getDrawable(res,R.drawable.balcao_bolo4,null);
        imagemDialogoBolosNoPote=ResourcesCompat.getDrawable(res,R.drawable.balcao_bolo_no_pote,null);
        imagemDialogoBombonsNoPote=ResourcesCompat.getDrawable(res,R.drawable.balcao_bombons_no_pote,null);
        imagemDialogoCopoDaFelicidade=ResourcesCompat.getDrawable(res,R.drawable.balcao_copo_da_felicidade,null);
        imagemDialogoPaoDeMel=ResourcesCompat.getDrawable(res,R.drawable.balcao_pao_de_mel,null);
        imagemDialogoBrigadeiroGourmet=ResourcesCompat.getDrawable(res,R.drawable.balcao_brigadeiro_gourmet,null);
        imagemDialogoTacas=ResourcesCompat.getDrawable(res,R.drawable.balcao_tacas,null);
        imagemDialogoBarraDeChocolate=ResourcesCompat.getDrawable(res,R.drawable.balcao_barra_chocolate,null);
        imagemDialogoOvoDeColher=ResourcesCompat.getDrawable(res,R.drawable.ovo_de_colher,null);
        imagemDialogoOvoSimples=ResourcesCompat.getDrawable(res,R.drawable.ovo_simples,null);
        imagemDialogoOvoTrufado=ResourcesCompat.getDrawable(res,R.drawable.ovo_trufado,null);
    }

    //Retorno das imagens
    public Drawable retornarDrawablePorTitulo(String titulo){
        switch (titulo){
            case "Bolos tipo 1":
                return imagemDialogBolo1;
            case "Bolos tipo 2":
                return imagemDialogBolo2;
            case "Bolos tipo 3":
                return imagemDialogBolo3;
            case "Bolos tipo 4":
                return imagemDialogBolo4;
            case "Bolos No Pote":
                return imagemDialogoBolosNoPote;
            case "Bombons No Pote":
                return imagemDialogoBombonsNoPote;
            case "Copo Da Felicidade":
                return imagemDialogoCopoDaFelicidade;
            case "Pão De Mel":
                return imagemDialogoPaoDeMel;
            case "Brigadeiro Gourmet":
                return imagemDialogoBrigadeiroGourmet;
            case "Taças":
                return imagemDialogoTacas;
            case "Barra recheada":
                return imagemDialogoBarraDeChocolate;
            case "Ovo Simples":
                return imagemDialogoOvoSimples;
            case "Ovo De Colher":
                return imagemDialogoOvoDeColher;
            case "Ovo Trufado":
                return imagemDialogoOvoTrufado;
        }
        return null;
    }

    public List<String> retornarListaDeSaboresPorTitulo(String titulo){
        switch (titulo){
            case "Bolos tipo 1":
                return new ArrayList<String>(Arrays.asList(saboresBolo1));
            case "Bolos tipo 2":
                return new ArrayList<String>(Arrays.asList(saboresBolo2));
            case "Bolos tipo 3":
                return new ArrayList<String>(Arrays.asList(saboresBolo3));
            case "Bolos tipo 4":
                return new ArrayList<String>(Arrays.asList(saboresBolo4));
            case "Bolos No Pote":
                return new ArrayList<String>(Arrays.asList(saboresBolosNoPote));
            case "Bombons No Pote":
                return new ArrayList<String>(Arrays.asList(saboresBombonsNoPote));
            case "Copo Da Felicidade":
                return new ArrayList<String>(Arrays.asList(saboresCopoDaFelicidade));
            case "Pão De Mel":
                return new ArrayList<String>(Arrays.asList(saboresPaoDeMel));
            case "Brigadeiro Gourmet":
                return new ArrayList<String>(Arrays.asList(saboresBrigadeiroGourmet));
            case "Taças1":
                return new ArrayList<String>(Arrays.asList(Tacas1));
            case "Taças2":
                return new ArrayList<String>(Arrays.asList(Tacas2));
            case "Cascas Especiais":
                return new ArrayList<String>(Arrays.asList(cascasEspeciais));
            case "Cascas Comuns":
                return new ArrayList<String>(Arrays.asList(cascasComuns));
            case "Ovo Simples":
                return new ArrayList<String>(Arrays.asList(saboresOvoSimples));
            case "Ovo De Colher1":
                return new ArrayList<String>(Arrays.asList(saboresOvoDeColher1));
            case "Ovo De Colher2":
                return new ArrayList<String>(Arrays.asList(saboresOvoDeColher2));
            case "Ovo Trufado":
                return new ArrayList<String>(Arrays.asList(saboresOvoTrufado));
        }
        return null;
    }

    //Criar produtos
    public Produtos recuperarProduto(String titulo){
        switch (titulo){
            case "Bolos tipo 1":
                return new Produtos(R.layout.activity_produtos,"Bolos tipo 1");
            case "Bolos tipo 2":
                return new Produtos(R.layout.activity_produtos,"Bolos tipo 2");
            case "Bolos tipo 3":
                return new Produtos(R.layout.activity_produtos_bolo2,"Bolos tipo 3");
            case "Bolos tipo 4":
                return new Produtos(R.layout.activity_produtos,"Bolos tipo 4");
            case "Bolos No Pote":
                return new Produtos(R.layout.activity_produtos_padrao1,"Bolos No Pote");
            case "Bombons No Pote":
                return new Produtos(R.layout.activity_produtos_padrao1,"Bombons No Pote");
            case "Copo Da Felicidade":
                return new Produtos(R.layout.activity_produtos_padrao1,"Copo Da Felicidade");
            case "Pão De Mel":
                return new Produtos(R.layout.activity_produtos_padrao2,"Pão De Mel");
            case "Brigadeiro Gourmet":
                return new Produtos(R.layout.activity_produtos_padrao3,"Brigadeiro Gourmet");
            case "Taças":
                return new Produtos(R.layout.activity_produtos_padrao2,"Taças");
            case "Barra recheada":
                return new Produtos(R.layout.activity_produtos_padrao4,"Barra recheada");
            case "Ovo Simples":
                return new Produtos(R.layout.activity_produtos_pascoa_padrao1,"Ovo Simples");
            case "Ovo Trufado":
                return new Produtos(R.layout.activity_produtos_pascoa_padrao1,"Ovo Trufado");
            case "Ovo De Colher":
                return new Produtos(R.layout.activity_produtos_pascoa_padrao1,"Ovo De Colher");
        }
        return null;
    }
    /*Este método é baseado na hierarquia dos XMLS ConstraintsLayouts dos produtos
    sendo uma má pratica, e deve ser refatorada. a unica finalidade deste método é encotrar
    onde está o titulo do produto para que o Layout certo seja criado
     */
    public TextView retornarTituloDoLayout(ConstraintLayout cl){
        try{
            return (TextView)cl.getChildAt(0);
        }catch (Exception e){
            ConstraintLayout cons=(ConstraintLayout) cl.getChildAt(1);
            return (TextView)cons.getChildAt(1);
        }
    }
    /*Este método é baseado na hierarquia dos XMLS ConstraintsLayouts dos produtos
    sendo uma má pratica, e deve ser refatorada. a unica finalidade deste método é encotrar
    onde está a imagem preta
     */
    public ImageView retornarImagemPretaDoLayout(ConstraintLayout cl){
        try{
            return (ImageView) cl.getChildAt(cl.getChildCount()-1);
        }catch (Exception e){
            try{
                ConstraintLayout cons=(ConstraintLayout) cl.getChildAt(1);
                return (ImageView) cons.getChildAt(cl.getChildCount()-1);
            }catch (Exception ee){

            }
        }
        return null;
    }
    //Animando todos Produtos
    public Produtos ClickProduto(View view) {
        ConstraintLayout cl=(ConstraintLayout)view;
        float positionZ=cl.getZ();
        cl.setZ(1);
        ImageView img=(ImageView)retornarImagemPretaDoLayout(cl);
        animarLayoutComZoom(cl,img);
        cl.setZ(positionZ);
        TextView tx=retornarTituloDoLayout(cl);
        Produtos p=recuperarProduto(tx.getText().toString());
        return p;
    }
    //AnimarLayout com zoom
    public void animarLayoutComZoom(ConstraintLayout cl,ImageView img){
        ObjectAnimator objImagem= ObjectAnimator.ofFloat(img,"alpha",1f);
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
    }
}
