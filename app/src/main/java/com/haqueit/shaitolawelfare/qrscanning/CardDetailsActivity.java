package com.haqueit.shaitolawelfare.qrscanning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CardDetailsActivity extends AppCompatActivity {
    private Button btnNext;
    private TextView tvCardNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvCardNumber = findViewById(R.id.tvCardNumber);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CardDetailsActivity.this,ConfirmActivity.class);
                startActivity(intent);
            }
        });
        getCardNumber();
    }

    private void getCardNumber() {

        Intent intent=getIntent();
        tvCardNumber.setText(intent.getStringExtra("card_number"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, Code_Scanner.class);
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
