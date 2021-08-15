package com.example.worldofdrinkraft.architecture.business;

import com.example.worldofdrinkraft.player.Player;

import java.util.ArrayList;

abstract public class IBusinessContainer
{
    private static IBusiness _iBusiness;

    public static IBusiness getInstance()
    {
        if(_iBusiness == null)
        {
            _iBusiness = new Business(
                    new ArrayList<Player>()
            );
        }

        return _iBusiness;
    }
}