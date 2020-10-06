package com.example.tableviewintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Username,Password;
    Button login;
    CheckBox checkBox;
    String holdUsername,holdPassword,holdCheckbox;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username=(EditText)findViewById(R.id.givenUsername);
        Password=(EditText)findViewById(R.id.givenPassword);
        login=(Button)findViewById(R.id.login);
        checkBox=(CheckBox)findViewById(R.id.theCheckbox);


        holdCheckbox=checkBox.getText().toString();


        sharedPreferences=getSharedPreferences("loginInformation", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

        checkSharedPrefs();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    editor.putString("keyCheckbox","True");
                    editor.commit();

                    holdUsername=Username.getText().toString();
                    editor.putString("keyUsername",holdUsername);
                    editor.commit();

                    holdPassword=Password.getText().toString();
                    editor.putString("keyPassword",holdPassword);
                    editor.commit();

                }
                else{
                    editor.putString("keyCheckbox","False");
                    editor.commit();

                    holdUsername=Username.getText().toString();
                    editor.putString("keyUsername"," ");
                    editor.commit();

                    holdPassword=Password.getText().toString();
                    editor.putString("keyPassword"," ");
                    editor.commit();

                }
            }
        });

    }

    public void checkSharedPrefs(){

        String username=sharedPreferences.getString("keyUsername","");
        String password=sharedPreferences.getString("keyPassword","");
        String checkbox=sharedPreferences.getString("keyCheckbox","False");

        Username.setText(username);
        Password.setText(password);

        if (checkbox.equals("True")){
            checkBox.setChecked(true);
        }
        else{
            checkBox.setChecked(false);
        }
    }


}