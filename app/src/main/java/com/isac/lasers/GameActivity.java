package com.isac.lasers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        SetPlayerWhenGameStart();

    }



   public void CheckPlayerLasers() {
       ImageView player = (ImageView) findViewById(R.id.Player);
       ImageView laser = (ImageView) findViewById(R.id.Laser);
       if(player.getX() == laser.getX())
       {
           Intent intent = new Intent(this, GameActivity.class);
           startActivity(intent);
       }
   }

    public void LaserX() {
        ImageView laser = (ImageView) findViewById(R.id.Laser);
        laser.setX(400);
    }
    public void SetPlayerWhenGameStart() {
        ImageView player = (ImageView) findViewById(R.id.Player);
        player.setX(400);
    }

    public void PrintXOfPlayer(View view) {

        ImageView player = (ImageView) findViewById(R.id.Player);
        System.out.println(player.getX());
    }

    public void RigthMove(View view) {

        ImageView player = (ImageView) findViewById(R.id.Player);
        if (player.getX() != 650) {
            player.setX(player.getX() + 250);
        }

    }

    public void LeftMove(View view) {

        ImageView player = (ImageView) findViewById(R.id.Player);
        if (player.getX() != 150) {
            player.setX(player.getX() - 250);
        }
    }
}