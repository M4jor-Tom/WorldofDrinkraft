package com.example.worldofdrinkraft.architecture.presentation;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldofdrinkraft.R;
import com.example.worldofdrinkraft.game.Game;
import com.example.worldofdrinkraft.gamemode.AbstractGamemode;
import com.example.worldofdrinkraft.gamemode.GamemodeFactory;

public class GamemodeSelectionActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemode_selection);

        Spinner gamemodeSelectionSpinner = (Spinner)findViewById(R.id.gamemode_selection_spinner);

        gamemodeSelectionSpinner.setAdapter(
                new ArrayAdapter<AbstractGamemode>(
                        GamemodeSelectionActivity.this,
                        R.layout.adapter_gamemode,
                        GamemodeFactory.getAllGamemodes()
                )
        );
    }
}