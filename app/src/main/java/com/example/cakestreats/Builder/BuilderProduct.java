package com.example.cakestreats.Builder;

import android.widget.Button;
import android.widget.ImageView;

import android.widget.TextView;

import com.example.cakestreats.auxiliares.ResourcesSupport;


public class BuilderProduct implements Protocol {
    //Atributos
    public ImageView imImageProduct;
    public TextView txTitleProduct;
    public TextView txPriceProduct;
    public Button btAddInCar;
    private String typeBolo;
    private String price;
    public ResourcesSupport resourcesSupport;

    //Construtores
    public BuilderProduct(){}

    public BuilderProduct(ImageView imImageProduct, TextView txTitleProduct, TextView txPriceProduct,
                          Button btAddInCar, ResourcesSupport resourcesSupport, String typeBolo, String price) {
        this.typeBolo=typeBolo;
        this.price=price;
        this.imImageProduct = imImageProduct;
        this.txTitleProduct = txTitleProduct;
        this.txPriceProduct = txPriceProduct;
        this.btAddInCar = btAddInCar;
        this.resourcesSupport = resourcesSupport;

    }
    //Getters e Setters


    public ImageView getImImageProduct() {
        return imImageProduct;
    }

    public void setImImageProduct(ImageView imImageProduct) {
        this.imImageProduct = imImageProduct;
    }

    public TextView getTxTitleProduct() {
        return txTitleProduct;
    }

    public void setTxTitleProduct(TextView txTitleProduct) {
        this.txTitleProduct = txTitleProduct;
    }

    public TextView getTxPriceProduct() {
        return txPriceProduct;
    }

    public void setTxPriceProduct(TextView txPriceProduct) {
        this.txPriceProduct = txPriceProduct;
    }

    public ResourcesSupport getResourcesSupport() {
        return resourcesSupport;
    }

    public void setResourcesSupport(ResourcesSupport resourcesSupport) {
        this.resourcesSupport = resourcesSupport;
    }

    public Button getBtAddInCar() {
        return btAddInCar;
    }

    public void setBtAddInCar(Button btAddInCar) {
        this.btAddInCar = btAddInCar;
    }

    @Override
    public void show() {
        imImageProduct.setImageDrawable(resourcesSupport.retornarDrawablePorTitulo(typeBolo));
        txTitleProduct.setText(typeBolo);
        if(txPriceProduct!=null) {
            txPriceProduct.setText(price);
            if(price.length()>8) {
                btAddInCar.setText("ADICIONAR AO CARRINHO ");
            }else {
                btAddInCar.setText("ADICIONAR AO CARRINHO " + price);
            }
        }
    }

}
