package com.example.worldofdrinkraft.architecture.business;

import com.example.worldofdrinkraft.player.ExistentPlayerException;
import com.example.worldofdrinkraft.player.NonexistentPlayerException;
import com.example.worldofdrinkraft.language.LanguageType;
import com.example.worldofdrinkraft.player.Player;

import java.util.List;

public interface IBusiness
{
    public void setLanguage(LanguageType languageType);
    public LanguageType getLanguage();

    public void addPlayer(Player player) throws ExistentPlayerException;
    public void deletePlayer(Player player) throws NonexistentPlayerException;
    public List<Player> getPlayerList();
}