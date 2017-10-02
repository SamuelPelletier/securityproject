package com.info.pellesam.securityproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by pellesam on 02/10/2017.
 */

public class DisplayItemActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        Button button = (Button) findViewById(R.id.button);
        button.setText("Hello");
    }
}
