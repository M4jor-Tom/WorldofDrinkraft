package com.example.worldofdrinkraft.role;

import android.util.Log;

import androidx.annotation.NonNull;

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
        return getType().equals(type);
    }

    final public Boolean isUnique()
    {
        return isNormallyUnique()
                && !IBusinessContainer.getInstance().gamemodeTypeIs(GamemodeType.LIMITLESS_TYPE);
    }

    final public Boolean isInGroup()
    {
        return isNormallyInGroup()
                && !IBusinessContainer.getInstance().gamemodeTypeIs(GamemodeType.LIMITLESS_TYPE);
    }

    final public Boolean hasCountConstraint()
    {
        return isUnique() || isInGroup();
    }

    final public String toString()
    {
        return getLabel();
    }

    @NonNull
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
        return LanguageManager.UNSET_LANGUAGE_ERROR_MESSAGE;
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