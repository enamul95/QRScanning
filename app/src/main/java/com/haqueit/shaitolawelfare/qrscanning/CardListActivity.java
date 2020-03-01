package com.haqueit.shaitolawelfare.qrscanning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnNext;
    private CardViewDataAdapter mAdapter;
    private ArrayList<CardModel> dataSet= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_list);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnNext = findViewById(R.id.btnNext);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardListActivity.this, Code_Scanner.class);
                startActivity(intent);
            }
        });
        showCardList();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    void showCardList() {

        dataSet.add(new CardModel("Enamul Haque","46376760499914336","VISA","05/24",R.drawable.ic_visa,"****"));
        dataSet.add(new CardModel("Rafiqul Islam","6255676049991441","MASTER","05/24",R.drawable.mastercard,"****"));
        dataSet.add(new CardModel("Al Mamun","96376760499914412","VISA","05/24",R.drawable.ic_visa,"****"));


        recyclerView.setHasFixedSize(true);
        // ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(CardListActivity.this));
        // create an Object for Adapter
        mAdapter = new CardViewDataAdapter(dataSet);
        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);
    }
    class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder> {


        public CardViewDataAdapter(ArrayList<CardModel> os_versions) {

            dataSet = os_versions;
        }


        @Override
        public CardViewDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            // create a new view
            View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.row_menu_list, null);

            itemLayoutView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

            // create ViewHolder

            CardViewDataAdapter.ViewHolder viewHolder = new CardViewDataAdapter.ViewHolder(itemLayoutView);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(CardViewDataAdapter.ViewHolder viewHolder, int i) {

            CardModel fp = dataSet.get(i);


            viewHolder.tv_card_number.setText(fp.getCard_number());
            viewHolder.tv_card_title.setText(fp.getCard_name());
            viewHolder.card_expire.setText(fp.getCard_validity());
            viewHolder.card_cvv.setText(fp.getCard_cvv());
           viewHolder.card_icon.setImageResource(fp.getIcon());
           if("VISA".equals(fp.getCard_type())){
               //viewHolder.card.setCardBackgroundColor(Color.parseColor(String.valueOf(R.color.yellow_800)));
               viewHolder.card.setCardBackgroundColor(Color.parseColor("#F9A825"));
           }else if("MASTER".equals(fp.getCard_type())){
               viewHolder.card.setCardBackgroundColor(Color.WHITE);
               viewHolder.card.setCardBackgroundColor(Color.parseColor("#1f62af"));
           }
            viewHolder.menu = fp;
        }

        @Override
        public int getItemCount() {

            return (dataSet == null) ? 0 : dataSet.size();
            // return dataSet.size();
        }


       /* public void updateList(List<CardModel> temp) {
            dataSet = (ArrayList<CardModel>) temp;
            notifyDataSetChanged();
        }
        */


        // inner class to hold a reference to each item of RecyclerView
        public class ViewHolder extends RecyclerView.ViewHolder {


            public TextView tv_card_number;
            public TextView tv_card_title;
            public TextView card_expire;
            public TextView card_cvv;
            public ImageView card_icon;

            public CardView card;


            public CardModel menu;

            public ViewHolder(View itemLayoutView) {
                super(itemLayoutView);


                tv_card_number = (TextView) itemLayoutView.findViewById(R.id.tv_card_number);
                tv_card_title = (TextView) itemLayoutView.findViewById(R.id.tv_card_title);
                card_expire = (TextView) itemLayoutView.findViewById(R.id.card_expire);
                card_cvv = (TextView) itemLayoutView.findViewById(R.id.card_cvv);
                card_icon = (ImageView) itemLayoutView.findViewById(R.id.card_icon);

                card = itemLayoutView.findViewById(R.id.card);

                itemLayoutView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(CardListActivity.this, Code_Scanner.class);
                        startActivity(intent);


                    }
                });


            }

        }
    }
}
