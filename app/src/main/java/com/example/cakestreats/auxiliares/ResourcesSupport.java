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
    private String[] saboresBolo1={"Limão","Maracujá","Abacaxi","Morango tradicional","Doce de leite"};
    private String[] saboresBolo2={"Ninho com morango","Ninho com abacaxi","Ganache","Brigadeiro","Beijinho","Paçoca",
    "Doce de leite com coco","Doce de leite com ameixa","Doce de leite com abacaxi"};
    private String[] saboresBolo3={"Fubá com goiabada","Laranja","Milho","Beijinho","Brigadeiro","Limão",
    "Maracujá","Pacoça","Churros","Ninho com nutella","Mandioca com coco","Banana caramelada","Abacaxi caramelado","Chocolate"};
    private String[] saboresBolo4={"Ninho com nutella","Sensação","Ferrero Rocher","Churros","Trufado de chocolate com maracujá"
    ,"Trufado de chocolate com limão","Kinder bueno"};
    public ResourcesSupport(Resources res){
        resources=res;
        imagemDialogBolo1=ResourcesCompat.getDrawable(res,R.drawable.balcao_bolo1,null);
        imagemDialogBolo2=ResourcesCompat.getDrawable(res,R.drawable.balcao_bolo2,null);
        imagemDialogBolo3=ResourcesCompat.getDrawable(res,R.drawable.balcao_bolo3,null);
        imagemDialogBolo4=ResourcesCompat.getDrawable(res,R.drawable.balcao_bolo4,null);
    }
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
        }
        return null;
    }

}
