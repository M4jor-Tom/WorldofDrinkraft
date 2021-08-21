package com.example.worldofdrinkraft.player;

import android.util.Log;

import com.example.worldofdrinkraft.language.LanguageManager;

public class NonexistentPlayerException extends Exception
{
    @Override
    public String getMessage()
    {
        switch(LanguageManager.getInstance().getLanguageType())
        {
            case ENGLISH:
                return "Player does not exist";

            case FRENCH:
                return "Le joueur n'existe pas";
        }

        Log.e("NonexistentPlayerExcptn", LanguageManager.UNSET_LANGUAGE_ERROR_MESSAGE);
        return null;
    }
}