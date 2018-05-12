package com.aplicando.app.colecaocia;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //webview
    ProgressBar progressBar;
    WebView webView;

    //criando os botoes
    private ImageView botaoWeb;
    private ImageView botaoMusculacao;
    private ImageView botaoEmail;
    private ImageView botaolocalizacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //localizando os botoes
        botaoWeb = (ImageView) findViewById(R.id.imageView);
        botaoMusculacao = (ImageView) findViewById(R.id.imageView2);
        botaoEmail = (ImageView) findViewById(R.id.imageView3);
        botaolocalizacao = (ImageView) findViewById(R.id.imageView4);


        //instanciando o botao web
        botaoWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TelaWeb.class));
            }
        });

        //instanciando o botao musculacao
        botaoMusculacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TelaQuemSomos.class));
            }
        });

        //instanciando o botao email
        botaoEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"flaviodepaulo99@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Assunto");
                intent.putExtra(Intent.EXTRA_TEXT, "Escrever Mensagem");
                intent.setType("massage/efc822");
                startActivity(intent);

            }catch (ActivityNotFoundException anfe) {
                Toast.makeText(MainActivity.this, "Esse email não foi encontrado", Toast.LENGTH_LONG).show();
                }}
        });

        //instanciando o botao localizacao
        botaolocalizacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapaActivity.class));
            }
        });
    }
}
