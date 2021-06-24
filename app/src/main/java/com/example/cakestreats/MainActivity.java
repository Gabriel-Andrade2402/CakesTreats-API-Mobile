package com.example.cakestreats;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cakestreats.Cardapio.ActivityCardapio;
import com.example.cakestreats.Modelos.User;
import com.example.cakestreats.Profile.Profile;
import com.example.cakestreats.auxiliares.ManipularTextos;

import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout ct;
    private Integer controlLoginRequest=null;
    private TextView txWarningEmail;
    private TextView txWarningEmail2;
    private TextView txWarningNome;
    private TextView txWarningSenha;
    private TextView txWarningSenha2;
    private TextView txWarningTelefone;
    private EditText etNome;
    private EditText etEmail;
    private EditText etEmail2;
    private EditText etSenha;
    private EditText etSenha2;
    private EditText etTelefone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.introduction);
        findViewById(R.id.mainLayoutIntroduction);
        ct= (ConstraintLayout)findViewById(R.id.mainLayoutIntroduction);
        animator();
    }
    public void animator(){
        ObjectAnimator objImagem= ObjectAnimator.ofFloat(findViewById(R.id.logomarcaIntroduction),"alpha",1f);
        objImagem.setDuration(3000);
        ObjectAnimator objImagem2= ObjectAnimator.ofFloat(findViewById(R.id.nomeLogomarcaIntroduction),"alpha",1f);
        objImagem.setDuration(3000);
        AnimatorSet anm=new AnimatorSet();
        anm.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                introduction();
            }
        });
        anm.play(objImagem).with(objImagem2);
        anm.start();
    }

    public void introduction(){
        ct.removeAllViews();
        getLayoutInflater().inflate(R.layout.login,ct);
    }
    public void logar(View view){
        User user = iniciarUsuarioLogin();
        if(controlLoginRequest==null) {
            Profile prof = Profile.getInstance(null);
            prof.exitProfile();
        }
        if(user!=null){
            fazerLogin(user,(Button)view);
        }
    }
    public void fazerLogin(User user,Button view) {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());;
        try {
            String url="http://45.93.136.212:8080/usuarios/logar";
            JSONObject json=new JSONObject();
            json.put("email",user.getEmail());
            json.put("senha",user.getSenha());
            JsonObjectRequest jsonRequest=new JsonObjectRequest(Request.Method.POST, url, json, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(response!=null) {
                        Profile.getInstance(user);
                        view.setText("Logando...");
                        iniciarActivityCardapio();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                 txWarningEmail.setText("Ocorreu um erro");
                }
            });
            requestQueue.add(jsonRequest);
        } catch (Exception e) {
            e.printStackTrace();
            txWarningEmail.setText("Ocorreu um erro");
        }

    }

    private void iniciarActivityCardapio() {
        Intent intent=new Intent(this, ActivityCardapio.class);
        startActivity(intent);
    }

    public void cadastrar(View view) {
        if (iniciarUsuarioCadastro() != null) {
            iniciarActivityCardapio();
        }
    }
    public void botaoVoltar(View view) {
        ct.removeAllViews();
        getLayoutInflater().inflate(R.layout.login,ct);
    }
    public void iniciarCadastro(View view) {
        ct.removeAllViews();
        getLayoutInflater().inflate(R.layout.cadastrar,ct);
    }


    public User iniciarUsuarioLogin(){
        if(checarPreenchimentoLogin()){
            {
                int i=0;
                if (!checarFormatoEmail()) {
                    i+=1;
                }
                if(!checarFormatoSenha()){
                    i+=1;
                }
                if(i>0){
                    return null;
                }
            }
            return new User(null,etEmail.getText().toString(),
                    null,null,etSenha.getText().toString());
        }
        return null;
    }
    public User iniciarUsuarioCadastro(){
        if(checarPreenchimentoCadastro()){
            if(checarIgualdade()){
                {
                    int i=0;
                    if (!checarFormatoEmail()) {
                        i+=1;
                    }
                    if(!checarFormatoSenha()){
                        i+=1;
                    }
                    if(i>0){
                        return null;
                    }
                }
                return  new User(etNome.getText().toString(),etEmail.getText().toString(),
                        etTelefone.getText().toString(),null,etSenha.getText().toString());
            }
        }
        return null;
    }




    public boolean checarFormatoEmail(){
        txWarningEmail.setText("");
        if(!ManipularTextos.cfEmail(etEmail.getText().toString())){
            txWarningEmail.setText("* Formato do email não corresponde ao padrão ex: gabriel.andrade2402@gmail.com");
            return false;
        }
        return ManipularTextos.cfEmail(etEmail.getText().toString());
    }
    public boolean checarFormatoSenha(){
        txWarningSenha.setText("");
        if(!ManipularTextos.cfSenha(etSenha.getText().toString())){
            txWarningSenha.setText("* Formato da senha não corresponde ao padrão digite mais de 8 caracters com apenas letras e números");
            return false;
        }
        return ManipularTextos.cfSenha(etSenha.getText().toString());
    }
    public boolean checarPreenchimentoLogin() {
        etEmail = findViewById(R.id.editTextEmail);
        etSenha = findViewById(R.id.editTextSenha);
        txWarningEmail = findViewById(R.id.txWarningEmail);
        txWarningSenha = findViewById(R.id.txWarningSenha);
        txWarningEmail.setText("");
        txWarningSenha.setText("");
        if(etEmail.length()==0 || etSenha.length()==0){
            if (etEmail.length() == 0) {
                txWarningEmail.setText("* campo obrigatório");
            }
            if (etSenha.length() == 0) {
                txWarningSenha.setText("* campo obrigatório");
            }
            return false;
        }
        return true;
    }
    public boolean checarPreenchimentoCadastro(){
        txWarningEmail=findViewById(R.id.txWarningEmail);
        txWarningEmail2=findViewById(R.id.txWarningEmail2);
        txWarningNome=findViewById(R.id.txWarningNome);
        txWarningSenha=findViewById(R.id.txWarningSenha);
        txWarningSenha2=findViewById(R.id.txWarningSenha2);
        txWarningTelefone=findViewById(R.id.txWarningTelefone);
        etNome=findViewById(R.id.editTextName);
        etEmail=findViewById(R.id.editTextEmail);
        etEmail2=findViewById(R.id.editTextEmail2);
        etSenha=findViewById(R.id.editTextSenha);
        etSenha2=findViewById(R.id.editTextSenha2);
        etTelefone=findViewById(R.id.editTextTelefone);
        if(etNome.length()==0){
            txWarningNome.setText("Preencha o campo nome");
            return false;
        }
        if(etNome.length()==0){
            txWarningEmail.setText("Preencha o campo email");
            return false;
        }
        if(etEmail2.length()==0){
            txWarningEmail2.setText("Preencha o campo");
            return false;
        }
        if(etSenha.length()==0){
            txWarningSenha.setText("Preencha o campo senha");
            return false;
        }
        if(etSenha2.length()==0){
            txWarningSenha2.setText("Preencha o campo");
            return false;
        }
        if(etTelefone.length()==0){
            txWarningTelefone.setText("Preencha o campo telefone");
            return false;
        }
        return true;
    }
    public boolean checarIgualdade(){
        EditText etEmail=findViewById(R.id.editTextEmail);
        EditText etEmail2=findViewById(R.id.editTextEmail2);
        EditText etSenha=findViewById(R.id.editTextSenha);
        EditText etSenha2=findViewById(R.id.editTextSenha2);
        if(!ManipularTextos.cfIgualdade(etEmail.getText().toString(),etEmail2.getText().toString())){
            TextView txWarningEmail=findViewById(R.id.txWarningEmail);
            txWarningEmail.setText("Os Emails não correspondem");
            return false;
        }
        if(!ManipularTextos.cfIgualdade(etSenha.getText().toString(),etSenha2.getText().toString())){
            TextView txWarningSenha=findViewById(R.id.txWarningSenha);
            txWarningSenha.setText("As senhas não correspondem");
            return false;
        }
        return true;
    }
}