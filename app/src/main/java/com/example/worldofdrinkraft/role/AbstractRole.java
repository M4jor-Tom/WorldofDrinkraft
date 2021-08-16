package com.example.worldofdrinkraft.role;

import android.util.Log;

import com.example.worldofdrinkraft.language.Language;
import com.example.worldofdrinkraft.language.LanguageType;

abstract public class AbstractRole
{
    abstract public RoleType getType();

    abstract protected String getEnglishLabel();
    abstract protected String getFrenchLabel();

    abstract protected String getEnglishRule();
    abstract protected String getFrenchRule();

    final public Boolean isOfType(RoleType type)
    {
        return getType().equals(type);
    }

    final public String toString()
    {
        return getLabel();
    }

    final public String getLabel()
    {
        switch(Language.getInstance().getLanguageType())
        {
            case ENGLISH:
                return getEnglishLabel();

            case FRENCH:
                return getFrenchLabel();
        }

        Log.e("AbstractRole::label", Language.UNSET_LANGUAGE_ERROR_MESSAGE);
        return null;
    }

    final public String getRule()
    {
        switch(Language.getInstance().getLanguageType())
        {
            case ENGLISH:
                return getEnglishRule();

            case FRENCH:
                return getFrenchRule();
        }

        Log.e("AbstractRole::rule", Language.UNSET_LANGUAGE_ERROR_MESSAGE);
        return null;
    }
}