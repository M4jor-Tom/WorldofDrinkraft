package com.example.worldofdrinkraft.role;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.worldofdrinkraft.game.Game;
import com.example.worldofdrinkraft.gamemode.GamemodeType;
import com.example.worldofdrinkraft.language.Language;
import com.example.worldofdrinkraft.language.LanguageManager;
import com.example.worldofdrinkraft.language.MultiLanguageString;

import java.util.HashMap;
import java.util.Map;

abstract public class AbstractRole
{
    abstract public RoleType getType();

    abstract public Boolean isDrinkerOnlyRole();

    abstract public Boolean isNormallyUnique();

    abstract public Boolean isNormallyInGroup();

    abstract protected String getEnglishLabel();
    abstract protected String getFrenchLabel();

    abstract protected String getEnglishRule();
    abstract protected String getFrenchRule();

    @NonNull
    final public Boolean isOfType(RoleType type)
    {
        return getType().equals(type);
    }

    @NonNull
    final public Boolean hasCountConstraint()
    {
        return isNormallyUnique() || isNormallyInGroup();
    }

    @NonNull
    final public String getDrinkerText()
    {
        Map<Language, String> drinkerMap = new HashMap<>();

        if(isDrinkerOnlyRole())
        {
            drinkerMap.put(Language.ENGLISH, "drinker role");
            drinkerMap.put(Language.FRENCH, "rôle buveur");
        }
        else
        {
            drinkerMap.put(Language.ENGLISH, "role for all");
            drinkerMap.put(Language.FRENCH, "rôle pour tous");
        }

        return (new MultiLanguageString(drinkerMap)).toString();
    }

    @NonNull
    @Override
    final public String toString()
    {
        return getLabel() + " - " + getDrinkerText();
    }

    @NonNull
    final public String getLabel()
    {
        Map<Language, String> labelMap = new HashMap<>();

        labelMap.put(Language.ENGLISH, getEnglishLabel());
        labelMap.put(Language.FRENCH, getFrenchLabel());

        return (new MultiLanguageString(labelMap)).toString();
    }

    @Nullable
    final public String getRule()
    {
        Map<Language, String> ruleMap = new HashMap<>();

        ruleMap.put(Language.ENGLISH, getEnglishRule());
        ruleMap.put(Language.FRENCH, getFrenchRule());

        return (new MultiLanguageString(ruleMap)).toString();
    }
}