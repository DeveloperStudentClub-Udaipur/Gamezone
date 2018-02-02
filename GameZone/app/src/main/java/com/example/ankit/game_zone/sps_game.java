package com.example.ankit.game_zone;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;


public class sps_game extends AppCompatActivity {
    ImageView i1 , i2 ;
    ImageButton stone,paper,scissor,restart;
    TextView score1,score2,status;
    int links[]={R.drawable.stone_stable,R.drawable.paper_stable,R.drawable.scissor_stable,R.drawable.restart_sps,R.drawable.black};
    ArrayList<String> images = new ArrayList<String>();
    Random rand = new Random();
    int Score_player;
    int Score_comp;
    int set1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sps_game);
      i1 = (ImageView)findViewById(R.id.player);
      i2 = (ImageView)findViewById(R.id.computer);
        stone = (ImageButton) findViewById(R.id.stone_player);
        paper = (ImageButton)findViewById(R.id.paper_player);
        scissor = (ImageButton)findViewById(R.id.scissor_player);
      score1 = (TextView)findViewById(R.id.player_score);
        score2 = (TextView)findViewById(R.id.comp_score);
        status = (TextView)findViewById(R.id.status);
        restart = (ImageButton)findViewById(R.id.restart_game);
        Score_comp=0;
        Score_player=0;
        stone.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                if(set1==0)
                {
                    set1=1;
                i1.setImageResource(links[0]);
                int n1 = rand.nextInt(3);
                int n2=0;
                i2.setImageResource(links[n1]);
               if(n1==n2)
               {
                   status.setText("DRAW");
               }
               else if(n1==1)
               {
                   status.setText("YOU LOSE :(");
                   Score_comp++;
               }
               else if(n1==2)
               {
                   status.setText("YOU WIN !!");
                   Score_player++;
               }
               restart.setImageResource(links[3]);
               String cont = Integer.toString(Score_player);
               score1.setText(cont);
               cont = Integer.toString(Score_comp);
               score2.setText(cont);
            }

            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set1==0) {

                    set1=1;
                    i1.setImageResource(links[1]);
                    int n1 = rand.nextInt(3);
                    int n2 = 1;
                    i2.setImageResource(links[n1]);
                    if (n1 == n2) {
                        status.setText("DRAW");
                    } else if (n1 == 2) {
                        status.setText("YOU LOSE :(");
                        Score_comp++;
                    } else if (n1 == 0) {
                        status.setText("YOU WIN !!");
                        Score_player++;
                    }
                    restart.setImageResource(links[3]);
                    String cont = Integer.toString(Score_player);
                    score1.setText(cont);
                    cont = Integer.toString(Score_comp);
                    score2.setText(cont);
                }
            }
        });

        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (set1 == 0) {
                    set1=1;
                    i1.setImageResource(links[2]);
                    int n1 = rand.nextInt(3);
                    int n2 = 2;
                    i2.setImageResource(links[n1]);
                    if (n1 == n2) {
                        status.setText("DRAW");
                    } else if (n1 == 0) {
                        status.setText("YOU LOSE :(");
                        Score_comp++;
                    } else if (n1 == 1) {
                        status.setText("YOU WIN !!");
                        Score_player++;
                    }

                    restart.setImageResource(links[3]);
                    String cont = Integer.toString(Score_player);
                    score1.setText(cont);
                    cont = Integer.toString(Score_comp);
                    score2.setText(cont);
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i1.setImageResource(links[4]);
                i2.setImageResource(links[4]);
                restart.setImageResource(links[4]);
                set1=0;
                status.setText("Play");
            }
        });


    }


}
