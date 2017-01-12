package com.example.pit.piotrjedrzejczak;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    private boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPasswordValid(String password) {
        return password.matches("^(?=.{8,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    public void checkLogin(@SuppressWarnings("UnusedParameters") View view) {
        EditText editText = (EditText) findViewById(R.id.email_message);
        String email = editText.getText().toString();
        editText = (EditText) findViewById(R.id.password_message);
        String password = editText.getText().toString();

        if (isPasswordValid(password) && isEmailValid(email)) {

            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPref.edit();

            editor.putBoolean("saveLogin", true);
            editor.apply();

            Intent intent = new Intent(LoginScreen.this, MainScreen.class);
            finish();
            startActivity(intent);
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(LoginScreen.this).create();
            alertDialog.setTitle("Warning");
            alertDialog.setMessage("You have entered wrong information");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }
}
