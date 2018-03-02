package com.aplicando.app.colecaocia;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

/**
 * Created by User on 01/03/2018.
 */

public class MapaFragment extends SupportMapFragment implements OnMapReadyCallback {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng posicaoEmpresa = pegaCoordenadadoEndereco("Rua quatorze de julho 24A são joaquim Araçatuba São Paulo");
        if (posicaoEmpresa != null) {
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(posicaoEmpresa, 23);
            googleMap.moveCamera(update);
        }

        MarkerOptions marcador = new MarkerOptions();
        marcador.position(posicaoEmpresa);
        marcador.title("Coleção & Cia");
        googleMap.addMarker(marcador);
    }

    private LatLng pegaCoordenadadoEndereco(String endereco) {
        try {
            Geocoder geocoder = new Geocoder(getContext());
            List<Address> resultados =
                    geocoder.getFromLocationName(endereco, 1);
            if (!resultados.isEmpty()) {
                LatLng posicao = new LatLng(resultados.get(0).getLatitude(), resultados.get(0).getLongitude());
                return posicao;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

