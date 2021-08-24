package com.example.worldofdrinkraft.gamemode;

import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GamemodeFactory
{
    private static List<AbstractGamemode> _gamemodeList;

    @Nullable
    public static AbstractGamemode getGamemodeByType(GamemodeType gamemodeType)
    {
        for(AbstractGamemode gamemode: getAllGamemodes())
            if(gamemode.gamemodeTypeIs(gamemodeType))
                return gamemode;

        Log.e("getGamemodeByType()", "Unset Gamemode");
        return null;
    }

    public static List<AbstractGamemode> getAllGamemodes()
    {
        if(getGamemodeList() == null)
        {
            setGamemodeList(new ArrayList<>());

            addGamemodeToList(new ClassicGamemode());
            addGamemodeToList(new LimitlessGamemode());
            addGamemodeToList(new UltimateGamemode());
        }

        return getGamemodeList();
    }

    private static void setGamemodeList(List<AbstractGamemode> gamemodeList)
    {
        _gamemodeList = gamemodeList;
    }

    private static List<AbstractGamemode> getGamemodeList()
    {
        return _gamemodeList;
    }

    private static void addGamemodeToList(AbstractGamemode gamemode)
    {
        getGamemodeList().add(gamemode);
    }
}