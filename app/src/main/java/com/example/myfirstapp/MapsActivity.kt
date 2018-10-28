package com.example.myfirstapp

import android.support.v4.app.FragmentActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.widget.Toast
import android.location.Geocoder
import android.widget.EditText

import android.location.Address;

import android.view.*;
import com.google.android.gms.maps.model.CircleOptions
import java.io.IOException





class MapsActivity : FragmentActivity(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val message = intent.getStringExtra(MainActivity.EXTRA_LOCATION)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val intent = intent
        val location = intent.getStringExtra(MainActivity.EXTRA_LOCATION)

        var addressList: List<Address>? = null

        if (location != null || location != "") {
            val geocoder = Geocoder(this)
            try {
                addressList = geocoder.getFromLocationName(location, 1)

            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

            val address = addressList!![0]
            val admin = address.adminArea
            val locality = address.locality
            val country = address.countryName
            val Snip = "Country - " + country + ",State - " + admin + ",City - " + locality;
            val latLng = LatLng(address.getLatitude(), address.getLongitude())



        mMap!!.addMarker(MarkerOptions().position(latLng).title(location.toString()).snippet(Snip.toString()))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))

    }
}
