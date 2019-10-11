package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.market.classes.connectionDB;

public class Signup extends AppCompatActivity {

    EditText EMAIL;
    EditText PASSWORD;
    EditText FIRSTNAME;
    EditText LASTNAME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Call id's
        EMAIL=findViewById(R.id.idEmail);
        //FIRSTNAME=findViewById(R.id.IdFname)
        //LASTNAME=findViewById(R.id.IdLname)
        //PASSWORD=findViewById(R.id.IdPasswd   )

    }

    public void Register(View view){
        //1. create Database manager
        connectionDB manager = new connectionDB(this, "data", null, 1);
        //2. Let database read/write
        SQLiteDatabase market = manager.getWritableDatabase();
        //3. get values/text/numbers¿
        String Email = EMAIL.getText().toString();
        String Passwd = "1234";
        String Lname = "McDonald";
        String Fname = "Peter";

        //***validate: Do not repeat email
        //call validateEmail function/method
        //boolean status = validateEmail();

        //4. create content values
        if(!Email.isEmpty() && !Passwd.isEmpty()&&
                !Lname.isEmpty() && !Fname.isEmpty() ) {

            Cursor row = market.rawQuery("SELECT email" +
                    "FROM users WHERE email = "+Email, null);

            if (!row.moveToFirst()){
                ContentValues DATA = new ContentValues();
                //5. create data pack
                DATA.put("email",Email);
                DATA.put("password",Passwd);
                DATA.put("firstname",Fname);
                DATA.put("lastname",Lname);
                //6. save data into market database
                market.insert("users", null,DATA);
                Toast.makeText(this, "The User has been created !!!", Toast.LENGTH_SHORT).show();
                //7.close connection
                market.close();}
            }else{
                Toast.makeText(this, "The user already exists", Toast.LENGTH_SHORT).show();
            }
          }
        /*
        public boolean validateEmail(View view){
        connectionDB manager = new connectionDB(this, "data", null, 1);
        SQLiteDatabase market = manager.getWritableDatabase();
        String Email=EMAIL.getText().toString();

        Cursor row = market.rawQuery("SELECT email" +
                "FROM users WHERE email = "+Email, null);
        if (row.moveToFirst()){
            return true;
        }else{
            return false;
        }
        market.close
    }*/


}
