package com.aplicando.app.colecaocia;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class TelaWeb extends AppCompatActivity {

    ProgressBar progressBar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_web);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        webView = (WebView) findViewById(R.id.webView);

        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState);
        } else {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setSupportZoom(false);
            webView.getSettings().setBuiltInZoomControls(false);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webView.setBackgroundColor(Color.WHITE);

            webView.setWebViewClient(new ourViewClient());

            webView.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView View, int progress) {
                    progressBar.setProgress(progress);
                    if (progress < 100 && progressBar.getVisibility() == ProgressBar.GONE){
                        progressBar.setVisibility(ProgressBar.VISIBLE);
                    }
                    if (progress == 100) {
                        progressBar.setVisibility(ProgressBar.GONE);

                    }
                }
            });

            String data = getIntent().getDataString();
            if (Intent.ACTION_VIEW.equals(getIntent().getAction())) {
                webView.loadUrl(data);
            } else {
                webView.loadUrl("https://www.facebook.com/flavio.depaulo.16?pnref=lhc.friends");
            }
        }
    }

    public class ourViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView v, String url) {
            if (url.contains("http://facebook.com")) {
                v.loadUrl(url);
                CookieManager.getInstance().setAcceptCookie(true);
            } else {
                Uri uri = Uri.parse(url);
                startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Escolha o Navegador"));
            }
            return true;
        }

        @Override
        public void onPageCommitVisible(WebView view, String url) {
            super.onPageCommitVisible(view, url);
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.canGoBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);

        // adiciona botao up navigation - funciona
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    // faz parte botao up navigation - funciona
    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home){

            // o metodo finish() vai encerrar essa activity
            finish();
            return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}
