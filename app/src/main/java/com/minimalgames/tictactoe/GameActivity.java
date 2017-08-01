package com.minimalgames.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    int player = 1;
    boolean gameActive = true;
    int[] cellState = {0,0,0,0,0,0,0,0,0};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void mark(View view){
        ImageView image = (ImageView) view;
        int cellNum = Integer.parseInt(image.getTag().toString());
        if(cellState[cellNum]==0 && gameActive){
            switch(player){
                case 1: image.setImageResource(R.drawable.circle);
                        player = 2;
                        cellState[cellNum]=1;
                        break;
                case 2: image.setImageResource(R.drawable.cross);
                        player = 1;
                        cellState[cellNum]=2;
                        break;
            }
            checkGameState();
        }
    }

    public void checkGameState() {
        int ctr=0;
        for (int[] pos : winningPositions) {
            if (cellState[pos[0]] == cellState[pos[1]] &&
                    cellState[pos[1]] == cellState[pos[2]] &&
                    cellState[pos[0]] != 0) {
                TextView winnertext = (TextView) findViewById(R.id.WinnerMessage);
                winnertext.setText("Player " + cellState[pos[0]] + " has won!");
                LinearLayout layout = (LinearLayout) findViewById(R.id.gamepopup);
                layout.setVisibility(View.VISIBLE);
                gameActive = false;
                return;
            }
        }
        for(int acq : cellState) {
            if (acq == 0)
                ctr++;
        }
        if(ctr==0){
            TextView winnertext = (TextView) findViewById(R.id.WinnerMessage);
            winnertext.setText("It's a draw!");
            LinearLayout layout = (LinearLayout) findViewById(R.id.gamepopup);
            layout.setVisibility(View.VISIBLE);
        }
    }

    public void play(View v){
        Intent game = new Intent(getApplicationContext(),GameActivity.class);
        GameActivity.this.finish();
        startActivity(game);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
