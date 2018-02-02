package com.example.ankit.game_zone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void to_ttt_menu(View v)
    {
        Intent i = new Intent(this,tttmenu.class);
        startActivity(i);
    }
    public void to_sps(View v)
    {
        Intent i = new Intent(this,sps_game.class);
        startActivity(i);
    }
}
