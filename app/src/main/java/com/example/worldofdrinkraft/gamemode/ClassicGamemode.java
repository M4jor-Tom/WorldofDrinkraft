package com.example.worldofdrinkraft.gamemode;

public class ClassicGamemode extends AbstractGamemode
{
    @Override
    public GamemodeType getGamemodeType()
    {
        return GamemodeType.CLASSIC_TYPE;
    }

    @Override
    protected String getEnglishLabel()
    {
        return "classic";
    }

    @Override
    protected String getFrenchLabel()
    {
        return "classique";
    }
}