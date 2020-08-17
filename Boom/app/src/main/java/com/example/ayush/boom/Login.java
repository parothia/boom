package com.example.ayush.boom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
  // public static DatabaseHelper mydb;
    public  static EditText name,lastname,email,password,birthdate;
    public static Button button;
    public static Button button2;
    Context context = this;
    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseAdapter = new DatabaseAdapter(this);
        databaseAdapter = databaseAdapter.open();
        name = (EditText)findViewById(R.id.name);
        lastname= (EditText)findViewById(R.id.lastname);
        email=(EditText)findViewById(R.id.email);
        password= (EditText)findViewById(R.id.password);
        birthdate=(EditText)findViewById(R.id.birthdate);
        button = (Button)findViewById(R.id.login);
        button2=(Button)findViewById(R.id.login2);

       // insert();
       // view();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = name.getText().toString();
                String pasword = password.getText().toString();
                String lastName = lastname.getText().toString();
                String e_mail = email.getText().toString();
                String bdate = birthdate.getText()
                        .toString();
                if (firstName.equals("") || pasword.equals("")
                        || lastName.equals("") || e_mail.equals("") || bdate.equals("")) {

                    Toast.makeText(getApplicationContext(), "Field Vaccant",
                            Toast.LENGTH_LONG).show();
                    return;
                } else {

                    databaseAdapter.insertEntry(firstName, lastName, e_mail, pasword, bdate);
                    Toast.makeText(getApplicationContext(),
                            "Account Successfully Created ", Toast.LENGTH_LONG)
                            .show();
                    Intent i = new Intent(Login.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();

                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

       databaseAdapter.close();
    }

   /* public void insert()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),Map.class);
                startActivity(in);
                boolean isinserted = mydb.insertdate(name.getText().toString(), lastname.getText().toString(), email.getText().toString(), password.getText().toString(), birthdate.getText().toString());
                if (isinserted == true)
                    Toast.makeText(Login.this, "Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Login.this, " Not inserted", Toast.LENGTH_LONG).show();
            }
        });


    }


    public  void view()
    {


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getalldata();
                if (res.getCount() == 0) {
                    show("Error", "Nothing to show");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {

                    buffer.append("Firstname :- " + res.getString(0) + "\n");
                    buffer.append("Lastname :- " + res.getString(1) + "\n");
                    buffer.append("Email :- " + res.getString(2) + "\n");
                    buffer.append("Password :- " + res.getString(3) + "\n");
                    buffer.append("Birthdate :- " + res.getString(4) + "\n");

                }
                show("data", buffer.toString());
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