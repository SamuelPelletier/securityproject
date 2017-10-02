package com.info.pellesam.securityproject.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.info.pellesam.securityproject.R;

/**
 * Created by pellesam on 02/10/2017.
 */

public class DisplayItemActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);
        Button button = (Button) findViewById(R.id.button_return);
    }
}
