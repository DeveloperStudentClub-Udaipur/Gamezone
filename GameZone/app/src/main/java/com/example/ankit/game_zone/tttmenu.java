package com.example.ankit.game_zone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class tttmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tttmenu);

    }
    public void mode_s(View v) {
        Intent i = new Intent(this, single_ttt.class);
        Bundle bundle = new Bundle();
        bundle.putInt("mode",1);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void mode_m(View v) {
        Intent i = new Intent(this, single_ttt.class);
        Bundle bundle = new Bundle();
        bundle.putInt("mode",2);
        i.putExtras(bundle);
        startActivity(i);
    }

}
