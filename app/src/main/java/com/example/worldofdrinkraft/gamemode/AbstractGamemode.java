package com.example.worldofdrinkraft.gamemode;

import android.util.Log;

import com.example.worldofdrinkraft.language.LanguageManager;

abstract public class AbstractGamemode
{
    abstract public GamemodeType getGamemodeType();

    abstract protected String getEnglishLabel();
    abstract protected String getFrenchLabel();

    final public Boolean gamemodeTypeIs(GamemodeType gamemodeType)
    {
        return getGamemodeType().equals(gamemodeType);
    }

    final public String getLabel()
    {
        switch(LanguageManager.getInstance().getLanguage())
        {
            case ENGLISH:
                return getEnglishLabel();

            case FRENCH:
                return getFrenchLabel();
        }

        Log.e("Gamemode::getLabel()", LanguageManager.UNSET_LANGUAGE_ERROR_MESSAGE);
        return null;
    }

    @Override
    public String toString()
    {
        return getLabel();
    }
}