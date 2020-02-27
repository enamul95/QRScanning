package com.haqueit.shaitolawelfare.qrscanning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CardListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnNext;
    private CardViewDataAdapter mAdapter;
    private ArrayList<MenuModel> dataSet= new ArrayList<>();
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

        dataSet.add(new MenuModel("Social payment 1", R.drawable.nfc_card, "MICO_PAYMENT"));
        dataSet.add(new MenuModel("Social payment 2", R.drawable.statement_icon3, "MICO_PAYMENT"));
        dataSet.add(new MenuModel("Social payment 3", R.drawable.e_security, "MICO_PAYMENT"));


        recyclerView.setHasFixedSize(true);
        // ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(CardListActivity.this));
        // create an Object for Adapter
        mAdapter = new CardViewDataAdapter(dataSet);
        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);
    }
    class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder> {


        public CardViewDataAdapter(ArrayList<MenuModel> os_versions) {

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

            MenuModel fp = dataSet.get(i);

            viewHolder.icon.setImageResource(fp.getIcon());
            viewHolder.tv_name.setText(fp.getMenuName());
            viewHolder.tv_soft_code.setText(fp.getSoftcode());

            viewHolder.menu = fp;
        }

        @Override
        public int getItemCount() {

            return (dataSet == null) ? 0 : dataSet.size();
            // return dataSet.size();
        }


       /* public void updateList(List<MenuModel> temp) {
            dataSet = (ArrayList<MenuModel>) temp;
            notifyDataSetChanged();
        }
        */


        // inner class to hold a reference to each item of RecyclerView
        public class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView icon;
            public TextView tv_name;
            public TextView tv_soft_code;


            public MenuModel menu;

            public ViewHolder(View itemLayoutView) {
                super(itemLayoutView);

                icon = (ImageView) itemLayoutView.findViewById(R.id.icon);
                tv_name = (TextView) itemLayoutView.findViewById(R.id.tv_name);
                tv_soft_code = (TextView) itemLayoutView.findViewById(R.id.tv_soft_code);


                itemLayoutView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if ("WALLETBAL".equals(tv_soft_code.getText().toString())) {
                           /* Intent intent = new Intent(MenuListHome.this, WalletBalance.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            if (!CheckNetwork.isOnline(MenuListHome.this)) {
                                CustomStyle.showInternetConnectionMessage(MenuListHome.this, "");
                            } else if (globalVariable.getWaletid().equals("0")) {
                                showErrorMessage(MenuListHome.this, "", "You need a wallet id");
                            } else {
                                startActivity(intent);
                            }*/
                        }


                    }
                });


            }

        }
    }
}
