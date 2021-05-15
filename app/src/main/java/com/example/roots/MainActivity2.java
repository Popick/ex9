package com.example.roots;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv1,tv2;
    double a,b,c;
    double root1, root2,determinant,real,imaginary;
    Intent gi;
    WebView wV;
    String sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        wV = (WebView) findViewById(R.id.webview);
        wV.getSettings().setJavaScriptEnabled(true);
        wV.setWebViewClient(new MyWebViewClient());

        gi = getIntent();

        tv1 = (TextView) findViewById(R.id.tv11);
        tv2 = (TextView) findViewById(R.id.tv22);



        a= gi.getDoubleExtra("a",1);
        b= gi.getDoubleExtra("b",1);
        c= gi.getDoubleExtra("c",1);


        sum = a+"x^2";
        if (b>=0){
            sum=sum+"%2B"+b+"x";
        }else{
            sum=sum+b;
        }
        if (c>=0){
            sum=sum+"%2B"+c;
        }else{
            sum=sum+c;
        }
        wV.loadUrl("https://www.google.co.il/search?q="+sum);



        root1=0;
        root2=0;

        // value a, b, and c


        // calculate the determinant (b2 - 4ac)
        determinant = b * b - 4 * a * c;

        // check if determinant is greater than 0
        if (determinant > 0) {

            // two real and distinct roots
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);

            tv1.setText("root1 = " +root1);
            tv2.setText("root2 = " +root2);
        }

        // check if determinant is equal to 0
        else if (determinant == 0) {

            // two real and equal roots
            // determinant is equal to 0
            // so -b + 0 == -b
            root1 = root2 = -b / (2 * a);
            tv1.setText("root1 = "+ root1);
            tv2.setText("");
        }

        // if determinant is less than zero
        else {

            // roots are complex number and distinct
            real = -b / (2 * a);
            imaginary = Math.sqrt(-determinant) / (2 * a);
            tv1.setText("root1 = "+real+" + "+imaginary+"i");
            tv2.setText("root2 = "+real+" - "+imaginary+"i");
        }
    }


    public void goback(View view) {
        gi.putExtra("x1",(tv1.getText().toString()));
        gi.putExtra("x2",(tv2.getText().toString()));
        setResult(RESULT_OK,gi);
        finish();
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}