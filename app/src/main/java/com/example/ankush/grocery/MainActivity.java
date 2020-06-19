package com.example.ankush.grocery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        int[] imageArray = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5,
                R.drawable.image6, R.drawable.image7, R.drawable.image8};
        int[] priceArray = {2199, 1199, 1499, 999, 1499, 3500 , 2299, 1800};
        String[] modelNames = {"Reebok K15", "Nike Formals", "Locco Black", "Adidas Floaters", "Nike Sports", "Puma Black",

                "Formal HRK", "Reebok Sky"};
        recyclerView.setAdapter(new ItemAdapter(this,imageArray, priceArray, modelNames));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuitem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.checkout :
                startActivity(new Intent(MainActivity.this, CheckoutActivity.class));
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }
}


   