package com.example.worldofdrinkraft.architecture.business;

import com.example.worldofdrinkraft.event.AbstractEvent;
import com.example.worldofdrinkraft.gamemode.GamemodeType;
import com.example.worldofdrinkraft.player.ExistentPlayerException;
import com.example.worldofdrinkraft.player.NonexistentPlayerException;
import com.example.worldofdrinkraft.language.Language;
import com.example.worldofdrinkraft.player.Player;

import java.util.List;

public interface IBusiness
{
    public void setLanguage(Language language);
    public Language getLanguage();

    public void addPlayer(Player player) throws ExistentPlayerException;
    public void deletePlayer(Player player) throws NonexistentPlayerException;
    public List<Player> getPlayerList();

    public void randomizePlayerRoles();

    public void setGamemodeType(GamemodeType gamemodeType);
    public GamemodeType getGamemodeType();

    public AbstractEvent getNextEvent();
}