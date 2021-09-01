package com.example.worldofdrinkraft.player;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.worldofdrinkraft.game.Game;
import com.example.worldofdrinkraft.gamemode.GamemodeType;
import com.example.worldofdrinkraft.language.Language;
import com.example.worldofdrinkraft.language.MultiLanguageString;
import com.example.worldofdrinkraft.role.AbstractRole;

import java.util.HashMap;
import java.util.Map;

public class Player
{
    private String _name;
    private AbstractRole _role;
    private Boolean _drinker;

    public Player(
            String name,
            AbstractRole role,
            Boolean drinker
    )
    {
        setName(name);
        setRole(role);
        setDrinker(drinker);
    }

    final private Boolean isDrinkingValid()
    {
        return isDrinker() || !getRole().isDrinkerOnlyRole();
    }

    @NonNull
    final public Boolean isUnique()
    {
        return getRole().isNormallyUnique()
                && !Game.getInstance().getGamemode().gamemodeTypeIs(GamemodeType.LIMITLESS_TYPE);
    }

    @NonNull
    final public Boolean isInGroup()
    {
        return getRole().isNormallyInGroup()
                && !Game.getInstance().getGamemode().gamemodeTypeIs(GamemodeType.LIMITLESS_TYPE);
    }

    @Override
    public boolean equals(Object player)
    {
        if(player.getClass() == Player.class)
            return getName().equalsIgnoreCase(((Player)player).getName());
        Log.e("Player.equals()", "Given object is not a player");
        return false;
    }

    @NonNull
    private String getDrinkerText()
    {
        Map<Language, String> drinkingHashMap = new HashMap<Language, String>();

        if(isDrinker())
        {
            drinkingHashMap.put(Language.ENGLISH, "drinks");
            drinkingHashMap.put(Language.FRENCH, "boit");
        }
        else
        {
            drinkingHashMap.put(Language.ENGLISH, "doesn't drink");
            drinkingHashMap.put(Language.FRENCH, "Ne boit pas");
        }

        return (new MultiLanguageString(drinkingHashMap)).toString();
    }

    @Override
    @NonNull
    public String toString()
    {
        return getName() + " - " + getRole() + " - " + getDrinkerText();
    }

    private void setName(String name)
    {
        _name = name;
    }

    public String getName()
    {
        return _name;
    }

    public void setRole(AbstractRole role)
    {
        _role = role;
    }

    public AbstractRole getRole()
    {
        return _role;
    }

    private void setDrinker(Boolean drinker)
    {
        _drinker = drinker;
    }

    private Boolean isDrinker()
    {
        return _drinker;
    }
}