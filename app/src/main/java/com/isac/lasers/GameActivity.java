package com.isac.lasers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private int[] xPositions = {150, 400, 650};
    private ImageView player;
    private ImageView laser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        player = findViewById(R.id.Player);
        laser = findViewById(R.id.Laser);

        SetPlayerWhenGameStart();
        generateLaserAtRandomPosition();
    }

    public void CheckPlayerLasers() {
        if (player.getX() == laser.getX()) {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }
    }

    public void generateLaserAtRandomPosition() {
        Random random = new Random();
        int randomIndex = random.nextInt(xPositions.length);
        int randomX = xPositions[randomIndex];

        laser.setX(randomX);
        laser.setVisibility(View.VISIBLE);

        CheckPlayerLasers();
    }

    public void SetPlayerWhenGameStart() {
        player.setX(400);
    }

    public void PrintXOfPlayer(View view) {
        System.out.println(player.getX());
    }

    public void RightMove(View view) {
        if (player.getX() != 650) {
            player.setX(player.getX() + 250);
        }
        CheckPlayerLasers();  // Check for collision after moving
    }

    public void LeftMove(View view) {
        if (player.getX() != 150) {
            player.setX(player.getX() - 250);
        }
        CheckPlayerLasers();  // Check for collision after moving
    }
}
