package com.example.juhi_gupta.pizza_corner;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.juhi_gupta.pizza_corner.R.id.quantity;


public class Home_Delivery_Activity extends AppCompatActivity{

    int flag = 0;
    Button reset;
    TextView textView;
    CheckBox option_1, option_2, option_3;
    EditText editText, editText2, editText4, editText3, editText5, editText6, editText7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        textView = (TextView)findViewById(R.id.items);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);
        editText7 = (EditText)findViewById(R.id.editText7);

        option_1 = (CheckBox)findViewById(R.id.option_1);
        option_2 = (CheckBox)findViewById(R.id.option_2);
        option_3 = (CheckBox)findViewById(R.id.option_3);

        Toast.makeText(getApplicationContext(), "only Cash-On-Delivery available", Toast.LENGTH_LONG).show();
    }

    public void rate_page(View v)
    {
        Intent intent = new Intent();
        intent.setClass(this, Rate_Us_Activity.class);
        startActivity(intent);
    }

    public void reset_all_input_parameters(View v)
    {
        reset = (Button) findViewById(R.id.Cancel);
        if (v == reset)
            startActivity(new Intent(Home_Delivery_Activity.this, Home_Delivery_Activity.class));
        Toast.makeText(getApplicationContext(), "You Clicked Cancel", Toast.LENGTH_SHORT).show();

    }

    public void open(final View view)
    {
        if (editText.getText().length()!=0 && editText2.getText().length()==0 && editText4.getText().length()==0 &&
            editText3.getText().length()==0 && editText5.getText().length()==0 && editText6.getText().length()==0 &&
            editText7.getText().length()==0)
        {
            Toast.makeText(getApplicationContext(), "Please fill in all the Details !", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Home_Delivery_Activity.this, Home_Delivery_Activity.class));
        }
        if (((option_1.isChecked() && option_2.isChecked() && option_3.isChecked()) ||
            (option_1.isChecked() || option_2.isChecked() || option_3.isChecked())) &&
                    (editText.getText().length()==0 || editText2.getText().length()==0 || editText4.getText().length()==0 ||
                            editText3.getText().length()==0 || editText5.getText().length()==0 || editText6.getText().length()==0 ||
                            editText7.getText().length()==0))
        {
            Toast.makeText(getApplicationContext(), "Please fill in all the Details !", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Home_Delivery_Activity.this, Home_Delivery_Activity.class));
        }
        if(editText.getText().length()==0 || editText2.getText().length()==0 || editText4.getText().length()==0 ||
            editText3.getText().length()==0 || editText5.getText().length()==0 || editText6.getText().length()==0 ||
                editText7.getText().length()==0)
        {
            if (!option_1.isChecked() && !option_2.isChecked() && !option_3.isChecked()) {
                editText.setError("Name cannot be left blank");
                editText2.setError("Quantity cannot be left blank");
                editText4.setError("Mobile Number cannot be left blank");
                editText3.setError("Address cannot be left blank");
                editText5.setError("Delivery Date cannot be left blank");
                textView.setError("Select Item");
                Toast.makeText(getApplicationContext(), "Input Fields Should Not be Left Blank !", Toast.LENGTH_LONG).show();
            }
        }
        else if (!option_1.isChecked() && !option_2.isChecked() && !option_3.isChecked())
            {
                textView.setError("Select Item");
                Toast.makeText(getApplicationContext(), "Item(s) to be Delivered Are Left Unselected !", Toast.LENGTH_LONG).show();

            }
        else
            {
                if(check(view)==0) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                    alertDialogBuilder.setMessage("Are you sure, You wanted to make decision");
                    alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(Home_Delivery_Activity.this, "You Clicked Yes Button", Toast.LENGTH_LONG).show();
                            onYes(view);
                            Toast.makeText(getApplicationContext(), "Check Message For Confirmation", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Home_Delivery_Activity.this, Home_Delivery_Activity.class));
                        }
                    });

                    alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            startActivity(new Intent(Home_Delivery_Activity.this, Home_Delivery_Activity.class));
                        }

                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid Details", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Home_Delivery_Activity.this, Home_Delivery_Activity.class));
                    flag = 0;
                }
            }
    }

    public void onYes(View v)
    {
        String tittle = "Pizza Delivery Status @Pizza_Corner";
        String subject = "Confirmation Message";
        String body = "Your Order is Confirmed !";

        NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notify=new Notification.Builder
                (getApplicationContext()).setContentTitle(tittle).setContentText(body).
                setContentTitle(subject).setSmallIcon(R.drawable.home_icon).build();

        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        notif.notify(0, notify);
    }
    public int check(View view)
    {

        String quantity_number = editText2.getText().toString();
        int quantity = Integer.parseInt(quantity_number);
        String dd = editText5.getText().toString();
        int day = Integer.parseInt(dd);
        String mm = editText6.getText().toString();
        int month = Integer.parseInt(mm);
        String yyyy =  editText7.getText().toString();
        int year  = Integer.parseInt(yyyy);
        String mobno = editText4.getText().toString();
        int mob = Integer.parseInt(mobno);

        if (quantity < 1 ){
            editText2.setError("Invalid Quantity");
            flag = 1;
        }
        if (quantity > 1000)
        {
            editText2.setError("Invalid Limit");
            flag = 1;
        }
        if (mob != 0) {
            int counter = 0;
            for(char c : mobno.toCharArray()) {
                if( c >= '0' && c<= '9') {
                    ++counter;
                }
            }
            if (counter < 10 || counter > 10) {
                editText4.setError("Invalid Mobile Number");
                flag = 1;
            }
        }
        if (day < 1 || day > 31) {
            editText5.setError("Invalid Day");
            flag = 1;
        }
        if (month < 1 || month > 12) {
            editText6.setError("Invalid Month");
            flag = 1;
        }
        if (year != 2017) {
            editText7.setError("Order for current year only");
            flag = 1;
        }
        if (flag == 0)
            return 0;
        else
            return 1;


    }
}
