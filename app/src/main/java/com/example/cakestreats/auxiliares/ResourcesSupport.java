package com.example.cakestreats.auxiliares;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import com.example.cakestreats.ManipularDialogos;
import com.example.cakestreats.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String[] saboresBolo1={"Limão","Maracujá","Abacaxi","Morango tradicional","Doce de leite"};
    private String[] saboresBolo2={"Ninho com morango","Ninho com abacaxi","Ganache","Brigadeiro","Beijinho","Paçoca",
    "Doce de leite com coco","Doce de leite com ameixa","Doce de leite com abacaxi"};
    private String[] saboresBolo3={"Fubá com goiabada","Laranja","Milho","Beijinho","Brigadeiro","Limão",
    "Maracujá","Pacoça","Churros","Ninho com nutella","Mandioca com coco","Banana caramelada","Abacaxi caramelado","Chocolate"};
    private String[] saboresBolo4={"Ninho com nutella","Sensação","Ferrero Rocher","Churros","Trufado de chocolate com maracujá"
    ,"Trufado de chocolate com limão","Kinder bueno"};
    private String[] saboresBolosNoPote={"Ninho com nutella,Morango,Abacaxi,Ganache,Beijinho,Maracujá,Limão,Brigadeiro",
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
        imagemDialogoBarraDeChocolate=ResourcesCompat.getDrawable(res,R.drawable.barra_chocolate,null);
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
        }
        return null;
    }
    /*public Integer retornarIdDoLayoutPorTitulo(String titulo){
        switch (titulo){
            case "Bolos tipo 1":
                return R.layout.dialog_bolos;
            case "Bolos tipo 2":
                return R.layout.dialog_bolos;
            case "Bolos tipo 3":
                return R.layout.dialog_bolos;
            case "Bolos tipo 4":
                return R.layout.dialog_bolos;

        }
        return null;
    } */
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
        }
        return null;
    }

}
