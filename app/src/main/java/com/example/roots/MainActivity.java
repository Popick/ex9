package com.example.roots;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText aET,bET,cET;
    TextView tv1,tv2;
    double a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aET = (EditText) findViewById(R.id.at);
        bET = (EditText) findViewById(R.id.bt);
        cET = (EditText) findViewById(R.id.ct);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
    }

    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if (data_back != null) {
            tv1.setText(String.valueOf(data_back.getStringExtra("x1")));
            tv2.setText(String.valueOf(data_back.getStringExtra("x2")));
        }
    }

    public void rndm(View view) {
        aET.setText(String.valueOf((Math.random() * (500+500+1)) -500));
        bET.setText(String.valueOf((Math.random() * (500+500+1)) -500));
        cET.setText(String.valueOf((Math.random() * (500+500+1)) -500));
    }

    public void go(View view) {
        if (aET.getText().toString().isEmpty()){
            aET.setError("ENTER INPUT!");
        }else if (bET.getText().toString().isEmpty()){
            bET.setError("ENTER INPUT!");
        }else if (cET.getText().toString().isEmpty()){
           cET.setError("ENTER INPUT!");
        }
        else {
            a = Double.parseDouble(aET.getText().toString());
            b = Double.parseDouble(bET.getText().toString());
            c = Double.parseDouble(cET.getText().toString());

            Intent si = new Intent(this, MainActivity2.class);
            si.putExtra("a", a);
            si.putExtra("b", b);
            si.putExtra("c", c);
            startActivityForResult(si, 1);

        }
    }
}