package com.example.worldofdrinkraft.architecture.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldofdrinkraft.R;
import com.example.worldofdrinkraft.architecture.business.IBusinessContainer;
import com.example.worldofdrinkraft.gamemode.AbstractGamemode;
import com.example.worldofdrinkraft.gamemode.GamemodeFactory;

public class GamemodeSelectionActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemode_selection);

        ListView gamemodeSelectionListView = (ListView)findViewById(R.id.gamemode_selection_listview);

        gamemodeSelectionListView.setAdapter(
                new ArrayAdapter<AbstractGamemode>(
                        GamemodeSelectionActivity.this,
                        R.layout.adapter_gamemode,
                        GamemodeFactory.getAllGamemodes()
                )
        );

        gamemodeSelectionListView.setOnItemClickListener(
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