package com.example.worldofdrinkraft.role;

import android.util.Log;

import com.example.worldofdrinkraft.language.Language;

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

    final public String getLabel(Language language)
    {
        switch(language)
        {
            case ENGLISH:
                return getEnglishLabel();

            case FRENCH:
                return getFrenchLabel();
        }

        Log.e("AbstractRole::label", "Unset language");
        return null;
    }

    final public String getRule(Language language)
    {
        switch(language)
        {
            case ENGLISH:
                return getEnglishRule();

            case FRENCH:
                return getFrenchRule();
        }

        Log.e("AbstractRole::rule", "Unset language");
        return null;
    }
}