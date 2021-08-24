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

        MaterialButton playerListSetupButton = (MaterialButton)findViewById(R.id.main_button_players);
        MaterialButton roleListButton = (MaterialButton)findViewById(R.id.main_button_roles);

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
    }
}