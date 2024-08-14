package com.example.projectakhirjmp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {
    Button btnregister;
    EditText eduser, edpass, edconfirmPass;
    DatabaseHelper dblogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnregister = findViewById(R.id.buttonRegister);
        eduser = findViewById(R.id.editTextUsername);
        edpass = findViewById(R.id.editTextPassword);
        dblogin = new DatabaseHelper(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = eduser.getText().toString();
                String password = edpass.getText().toString();

                Boolean checkUser = dblogin.checkUser(user);
                if (checkUser==false) {
                    Boolean insert = dblogin.insertUser(user, password);
                    if (insert==true) {
                        Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Register.this, "Username already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}