package com.example.cakestreats.auxiliares;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cakestreats.R;

public class ModelProducts {
    public static void calcularTotalPascoa(TextView cascaSelecionada, TextView cascaSelecionadaEspecial,
                                           ImageView tamanhoSelecionado, TextView saborSelecionado, Button adicionarAoCarrinho){
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

}
