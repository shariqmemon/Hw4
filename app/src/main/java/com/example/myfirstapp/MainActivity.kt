package com.example.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent;

import android.view.*;
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.EditText







class MainActivity : AppCompatActivity() {


    companion object {
        val EXTRA_LOCATION = "com.example.myfirstapp.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendLocation(view: View) {
        val intent = Intent(this,MapsActivity::class.java)
        val editText = findViewById<View>(R.id.edit_location) as EditText
        val location = editText.text.toString()
        intent.putExtra(EXTRA_LOCATION, location)
        startActivity(intent);
    }


}
