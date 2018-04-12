package com.upin.firebase;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
{
public String name,email,password;
public ProgressDialog loader;
public FirebaseAuth authenticator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loader=new ProgressDialog(this);

        authenticator=FirebaseAuth.getInstance();

        login();
    }

    public void login()
    {
        final EditText name=findViewById(R.id.nameInput);
        final EditText email=findViewById(R.id.emailInput);
        final EditText password=findViewById(R.id.passInput);

        Button b=findViewById(R.id.loginButton);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(name.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    loader.setMessage("Registering "+name+"...");
                    loader.show();

                    authenticator.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString());

                }
            }
        });
    }
}