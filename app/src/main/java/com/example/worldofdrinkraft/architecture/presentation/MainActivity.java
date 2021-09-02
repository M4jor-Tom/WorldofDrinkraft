package com.example.worldofdrinkraft.architecture.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.worldofdrinkraft.R;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton gamemodeSelectionButton = (MaterialButton)findViewById(R.id.main_button_gamemode_selection);
        MaterialButton playerListSetupButton = (MaterialButton)findViewById(R.id.main_button_players);
        MaterialButton roleListButton = (MaterialButton)findViewById(R.id.main_button_roles);
        MaterialButton startGameButton = (MaterialButton)findViewById(R.id.main_button_start_game);

        gamemodeSelectionButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent gamemodeSelectionIntent = new Intent(
                                MainActivity.this,
                                GamemodeSelectionActivity.class
                        );

                        startActivity(gamemodeSelectionIntent);
                    }
                }
        );

        playerListSetupButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent playersSetupIntent = new Intent(
                                MainActivity.this,
                                PlayersSetupActivity.class
                        );

                        startActivity(playersSetupIntent);
                    }
                }
        );

        roleListButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent roleListIntent = new Intent(
                                MainActivity.this,
                                RoleListActivity.class
                        );

                        startActivity(roleListIntent);
                    }
                }
        );

        startGameButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent startGameIntent = new Intent(
                                MainActivity.this,
                                EventsSwipeActivity.class
                        );

                        startActivity(startGameIntent);
                    }
                }
        );
    }
}