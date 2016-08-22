package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   EditText mEditText1;
    EditText mEditText2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);

        mEditText2 = (EditText) findViewById(R.id.editText2);
    }



    @Override
    public void onClick(View v) {
        double a;
        double b;
        try {
             a = Double.parseDouble(mEditText1.getText().toString());

             b = Double.parseDouble(mEditText2.getText().toString());
        }catch(NumberFormatException e) {

            return;
        }

        if(v.getId() == R.id.button1){

            Intent intent = new Intent(this, SecondActivity.class);
            Log.d("UI-PART", String.valueOf(a));
            Log.d("UI-PART", String.valueOf(b));

            intent.putExtra("VALUE1",a + b);
            startActivity(intent);
        }else if(v.getId() == R.id.button2){
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE1", a - b);
            startActivity(intent);
        }else if(v.getId() == R.id.button3){
            Intent intent = new Intent(this, SecondActivity.class);
            if(a==0||b==0 ){
                intent.putExtra("error", "値が正しくありません");
                startActivity(intent);
            }else {

                intent.putExtra("VALUE1", a * b);
                startActivity(intent);
            }
        }else if(v.getId() == R.id.button4){
            Intent intent = new Intent(this, SecondActivity.class);
            if(a==0||b==0 ){
                intent.putExtra("error", "値が正しくありません");
                startActivity(intent);
            }else {
                intent.putExtra("VALUE1", a / b);
                startActivity(intent);
            }
        }




    }
}