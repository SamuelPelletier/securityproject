package com.info.pellesam.securityproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.info.pellesam.securityproject.R;

/**
 * Created by pellesam on 02/10/2017.
 */

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);
    }

    @Override
    public void onClick(View v) {

    }
}
