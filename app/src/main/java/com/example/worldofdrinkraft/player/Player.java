package com.example.worldofdrinkraft.player;

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

    @Override
    public boolean equals(Object player)
    {
        return getName().equalsIgnoreCase(((Player)player).getName());
    }

    private void setName(String name)
    {
        _name = name;
    }

    public String getName()
    {
        return _name;
    }

    private void setRole(AbstractRole role)
    {
        _role = role;
    }

    public AbstractRole getRole()
    {
        return _role;
    }
}