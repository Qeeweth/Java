package com.example.secondapp_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {
    TextView textViewInfoName;
    TextView textViewInfoLastName;
    TextView textViewInfoPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        User user = (User) getIntent().getSerializableExtra("user");
        textViewInfoName = findViewById(R.id.textViewInfoName);
        textViewInfoLastName = findViewById(R.id.textViewLastName);
        textViewInfoPhone = findViewById(R.id.textViewInfoName);
        textViewInfoName.setText(user.getUserName());
        textViewInfoLastName.setText(user.getUserLastName());
        textViewInfoPhone.setText(user.getPhone());
    }
}

