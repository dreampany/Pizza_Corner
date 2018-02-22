package com.example.juhi_gupta.pizza_corner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Rate_Us_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_page);
    }
    public  void onSubmit(View view)
    {
        Toast.makeText(getApplicationContext(),"Thanks For Rating", Toast.LENGTH_SHORT).show();
    }
    public void home_navigation(View v)
    {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}