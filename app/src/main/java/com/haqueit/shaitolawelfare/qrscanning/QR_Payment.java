package com.haqueit.shaitolawelfare.qrscanning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class QR_Payment extends AppCompatActivity {

    TextView tv_payload_indicator_value;
    TextView tv_merchant_account_info_value;
    TextView tv_merchant_category_code_value;
    TextView tv_tramsaction_currency_value;
    TextView tv_tramsaction_amount;
    TextView tv_country_code;
    TextView tv_merchant_name;
    TextView tv_merchant_city;
    TextView tv_postal_code;
    TextView tv_crc;

    String qr= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr__payment);

        Intent intent = getIntent();
        qr = intent.getStringExtra("qr");

        Log.e("qr--",qr);



        tv_payload_indicator_value = findViewById(R.id.tv_payload_indicator_value);
        tv_merchant_account_info_value = findViewById(R.id.tv_merchant_account_info_value);
        tv_merchant_category_code_value = findViewById(R.id.tv_merchant_category_code_value);
        tv_tramsaction_currency_value = findViewById(R.id.tv_tramsaction_currency_value);
        tv_tramsaction_amount = findViewById(R.id.tv_tramsaction_amount);
        tv_country_code = findViewById(R.id.tv_country_code);
        tv_merchant_name = findViewById(R.id.tv_merchant_name);
        tv_merchant_city = findViewById(R.id.tv_merchant_city);
        tv_postal_code = findViewById(R.id.tv_postal_code);
        tv_crc = findViewById(R.id.tv_crc);

        String s = qr;

        while(s.length() > 0){
            String tag = "";
            String len = "";
            String value = "";

            tag = s.substring(0, 2);
            s = s.substring(2);


            len = s.substring(0, 2);
            s = s.substring(2);


            int covertLen = Integer.parseInt(len);
            value = s.substring(0, covertLen);
            s = s.substring(covertLen);

            if("00".equals(tag)){
                tv_payload_indicator_value.setText(value);
            }else if("02".equals(tag)){
                tv_merchant_account_info_value.setText(value);
            }else if("52".equals(tag)){
                tv_merchant_category_code_value.setText(value);
            }else if("53".equals(tag)){
                tv_tramsaction_currency_value.setText(value);
            }else if("54".equals(tag)){
                tv_tramsaction_amount.setText(value);
            }else if("58".equals(tag)){
                tv_country_code.setText(value);
            }else if("59".equals(tag)){
                tv_merchant_name.setText(value);
            }else if("60".equals(tag)){
                tv_merchant_city.setText(value);
            }else if("61".equals(tag)){
                tv_postal_code.setText(value);
            }else if("63".equals(tag)){
                tv_crc.setText(value);
            }

        }
    }
}
