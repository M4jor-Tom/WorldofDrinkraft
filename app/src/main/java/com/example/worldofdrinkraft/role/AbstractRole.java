package com.example.worldofdrinkraft.role;

import android.util.Log;

import com.example.worldofdrinkraft.architecture.business.IBusinessContainer;
import com.example.worldofdrinkraft.gamemode.GamemodeType;
import com.example.worldofdrinkraft.language.LanguageManager;

abstract public class AbstractRole
{
    abstract public RoleType getType();

    abstract protected Boolean isNormallyUnique();

    abstract protected Boolean isNormallyInGroup();

    abstract protected String getEnglishLabel();
    abstract protected String getFrenchLabel();

    abstract protected String getEnglishRule();
    abstract protected String getFrenchRule();

    final public Boolean isOfType(RoleType type)
    {
        return Boolean.valueOf(getType().equals(type));
    }

    final public Boolean isUnique()
    {
        return Boolean.valueOf(
                isNormallyUnique()
                && !IBusinessContainer.getInstance().gamemodeTypeIs(GamemodeType.LIMITLESS_TYPE)
        );
    }

    final public Boolean isInGroup()
    {
        return Boolean.valueOf(
                isNormallyInGroup()
                && !IBusinessContainer.getInstance().gamemodeTypeIs(GamemodeType.LIMITLESS_TYPE)
        );
    }

    final public String toString()
    {
        return getLabel();
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

        Log.e("AbstractRole::label", LanguageManager.UNSET_LANGUAGE_ERROR_MESSAGE);
        return null;
    }

    final public String getRule()
    {
        switch(LanguageManager.getInstance().getLanguage())
        {
            case ENGLISH:
                return getEnglishRule();

            case FRENCH:
                return getFrenchRule();
        }

        Log.e("AbstractRole::rule", LanguageManager.UNSET_LANGUAGE_ERROR_MESSAGE);
        return null;
    }
}