package com.example.android_hw4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.DoubleBuffer;

import pl.droidsonroids.gif.GifImageView;

public class DonationActivity extends AppCompatActivity {
    double sum_donation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        sum_donation=getIntent().getDoubleExtra("donation",0);
        TextView tv=findViewById(R.id.total_donate);
        tv.setText(Double.toString(sum_donation)+"₪");
    }
    public void donate(View view){
        EditText ed1= findViewById(R.id.donate);
        TextView tv1=findViewById(R.id.total_donate);
        TextView tv3=findViewById(R.id.enteryourdonation);
        Button b1= findViewById(R.id.clickDonate);
        GifImageView imageView= findViewById(R.id.dancing);
        TextView tv2= findViewById(R.id.thanks);
        Double num1= Double.valueOf(ed1.getText().toString());

        ed1.setVisibility(View.GONE);
        b1.setVisibility(View.GONE);
        tv3.setVisibility(View.GONE);

        Double sum=num1+sum_donation;
        sum_donation=sum;
        tv1.setText(sum.toString()+"₪");
        imageView.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);

    }
    public void ret(View view){
        Intent intent= new Intent(this, NoteActivity.class);
        intent.putExtra("donation",sum_donation);
        startActivity(intent);
    }
    public void onBackPressed(){

    }
}
