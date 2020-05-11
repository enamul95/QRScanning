package com.haqueit.shaitolawelfare.qrscanning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class Code_Scanner extends AppCompatActivity {

    private CodeScanner mCodeScanner;
    private Button btnNext;
    private EditText edtCardNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code__scanner);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);

         btnNext = findViewById(R.id.btnNext);
        edtCardNumber = findViewById(R.id.edtCardNumber);
        mCodeScanner = new CodeScanner(this, scannerView);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtCardNumber.getText().toString().equals("")){
                    Toast.makeText(Code_Scanner.this, "Card number can't empty", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent=new Intent(Code_Scanner.this,CardDetailsActivity.class);
                    intent.putExtra("card_number",edtCardNumber.getText().toString());
                    startActivity(intent);
                }

            }
        });
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("QR CODE==>",result.getText());
                        String qr = result.getText();
                        Log.e("QR CODE==>",qr);

                        Intent intent = new Intent(Code_Scanner.this,QR_Payment.class);
                        intent.putExtra("qr",qr);
                        startActivity(intent);
                    }
                });
            }
        });
//        mCodeScanner.setDecodeCallback(new DecodeCallback() {
//            @Override
//            public void onDecoded(@NonNull final Result result) {
//                this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(activity, result.getText(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, CardListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
