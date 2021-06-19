package com.example.cakestreats;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.cakestreats.Cardapio.ActivityCardapio;
import com.example.cakestreats.Cardapio.Menu;
import com.example.cakestreats.auxiliares.ResourcesSupport;
import com.example.cakestreats.dialogos.Produtos;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=new Intent(this, ActivityCardapio.class);
        startActivity(intent);
    }
}