package com.minimalgames.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void launch(View v){
        Intent game = new Intent(getApplicationContext(),GameActivity.class);
        startActivity(game);
    }

    public void closeApp(View view){
        MainActivity.this.finish();
        System.exit(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
