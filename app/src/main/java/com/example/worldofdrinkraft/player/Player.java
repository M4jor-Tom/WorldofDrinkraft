package com.example.worldofdrinkraft.player;

import androidx.annotation.NonNull;

import com.example.worldofdrinkraft.game.Game;
import com.example.worldofdrinkraft.gamemode.GamemodeType;
import com.example.worldofdrinkraft.role.AbstractRole;

public class Player
{
    private String _name;
    private AbstractRole _role;

    public Player(
            String name,
            AbstractRole role
    )
    {
        setName(name);
        setRole(role);
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
        return getName().equalsIgnoreCase(((Player)player).getName());
    }

    public String toString()
    {
        return getName() + " - " + getRole();
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
}