package com.example.worldofdrinkraft.architecture.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldofdrinkraft.R;
import com.example.worldofdrinkraft.architecture.business.IBusinessContainer;
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

        gamemodeSelectionSpinner.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        IBusinessContainer.getInstance().setGamemodeType(
                                GamemodeFactory.getAllGamemodes().get(position).getGamemodeType()
                        );
                    }
                }
        );
    }
}