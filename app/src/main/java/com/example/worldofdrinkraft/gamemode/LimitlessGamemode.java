package com.example.worldofdrinkraft.gamemode;

public class LimitlessGamemode extends AbstractGamemode
{
    @Override
    public GamemodeType getGamemodeType()
    {
        return GamemodeType.LIMITLESS_TYPE;
    }

    @Override
    protected String getEnglishLabel()
    {
        return "limitless";
    }

    @Override
    protected String getFrenchLabel()
    {
        return "sans limites";
    }
}