package com.example.loginscreen_assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        String role = getIntent().getStringExtra("role");
        TextView welcome = findViewById(R.id.welcome_role);
        welcome.setText("Welcome " + role);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText uid = findViewById(R.id.uid);
        EditText password = findViewById(R.id.password);
        Button submit = findViewById(R.id.submit);
        Button back = findViewById(R.id.back_role_selection);
        submit.setOnClickListener(v -> {
            String primaryKey = uid.getText().toString();
            String pass = password.getText().toString();
            if (pass.isEmpty() || primaryKey.isEmpty()) {
                Toast.makeText(this, "All Fields are required", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Login as " + role + " successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
        back.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this,RoleSelectionActivity.class);
            startActivity(intent);
            finish();
        });
    }
}