package com.aplicando.app.colecaocia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    //webview
    ProgressBar progressBar;
    WebView webView;

    //criando os botoes
    private ImageView botaoWeb;
    private ImageView botaoMusculacao;
    private ImageView botaoGinastica;
    private ImageView botaolocalizacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //localizando os botoes
        botaoWeb = (ImageView) findViewById(R.id.imageView);
        botaoMusculacao = (ImageView) findViewById(R.id.imageView2);
        botaoGinastica = (ImageView) findViewById(R.id.imageView3);
        botaolocalizacao = (ImageView) findViewById(R.id.imageView4);


        //instanciando oo botao web
        botaoWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TelaWeb.class));
            }
        });

        //instanciando oo botao musculacao
        botaoMusculacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TelaQuemSomos.class));
            }
        });

        //instanciando oo botao ginastica
        botaoGinastica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Tela03.class));
            }
        });

        //instanciando oo botao localizacao
        botaolocalizacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapaActivity.class));
            }
        });

    }
}
