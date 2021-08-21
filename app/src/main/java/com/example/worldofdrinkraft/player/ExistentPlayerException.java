package com.example.worldofdrinkraft.player;

import android.util.Log;

import com.example.worldofdrinkraft.language.LanguageManager;

public class ExistentPlayerException extends Exception
{
    @Override
    public String getMessage()
    {
        switch(LanguageManager.getInstance().getLanguageType())
        {
            case ENGLISH:
                return "Player already exists";

            case FRENCH:
                return "Le joueur existe déjà";
        }

        Log.e("ExistentPlayerException", LanguageManager.UNSET_LANGUAGE_ERROR_MESSAGE);
        return null;
    }
}