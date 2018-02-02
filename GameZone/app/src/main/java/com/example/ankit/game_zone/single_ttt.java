package com.example.ankit.game_zone;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;


public class single_ttt extends AppCompatActivity {
    int source[] = {R.drawable.o, R.drawable.x ,0};
    ArrayList<Integer> target = new ArrayList<Integer>();
    int target_checker[]={R.id.block_01,R.id.block_02,R.id.block_03,R.id.block_04,R.id.block_05,R.id.block_06,R.id.block_07,R.id.block_08,R.id.block_09};
    char record[]={'a','a','a','a','a','a','a','a','a'};
    int choice,win = 1;
    int  chance = 0;
    int Score1=0;
    int Score2=0;
    String cont;
    int stopper=0;
    ImageView turn;
    TextView score_1;
    TextView score_2;
    TextView status;
    ImageButton hidden;
    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_ttt);

        Bundle bundle = getIntent().getExtras();
        choice = bundle.getInt("mode");
        if (choice == 2) {
            TextView t1 = (TextView) findViewById(R.id.score_name_1);
            t1.setText("Player 1");
            TextView t2 = (TextView) findViewById(R.id.score_name_2);
            t2.setText("Player 2");
        }
    }


    public int wining_logic()
    {
        if((record[0]=='x'&&record[1]=='x'&& record[2]=='x')||(record[0]=='o'&&record[1]=='o'&& record[2]=='o'))
        {
            return 1;
        }
        else if((record[3]=='x'&&record[4]=='x'&& record[5]=='x')||(record[3]=='o'&&record[4]=='o'&& record[5]=='o'))
        {
            return 1;
        }
        else if((record[6]=='x'&&record[7]=='x'&& record[8]=='x')||(record[6]=='o'&&record[7]=='o'&& record[8]=='o'))
        {
            return 1;
        }
        else if((record[0]=='x'&&record[3]=='x'&& record[6]=='x')||(record[0]=='o'&&record[3]=='o'&& record[6]=='o'))
        {
            return 1;
        }
        else if((record[1]=='x'&&record[4]=='x'&& record[7]=='x')||(record[1]=='o'&&record[4]=='o'&& record[7]=='o'))
        {
            return 1;
        }
        else if((record[2]=='x'&&record[5]=='x'&& record[8]=='x')||(record[2]=='o'&&record[5]=='o'&& record[8]=='o'))
        {
            return 1;
        }
        else if((record[0]=='x'&&record[4]=='x'&& record[8]=='x')||(record[0]=='o'&&record[4]=='o'&& record[8]=='o'))
        {
            return 1;        }
        else if((record[2]=='x'&&record[4]=='x'&& record[6]=='x')||(record[2]=='o'&&record[4]=='o'&& record[6]=='o')) {
            return 1;
        }
        else
        {
            return  0;
        }
    }
    public void updater(int id_play)
    {
        for(int i=0;i<9;i++)
        {
            if(id_play==target_checker[i])
            {
                if(chance==0)
                {
                    record[i]='x';
                }
                else
                {
                    record[i]='o';
                }
            }
        }
    }
    public void appear_button()
    {
        hidden = (ImageButton)findViewById(R.id.restart);
        hidden.setVisibility(View.VISIBLE);
    }

    public void play(View v)
    {
        int a = v.getId();
        if (target.contains(a))
        {
             chance++;
             chance--;
        }
        else
        {
            ImageView turn = (ImageView)findViewById(R.id.turn);
            ImageButton btn = (ImageButton) findViewById(a);
            TextView score_1 = (TextView)findViewById(R.id.pl1_score);
            TextView score_2 = (TextView)findViewById(R.id.pl2_score);
            TextView status = (TextView)findViewById(R.id.status);
            if (chance == 0 && stopper==0)
            {
                updater(a);
                btn.setImageResource(source[1]);
                chance++;
                target.add(a);

                if(wining_logic()==1)
                {
                    Score1=Score1+wining_logic();
                    stopper=1;
                    appear_button();
                    if(choice==2)
                    {
                        status.setText("Player 1 Win !");
                    }
                    else
                    {
                        status.setText("You Win !");
                    }
                }
                turn.setImageResource(source[0]);
                cont = Integer.toString(Score1);
                score_1.setText(cont);
                DrawChecker();
                if(choice!=2 && stopper==0)
                {
                    int n=rand.nextInt(9);
                    status.setText("");
                    a=target_checker[n];
                    while(target.contains(a) && target.size()<9)
                    {
                        n=rand.nextInt(9);
                        a=target_checker[n];

                    }
                    ImageButton btn1 = (ImageButton)findViewById(a);
                    updater(a);
                    btn1.setImageResource(source[0]);
                    chance--;
                    target.add(a);
                    if(wining_logic()==1)
                    {
                        Score2=Score2+wining_logic();
                        stopper=1;
                        status.setText("Computer Win !");
                        appear_button();
                    }
                    turn.setImageResource(source[1]);
                    cont = Integer.toString(Score2);
                    score_2.setText(cont);
                    DrawChecker();
                }
            }
            else if(stopper==0)
                {
                updater(a);
                btn.setImageResource(source[0]);
                chance--;
                target.add(a);
                if(wining_logic()==1)
                {
                    Score2 = Score2 + wining_logic();
                    stopper=1;
                    appear_button();
                    status.setText("Player 2 Win !");
                }
                turn.setImageResource(source[1]);
                cont = Integer.toString(Score2);
                score_2.setText(cont);
                DrawChecker();
                }
            }
    }
    public void restart(View v)
    {   ImageView turn = (ImageView)findViewById(R.id.turn);
        status = (TextView)findViewById(R.id.status);
        status.setText("Play !");
        for(int i=0;i<target.size();i++)
        {
            ImageButton img_c =(ImageButton)findViewById(target.get(i));
            img_c.setImageResource(source[2]);
        }
        target.clear();
        for(int i=0;i<9;i++)
        {
            record[i]='a';
        }
        turn.setImageResource(source[1]);
        stopper=0;
        chance=0;
        ImageButton image = (ImageButton)findViewById(R.id.restart);
        image.setVisibility(View.GONE);
    }
    public void DrawChecker()
    {   int t=0;
    TextView status=(TextView)findViewById(R.id.status);
        for( int i=0;i<9;i++)
        {
            if(record[i]=='a')
            {
                t=1;
            }
        }
        if(t==0&&wining_logic()==0)
        {
            status.setText("*****Draw*****");
            appear_button();
        }
    }
}