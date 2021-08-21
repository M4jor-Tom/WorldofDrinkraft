package com.example.worldofdrinkraft.event;

import android.util.Log;

import com.example.worldofdrinkraft.language.LanguageManager;

abstract public class AbstractEvent
{
    abstract public EventType getType();

    abstract protected String getEnglishText();
    abstract protected String getFrenchText();

    final public String getText()
    {
        switch(LanguageManager.getInstance().getLanguageType())
        {
            case ENGLISH:
                return getEnglishText();

            case FRENCH:
                return getFrenchText();
        }

        Log.e("AbstractEvent.getText()", LanguageManager.UNSET_LANGUAGE_ERROR_MESSAGE);
        return null;
    }
}