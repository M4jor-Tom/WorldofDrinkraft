package com.example.worldofdrinkraft.gamemode;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GamemodeFactory
{
    public static AbstractGamemode getGamemodeByType(GamemodeType gamemodeType)
    {
        switch(gamemodeType)
        {
            case CLASSIC_TYPE:
                return new ClassicGamemode();

            case ULTIMATE_TYPE:
                return new UltimateGamemode();

            case LIMITLESS_TYPE:
                return new LimitlessGamemode();
        }

        Log.e("getGamemodeByType()", "Unset Gamemode");
        return null;
    }

    public static List<AbstractGamemode> getAllGamemodes()
    {
        List<AbstractGamemode> gamemodeList = new ArrayList<>();

        for(GamemodeType gamemodeType: GamemodeType.values())
            gamemodeList.add(GamemodeFactory.getGamemodeByType(gamemodeType));

        return gamemodeList;
    }
}