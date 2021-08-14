package com.example.worldofdrinkraft.player;

import android.util.Log;

import com.example.worldofdrinkraft.language.Language;

public class ExistentPlayerException extends Exception
{
    @Override
    public String getMessage()
    {
        switch(Language.getInstance().getLanguageType())
        {
            case ENGLISH:
                return "Player already exist";

            case FRENCH:
                return "Le joueur existe déjà";
        }

        Log.e("ExistentPlayerException", Language.UNSET_LANGUAGE_ERROR_MESSAGE);
        return null;
    }
}