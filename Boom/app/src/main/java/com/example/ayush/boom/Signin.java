package com.example.ayush.boom;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends AppCompatActivity {
    //public static DatabaseHelper mydb;
    public  static EditText email,password;
    public static Button button;
    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        databaseAdapter = new DatabaseAdapter(this);
        databaseAdapter = databaseAdapter.open();
       // mydb=new DatabaseHelper(this);
        email=(EditText)findViewById(R.id.email);
        password= (EditText)findViewById(R.id.password);
        button = (Button)findViewById(R.id.loginn);
       // submit();
       // view();
        signIn();
    }

    public void signIn() {
        //final Dialog dialog = new Dialog(Signin.this);
        //dialog.setContentView(R.layout.signin);
       // dialog.setTitle("Login");
        //final EditText editTextUserName = (EditText) dialog
        //        .findViewById(R.id.email);
       // final EditText editTextPassword = (EditText) dialog
       //         .findViewById(R.id.password);
       // TextView tvv = (TextView) dialog.findViewById(R.id.textView);

        final EditText editTextUserName = (EditText)
                findViewById(R.id.email);
         final EditText editTextPassword = (EditText)
                 findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String email =editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String storedPassword = databaseAdapter
                        .getSinlgeEntry(email);
                if (password.equals(storedPassword)) {
                    Toast.makeText(Signin.this,
                            "Congrats: Login Successfull", Toast.LENGTH_LONG)
                            .show();
                    // dialog.dismiss();
                    Intent main = new Intent(Signin.this, Map.class);
                    startActivity(main);
                } else {
                    Toast.makeText(Signin.this,
                            "User Name or Password does not match",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

       // dialog.show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseAdapter.close();
    }

  /* public void submit()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent in= new Intent(getApplicationContext(),Map.class);
                    startActivity(in);
            }
        });
    }*/
    /*public  void view()
    {


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getalldata();
                if (res.getCount() == 0) {
                    show("Error", "Nothing to show");
                    return;
                }
                //String s=res.getString(2);
                  //  Toast.makeText(Signin.this,s.toString(),Toast.LENGTH_LONG).show();
                //StringBuffer buffer = new StringBuffer();


                //show("data", buffer.toString());
            }
        });


    }
    public  void show( String title, String Message)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();



    }*/


}
