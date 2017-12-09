package com.darwin.ankitsrivastava.mynyit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Barcode_Result extends AppCompatActivity {

    private int valueToFetch = BarcodeTracker.barcodeValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode__result);
    }
}
