package com.haqueit.shaitolawelfare.qrscanning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {

    int PERMISSION_ALL = 1;
    String[] PERMISSIONS = {
            Manifest.permission.CAMERA,
            android.Manifest.permission.INTERNET,


    };

    Button code_scanner;
    Button visa_payment;
    Button cardDetails;
    Button scanToPay;
    Button confirm;
    Button visa_qr_testing;
    Button btnQrPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }

        code_scanner = findViewById(R.id.code_scanner);
        visa_payment = findViewById(R.id.visa_payment);
        cardDetails = findViewById(R.id.cardDetails);
        scanToPay = findViewById(R.id.scanToPay);
        confirm = findViewById(R.id.confirm);
        visa_qr_testing = findViewById(R.id.visa_qr_testing);
        btnQrPayment = findViewById(R.id.btnQrPayment);

        btnQrPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Payement_CardList.class);
                startActivity(intent);
            }
        });


        code_scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Code_Scanner.class);
                startActivity(intent);
            }
        });


        visa_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CardListActivity.class);
                startActivity(intent);
            }
        });
        cardDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, CardDetailsActivity.class);
                startActivity(intent);
            }
        });
        scanToPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScanToPayActivity.class);
                startActivity(intent);
            }
        });confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                startActivity(intent);
            }
        });

        visa_qr_testing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Scan_Testing_Visa_QR.class);
                startActivity(intent);
            }
        });
    }


    public static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

}
