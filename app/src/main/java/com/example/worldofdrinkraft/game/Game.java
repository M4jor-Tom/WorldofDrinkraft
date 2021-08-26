package com.example.worldofdrinkraft.game;

import com.example.worldofdrinkraft.gamemode.AbstractGamemode;
import com.example.worldofdrinkraft.gamemode.GamemodeFactory;
import com.example.worldofdrinkraft.gamemode.GamemodeType;

public class Game
{
    private static Game _game = null;
    private AbstractGamemode _gamemode;

    public Game(AbstractGamemode gamemode)
    {
        setGamemode(gamemode);
    }

    public Game(GamemodeType gamemodeType)
    {
        setGamemodeByType(gamemodeType);
    }

    public static Game getInstance()
    {
        if(getGamemodeManager() == null)
            setGamemodeManager(
                    new Game(
                            GamemodeType.CLASSIC_TYPE
                    )
            );

        return getGamemodeManager();
    }

    private static void setGamemodeManager(Game game)
    {
        _game = game;
    }

    private static Game getGamemodeManager()
    {
        return _game;
    }

    public void setGamemodeByType(GamemodeType gamemodeType)
    {
        setGamemode(GamemodeFactory.getGamemodeByType(gamemodeType));
    }

    private void setGamemode(AbstractGamemode gamemode)
    {
        _gamemode = gamemode;
    }

    public AbstractGamemode getGamemode()
    {
        return _gamemode;
    }
}