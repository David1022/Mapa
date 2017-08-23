package com.nipsa.mapa;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Abrir terminal e ir a la carpeta
 *              C:\Program Files\Java\jdk1.8.0_111\bin
 * Ejecutar el comando
 *              keytool -list -v -alias "Key alias" -keystore "Key store path" -storepass "Key store password" -keypass "Key password"
 *              EJEMPLO: keytool -list -v -alias RPR -keystore "C:/Users/david.mendano/Desktop/APP RPR/AndroidStudioProjects/Nipsa.jks" -storepass nipsa2017 -keypass nipsarpr
 * Copiar huella deigital
 *              8D:BD:18:00:27:32:EE:AE:B3:F3:9F:9A:D0:71:93:17:92:EF:A9:89
 * La nueva clave se debe poner en el archivo correspondiente segun la huella digital (debug o release)
 * Abrir archivo en Mapa/app/src/[debug o release]/res/values o en las direcciones url:
 *              C:\Users\david.mendano\Desktop\APP RPR\AndroidStudioProjects\RPR\app\src\----DEBUG----\res\values
 *              C:\Users\david.mendano\Desktop\APP RPR\AndroidStudioProjects\RPR\app\src\----RELEASE----\res\values
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearCopiaLog();
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private void crearCopiaLog () {

    }
}
