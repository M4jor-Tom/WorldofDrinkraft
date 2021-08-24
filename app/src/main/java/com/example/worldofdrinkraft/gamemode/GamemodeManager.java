package com.example.worldofdrinkraft.gamemode;

public class GamemodeManager
{
    private static GamemodeManager _gamemodeManager = null;
    private AbstractGamemode _gamemode;

    public GamemodeManager(AbstractGamemode gamemode)
    {
        setGamemode(gamemode);
    }

    public static GamemodeManager getInstance()
    {
        if(getGamemodeManager() == null)
            setGamemodeManager(new GamemodeManager(null));

        return getGamemodeManager();
    }

    private static void setGamemodeManager(GamemodeManager gamemodeManager)
    {
        _gamemodeManager = gamemodeManager;
    }

    private static GamemodeManager getGamemodeManager()
    {
        return _gamemodeManager;
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