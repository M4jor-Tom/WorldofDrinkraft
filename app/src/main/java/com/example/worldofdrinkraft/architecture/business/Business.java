package com.example.worldofdrinkraft.architecture.business;

import com.example.worldofdrinkraft.language.Language;
import com.example.worldofdrinkraft.player.ExistentPlayerException;
import com.example.worldofdrinkraft.player.NonexistentPlayerException;
import com.example.worldofdrinkraft.language.LanguageType;
import com.example.worldofdrinkraft.player.Player;

import java.util.List;

public class Business implements IBusiness
{
    private List<Player> _playerList;

    public Business(List<Player> playerList)
    {
        setPlayerList(playerList);
    }

    @Override
    public void setLanguage(LanguageType languageType)
    {
        Language.getInstance().setLanguageType(languageType);
    }

    @Override
    public LanguageType getLanguage()
    {
        return Language.getInstance().getLanguageType();
    }

    @Override
    public void addPlayer(Player player) throws ExistentPlayerException
    {
        List<Player> newPlayerList = getPlayerList();

        if(newPlayerList.contains(player))
            throw new ExistentPlayerException();

        newPlayerList.add(player);

        setPlayerList(newPlayerList);
    }

    @Override
    public void deletePlayer(Player player) throws NonexistentPlayerException
    {
        List<Player> newPlayerList = getPlayerList();

        if(!newPlayerList.contains(player))
            throw new NonexistentPlayerException();

        for(Player selectedPlayer: newPlayerList)
            if(selectedPlayer.equals(player))
                newPlayerList.remove(player);
    }

    private void setPlayerList(List<Player> playerList)
    {
        _playerList = playerList;
    }

    @Override
    public List<Player> getPlayerList()
    {
        return _playerList;
    }
}