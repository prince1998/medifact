package com.upin.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
String name,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login();
    }

    public void login()
    {
        final EditText name=findViewById(R.id.nameInput);
        EditText email=findViewById(R.id.emailInput);
        EditText password=findViewById(R.id.passInput);

        Button b=findViewById(R.id.loginButton);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(name.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login success!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
