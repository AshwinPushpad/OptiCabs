package com.avinya.apps.opticabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * In this case, we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to
     * install it inside the SupportMapFragment. This method will only be triggered once the
     * user has installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Example: Add a marker in Sydney and move the camera
        LatLng indore = new LatLng(22.69237, 75.88564);
        mMap.addMarker(new MarkerOptions().position(indore).title("Random place in Indore"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(indore));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(indore, 15f));

        // Map click listener
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(@NonNull LatLng latLng) {

                //Geo Coder
                Geocoder geocoder = new Geocoder(getActivity());
                try {
                    ArrayList<Address> arrAdr= (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude,latLng.longitude,1);

                    // Get Address
                    String address = arrAdr.get(0).getAddressLine(0);
                    Log.d("TAG", arrAdr.get(0).getAddressLine(0));

                    // Add Marker at Address
                    mMap.addMarker(new MarkerOptions().position(latLng).title(address));

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        });

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        return view;
    }

    // or Define separately

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_maps, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        SupportMapFragment mapFragment =
//                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
//        if (mapFragment != null) {
//            mapFragment.getMapAsync(this);
//        }
//    }

}