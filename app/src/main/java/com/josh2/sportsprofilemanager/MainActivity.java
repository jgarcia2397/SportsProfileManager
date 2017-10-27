package com.josh2.sportsprofilemanager;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onOpenInGoogleMaps(View view) {
        EditText addressEditText = (EditText) findViewById(R.id.addressEditText);
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + addressEditText.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void onSetAvatar(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_CANCELED) return;

        ImageView avatarImage = (ImageView) findViewById(R.id.avatarImage);
        String drawableName = "ic_logo_00";
        switch(data.getIntExtra("imageID", R.id.questionMark)) {
            case R.id.questionMark:
                drawableName = "ic_logo_00";
                break;
            case R.id.fury:
                drawableName = "ic_logo_01";
                break;
            case R.id.star:
                drawableName = "ic_logo_02";
                break;
            case R.id.blue:
                drawableName = "ic_logo_03";
                break;
            case R.id.barcelona:
                drawableName = "ic_logo_04";
                break;
            case R.id.canada:
                drawableName = "ic_logo_05";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
}
