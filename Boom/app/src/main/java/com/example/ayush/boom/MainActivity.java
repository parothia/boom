package com.example.ayush.boom;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static TextView tv,tvv;
    public static Button btn,btn2;
    public static WebView webView;
    String URL,URl;
    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseAdapter = new DatabaseAdapter(this);
        databaseAdapter = databaseAdapter.open();
        tv = (TextView) findViewById(R.id.textView2);
        tvv=(TextView)findViewById(R.id.textView);
        btn=(Button)findViewById(R.id.loginn);
        btn2=(Button)findViewById(R.id.login2);
        webView=(WebView)findViewById(R.id.webView);
        URL="https://www.facebook.com";
        URl="https://www.google.com";
        submit();
    }
    public void submit()
    {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Login.class);
                startActivity(in);
            }
        });
        tvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Signin.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getScrollBarStyle();
                webView.loadUrl(URL);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getScrollBarStyle();
                webView.loadUrl(URl);

            }
        });
    }
   /* public void signIn(View V) {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.signin);
        dialog.setTitle("Login");
        final EditText editTextUserName = (EditText) dialog
                .findViewById(R.id.email);
        final EditText editTextPassword = (EditText) dialog
                .findViewById(R.id.password);
        TextView tvv = (TextView) dialog.findViewById(R.id.textView);

       tvv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String email = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String storedPassword = databaseAdapter
                        .getSinlgeEntry(email);
                if (password.equals(storedPassword)) {
                    Toast.makeText(MainActivity.this,
                            "Congrats: Login Successfull", Toast.LENGTH_LONG)
                            .show();
                    dialog.dismiss();
                    Intent main = new Intent(MainActivity.this, Map.class);
                    startActivity(main);
                } else {
                    Toast.makeText(MainActivity.this,
                            "User Name or Password does not match",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseAdapter.close();
    } */
}
