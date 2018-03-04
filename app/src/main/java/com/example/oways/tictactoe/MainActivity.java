package com.example.oways.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Button buSelected;
    public void BuClick(View view) {
         buSelected=(Button) view;

        int cellID=0;
        switch (buSelected.getId()){
            case R.id.bu1:
                cellID=1;
                break;
            case R.id.bu2:
                cellID=2;
                break;
            case R.id.bu3:
                cellID=3;
                break;
            case R.id.bu4:
                cellID=4;
                break;
            case R.id.bu5:
                cellID=5;
                break;
            case R.id.bu6:
                cellID=6;
                break;
            case R.id.bu7:
                cellID=7;
                break;
            case R.id.bu8:
                cellID=8;
                break;
            case R.id.bu9:
                cellID=9;
                break;
        }
        PlayGame(cellID,buSelected);
    }
    int ActivePlayer=1;
    ArrayList<Integer> Player1=new ArrayList<Integer>();
    ArrayList<Integer> Player2=new ArrayList<Integer>();

    void PlayGame(int cellID,Button buSelected){
        buSelected.setBackgroundColor(Color.RED);
        if(ActivePlayer==1){
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.GREEN);
            Player1.add(cellID);
            ActivePlayer=2;

            AutoPlay();
        }
        else if(ActivePlayer==2){
            buSelected.setText("O");
            buSelected.setBackgroundColor(Color.BLUE);
            Player2.add(cellID);
            ActivePlayer=1;
        }
        buSelected.setEnabled(false);
        CheckWinner();

    }
    void CheckWinner(){
        int Winner=-1;
        //row 1
        if(Player1.contains(1)&&Player1.contains(2)&&Player1.contains(3)){
            Winner=1;
        }
        if(Player2.contains(1)&&Player2.contains(2)&&Player2.contains(3)){
            Winner=2;
        }

        //row 2
        if(Player1.contains(4)&&Player1.contains(5)&&Player1.contains(6)){
            Winner=1;
        }
        if(Player2.contains(4)&&Player2.contains(5)&&Player2.contains(6)){
            Winner=2;
        }

        //row 3
        if(Player1.contains(7)&&Player1.contains(8)&&Player1.contains(9)){
            Winner=1;
        }
        if(Player2.contains(7)&&Player2.contains(8)&&Player2.contains(9)){
            Winner=2;
        }

        //col 1
        if(Player1.contains(1)&&Player1.contains(4)&&Player1.contains(7)){
            Winner=1;
        }
        if(Player2.contains(1)&&Player2.contains(4)&&Player2.contains(7)){
            Winner=2;
        }

        //col 2
        if(Player1.contains(2)&&Player1.contains(5)&&Player1.contains(8)){
            Winner=1;
        }
        if(Player2.contains(2)&&Player2.contains(5)&&Player2.contains(8)){
            Winner=2;
        }

        //col 3
        if(Player1.contains(3)&&Player1.contains(6)&&Player1.contains(9)){
            Winner=1;
        }
        if(Player2.contains(3)&&Player2.contains(6)&&Player2.contains(9)){
            Winner=2;
        }

        //dag 1
        if(Player1.contains(1)&&Player1.contains(5)&&Player1.contains(9)){
            Winner=1;
        }
        if(Player2.contains(1)&&Player2.contains(5)&&Player2.contains(9)){
            Winner=2;
        }

        //col 1
        if(Player1.contains(3)&&Player1.contains(5)&&Player1.contains(7)){
            Winner=1;
        }
        if(Player2.contains(3)&&Player2.contains(5)&&Player2.contains(7)){
            Winner=2;
        }
        if(Winner!=-1){
            if(Winner==1){
                Toast.makeText(this, "Winner: Player 1", Toast.LENGTH_SHORT).show();
                buSelected.setEnabled(false);

            }
            if(Winner==2){
                Toast.makeText(this, "Winner: Player 2", Toast.LENGTH_SHORT).show();
            }
        }
    }
    void AutoPlay(){

        ArrayList<Integer> EmptyCells= new ArrayList<Integer>(); // all un selected cells
        //Find empty cells

        for (int cellID=1; cellID<10;cellID++){
            if (!( Player1.contains(cellID) || Player2.contains(cellID))){
                EmptyCells.add(cellID);
            }
        }

        Random r= new Random();
        int  RandIndex=r.nextInt(EmptyCells.size()- 0)+ 0; // if size =3 , select (0,1,2)
        int CellID=EmptyCells.get(RandIndex);

        Button buSelected;
        switch (CellID){

            case 1 :
                buSelected=(Button) findViewById(R.id.bu1);
                break;

            case 2:
                buSelected=(Button) findViewById(R.id.bu2);
                break;

            case 3:
                buSelected=(Button) findViewById(R.id.bu3);
                break;

            case 4:
                buSelected=(Button) findViewById(R.id.bu4);
                break;

            case 5:
                buSelected=(Button) findViewById(R.id.bu5);
                break;

            case 6:
                buSelected=(Button) findViewById(R.id.bu6);
                break;

            case 7:
                buSelected=(Button) findViewById(R.id.bu7);
                break;

            case 8:
                buSelected=(Button) findViewById(R.id.bu8);
                break;

            case 9:
                buSelected=(Button) findViewById(R.id.bu9);
                break;
            default:
                buSelected=(Button) findViewById(R.id.bu1);
                break;

        }
        PlayGame(CellID, buSelected);
    }
}
