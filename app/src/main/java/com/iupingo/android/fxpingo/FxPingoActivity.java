package com.iupingo.android.fxpingo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class FxPingoActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fx_pingo);

        String[] friends = getResources().getStringArray(R.array.friend_list);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, friends);

        ListView listView = (ListView) findViewById(R.id.lvFriends);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        Button pingButton = (Button) findViewById(R.id.btnPingo);
        pingButton.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fx_pingo, menu);
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

    @Override
    public void onClick(View v) {
        Log.i("Send SMS", "");
        String phoneNo = "+84983414146";//txtphoneNo.getText().toString();
        String message = "test message sent!";//txtMessage.getText().toString();

//        try {
//            SmsManager smsManager = SmsManager.getDefault();
//            smsManager.sendTextMessage(phoneNo, null, message, null, null);
//            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
//        }
//
//        catch (Exception e) {
//            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
//            e.printStackTrace();
//        }
//        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
//
//        smsIntent.setData(Uri.parse("smsto:"));
//        smsIntent.setType("vnd.android-dir/mms-sms");
//        smsIntent.putExtra("address"  , new String ("+84983414146"));
//        smsIntent.putExtra("sms_body"  , "Test ");
//
//        try {
//            startActivity(smsIntent);
//            finish();
//            Log.i("Finished sending SMS...", "");
//        }
//        catch (android.content.ActivityNotFoundException ex) {
//            Toast.makeText(this,
//                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
//        }
    }
}
