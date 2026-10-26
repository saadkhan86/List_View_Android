package com.example.loginscreen_assignment2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class RoleSelectionActivity extends AppCompatActivity {
    private  ListView role_tag;
    private ArrayList<String> role_items;
    private String selected_role;
    private Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_role_selection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        role_tag = findViewById(R.id.role_list_tag);
        btn_next = findViewById(R.id.btn_next);
        role_items = new ArrayList<>();
        role_items.add("Admin");
        role_items.add("Faculty");
        role_items.add("Management");
        role_items.add("Accountant");
        role_items.add("Student");
        role_items.add("Employee");
        ArrayAdapter<String> role_adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,role_items);
        role_tag.setAdapter(role_adapter);

        role_tag.setOnItemClickListener(
                (parent, view, position, id) -> {
                    for (int i = 0; i < parent.getChildCount(); i++) {
                        parent.getChildAt(i)
                                .setBackgroundColor(android.graphics.Color.TRANSPARENT);
                        android.widget.TextView text =
                                parent.getChildAt(i)
                                        .findViewById(android.R.id.text1);
                        if (text != null) {
                            text.setTextColor(
                                    Color.WHITE
                            );
                        }
                    }
                    android.widget.TextView selectedText =
                            view.findViewById(android.R.id.text1);
                    if (selectedText != null) {
                        selectedText.setTextColor(
                                android.graphics.Color.parseColor("#6750A4")
                        );
                    }
                    selected_role = role_items.get(position);
                }
        );
        btn_next.setOnClickListener(v->{
            if(selected_role == null || selected_role.isEmpty()){
                android.widget.Toast.makeText(this,"Please select a role",android.widget.Toast.LENGTH_SHORT).show();
                return;
            }
            android.widget.Toast.makeText(this," Role " + selected_role + " Selected ",android.widget.Toast.LENGTH_SHORT).show();
            String role = selected_role;
            Intent intent = new Intent(RoleSelectionActivity.this, MainActivity.class);
            intent.putExtra("role",role);
            startActivity(intent);
            finish();
        });

    }
}