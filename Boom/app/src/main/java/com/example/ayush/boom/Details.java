package com.example.ayush.boom;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Details extends AppCompatActivity {
    Databasehelp mydb;
    Button btn1, btn2;
    EditText et1, et2, et3, et4, et5, et6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mydb = new Databasehelp(this);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        et4=(EditText)findViewById(R.id.editText4);
        et5=(EditText)findViewById(R.id.editText5);
        et6=(EditText)findViewById(R.id.editText6);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);

        insert();
        view();
    }
    public void insert()
    {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted = mydb.insertdate(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString(),et5.getText().toString(), et6.getText().toString());
                if (isinserted = true)
                    Toast.makeText(Details.this, "inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Details.this, " Not inserted", Toast.LENGTH_LONG).show();
            }
        });


    }


    public  void view()
    {


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res= mydb.getalldata();
                if(res.getCount()==0){
                    show("Error","Nothing to show");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {

                    buffer.append("Name :- " + res.getString(0) + "\n");
                    buffer.append("Age :- " + res.getString(1) + "\n");
                    buffer.append("Number :- " + res.getString(2) + "\n");
                    buffer.append("Gender :- " + res.getString(3) + "\n");
                    buffer.append("Location :- " + res.getString(4) + "\n");
                    buffer.append("Address :- " + res.getString(5) + "\n");

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



    }
}
