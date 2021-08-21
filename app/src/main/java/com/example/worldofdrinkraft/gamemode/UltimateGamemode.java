package com.example.worldofdrinkraft.gamemode;

public class UltimateGamemode extends AbstractGamemode
{
    @Override
    public GamemodeType getGamemodeType()
    {
        return GamemodeType.ULTIMATE_TYPE;
    }

    @Override
    protected String getEnglishLabel()
    {
        return "ultimate";
    }

    @Override
    protected String getFrenchLabel()
    {
        return "ultime";
    }
}