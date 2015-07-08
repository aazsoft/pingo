package com.iupingo.android.fxpingo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = (Button) findViewById(R.id.btnSignIn);
        btnLogin.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            onClickSignIn(v);
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickSignIn(View view) {
        // validation
        EditText userNameText = (EditText) findViewById(R.id.txtUsername);
        String userNameVal = userNameText.getText().toString();
        if (userNameVal == null || userNameVal.isEmpty()) {
            Toast.makeText(this, "Username must not be blank!", Toast.LENGTH_SHORT).show();
            return;
        }
        EditText passwordText = (EditText) findViewById(R.id.txtPassword);
        String passwordVal = passwordText.getText().toString();
        if (passwordVal == null || passwordVal.isEmpty()) {
            Toast.makeText(this, "Password must not be blank!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!"truong".equals(userNameVal) || !"123".equals(passwordVal)) {
            Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Login succeeded!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(view.getContext(), FxPingoActivity.class);
        startActivity(intent);
    }
}
