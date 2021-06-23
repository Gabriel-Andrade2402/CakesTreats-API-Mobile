package com.example.cakestreats.Connection;

import android.app.VoiceInteractor;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cakestreats.Modelos.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceRequests {
    private RequestQueue requestQueue;
    private Context ctx;
    //Singleton
    private static ServiceRequests instance;
    private ServiceRequests(Context context){
        ctx=context;
        requestQueue=Volley.newRequestQueue(context);
    }
    public static ServiceRequests getInstace(Context context){
        if(instance==null){
            instance=new ServiceRequests(context);
        }
        return instance;
    }


    public void fazerLogin(User user){
        try {
            String url="http://45.93.136.212:8080/usuarios/logar";
            JSONObject json=new JSONObject();
            json.put("email",user.getEmail());
            json.put("senha",user.getSenha());
            JsonObjectRequest jsonRequest=new JsonObjectRequest(Request.Method.POST, url, json, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(response!=null) {
                        Toast.makeText(ctx, response.toString(), Toast.LENGTH_LONG).show();
                        Logger.getLogger(ServiceRequests.class.getName()).log(Level.WARNING, response.toString());
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(ctx,error.toString(),Toast.LENGTH_LONG).show();
                    Logger.getLogger(ServiceRequests.class.getName()).log(Level.WARNING,error.toString());
                }
            });
            requestQueue.add(jsonRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
