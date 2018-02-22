package com.example.juhi_gupta.pizza_corner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu_Page_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);
    }
    public void home_page(View view){
        Intent intent = new Intent();
        intent.setClass(this, Home_Delivery_Activity.class);
        startActivity(intent);

    }
    public void back(View view){
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}