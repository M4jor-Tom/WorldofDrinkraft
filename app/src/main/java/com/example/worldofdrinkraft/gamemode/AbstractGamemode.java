package com.example.worldofdrinkraft.gamemode;

import android.util.Log;

import com.example.worldofdrinkraft.language.Language;

abstract public class AbstractGamemode
{
    abstract public GamemodeType getGamemodeType();

    abstract protected String getEnglishLabel();
    abstract protected String getFrenchLabel();

    final public String getLabel()
    {
        switch(Language.getInstance().getLanguageType())
        {
            case ENGLISH:
                return getEnglishLabel();

            case FRENCH:
                return getFrenchLabel();
        }

        Log.e("Gamemode::getLabel()", Language.UNSET_LANGUAGE_ERROR_MESSAGE);
        return null;
    }
}