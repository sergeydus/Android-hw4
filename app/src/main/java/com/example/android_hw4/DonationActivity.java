package com.example.android_hw4;

import android.content.Intent;
import android.content.SharedPreferences;
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
    float sum_donation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        sum_donation=(float)getIntent().getDoubleExtra("donation",0);
        TextView tv=findViewById(R.id.total_donate);
        float total=(float)sharedPreferences.getFloat("value",(float)0);
        tv.setText(String.valueOf((float)total)+"₪");
    }
    public void donate(View view){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        EditText ed1= findViewById(R.id.donate);
        TextView tv1=findViewById(R.id.total_donate);
        TextView tv3=findViewById(R.id.enteryourdonation);
        Button b1= findViewById(R.id.clickDonate);
        GifImageView imageView= findViewById(R.id.dancing);
        TextView tv2= findViewById(R.id.thanks);
        float num1= Float.valueOf(ed1.getText().toString());

        ed1.setVisibility(View.GONE);
        b1.setVisibility(View.GONE);
        tv3.setVisibility(View.GONE);

        float sum=num1+sum_donation;
        editor.putFloat("value",(float)sum_donation+(float)num1);
        editor.commit();
        sum_donation=sum;
        tv1.setText(String.valueOf(sum)+"₪");
        imageView.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);

    }
    public void ret(View view){
        Intent intent= new Intent(this, NoteActivity.class);
        intent.putExtra("donation",sum_donation);
        startActivity(intent);
    }
}
