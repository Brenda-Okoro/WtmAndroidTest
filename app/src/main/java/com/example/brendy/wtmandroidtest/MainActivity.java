package com.example.brendy.wtmandroidtest;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameField;
    EditText emailField;
    Button doneBtn;
    TextView replyText;
    TextInputLayout name;
    TextInputLayout email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.name);
        emailField = findViewById(R.id.email);
        doneBtn = findViewById(R.id.btn_done);
        replyText = findViewById(R.id.show);
        name = findViewById(R.id.wrapper_name);
        email = findViewById(R.id.wrapper_email);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                if (getCurrentFocus() != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    nameField.setVisibility(View.GONE);
                    name.setVisibility(View.GONE);
                    email.setVisibility(View.GONE);
                    doneBtn.setVisibility(View.GONE);
                    replyText.setVisibility(View.VISIBLE);
                    String ans = "Your Name is " + nameField.getText().toString().trim() + " and your email is " + emailField.getText().toString().trim();
                    replyText.setText(ans);
                }
            }
        });
    }
}
