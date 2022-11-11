package io.testproject.demo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtName;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Acquire references to UI widgets
        this.txtName = (EditText) findViewById(R.id.name);
        this.txtPassword = (EditText) findViewById(R.id.password);

        // Submit when password provided
        txtPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    performLogin(null);
                    return true;
                }
                return false;
            }});
    }

    public void performLogin(View view) {
        boolean hasErrors = false;

        if (txtName.getText().length() == 0) {
            txtName.setError("Please provide your name");
            hasErrors = true;
        } else {
            txtName.setError(null);
        }

        if (!txtPassword.getText().toString().equals("12345")) {
            txtPassword.setError("This password is incorrect");
            hasErrors = true;
        } else {
            txtPassword.setError(null);
        }

        if (!hasErrors) {
            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            intent.putExtra("FULL_NAME", txtName.getText().toString());
            startActivity(intent);
        }
    }


}
