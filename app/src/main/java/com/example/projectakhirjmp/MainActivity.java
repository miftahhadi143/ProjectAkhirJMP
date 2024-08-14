package com.example.projectakhirjmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnlistdata,btninputdata,btninformasi,btnkeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            btninputdata = findViewById(R.id.buttonInput);
            btnlistdata = findViewById(R.id.buttonList);
            btninformasi = findViewById(R.id.buttonInformasi);
            btnkeluar = findViewById(R.id.buttonKeluar);

                    btnkeluar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, Login.class);
                        }
                    });
    }
}