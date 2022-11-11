package io.testproject.demo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity {

    private TextView lblGreetings;
    private EditText txtCountry;
    private EditText txtAddress;
    private EditText txtEmail;
    private EditText txtPhone;
    private TextView txtSaved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Acquire references to UI widgets
        this.lblGreetings = (TextView) findViewById(R.id.greetings);
        this.txtCountry = (EditText) findViewById(R.id.country);
        this.txtAddress = (EditText) findViewById(R.id.address);
        this.txtEmail = (EditText) findViewById(R.id.email);
        this.txtPhone = (EditText) findViewById(R.id.phone);
        this.txtSaved = (TextView) findViewById(R.id.saved);

        // Say Hi
        String greetings = "Hello " + getIntent().getStringExtra("FULL_NAME");
        SpannableString spanString = new SpannableString(greetings);
        spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
        lblGreetings.setText(spanString);

    }

    public void performLogout(View view) {
        startActivity(new Intent(ProfileActivity.this,MainActivity.class));
    }

    public void performSave(View view) {

        txtSaved.setVisibility(View.GONE);
        boolean hasErrors = false;

        if (txtCountry.getText().length() == 0) {
            txtCountry.setError("Please enter your country");
            hasErrors = true;
        } else {
            txtCountry.setError(null);
        }

        if (txtAddress.getText().length() == 0) {
            txtAddress.setError("Please enter your address");
            hasErrors = true;
        } else {
            txtAddress.setError(null);
        }

        if (txtEmail.getText().length() == 0) {
            txtEmail.setError("Please enter your email");
            hasErrors = true;
        } else {
            txtEmail.setError(null);
        }

        if (txtPhone.getText().length() == 0) {
            txtPhone.setError("Please enter your phone number");
            hasErrors = true;
        } else {
            txtPhone.setError(null);
        }

        if (!hasErrors) {
            txtSaved.setVisibility(View.VISIBLE);
        }
    }
}
