package com.example.worldofdrinkraft.player;

import android.util.Log;

import com.example.worldofdrinkraft.language.Language;

public class NonexistentPlayerException extends Exception
{
    @Override
    public String getMessage()
    {
        switch(Language.getInstance().getLanguageType())
        {
            case ENGLISH:
                return "Player does not exist";

            case FRENCH:
                return "Le joueur n'existe pas";
        }

        Log.e("NonexistentPlayerExcptn", Language.UNSET_LANGUAGE_ERROR_MESSAGE);
        return null;
    }
}