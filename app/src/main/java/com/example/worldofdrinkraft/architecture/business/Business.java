package com.example.worldofdrinkraft.architecture.business;

import androidx.annotation.NonNull;

import com.example.worldofdrinkraft.event.AbstractEvent;
import com.example.worldofdrinkraft.event.EventFactory;
import com.example.worldofdrinkraft.gamemode.GamemodeType;
import com.example.worldofdrinkraft.language.LanguageManager;
import com.example.worldofdrinkraft.player.ExistentPlayerException;
import com.example.worldofdrinkraft.player.NonexistentPlayerException;
import com.example.worldofdrinkraft.language.Language;
import com.example.worldofdrinkraft.player.Player;
import com.example.worldofdrinkraft.role.AbstractRole;
import com.example.worldofdrinkraft.role.RoleFactory;
import com.example.worldofdrinkraft.role.RoleType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Business implements IBusiness
{
    private List<Player> _playerList;
    private GamemodeType _gamemodeType;

    private final static Integer PLAYER_MINIMUM_GROUP_SIZE = 2;
    private final static Integer PLAYER_CONSTRAINTLESS_PER_UNIQUE = 3;

    private final Random _random = new Random();

    public Business(List<Player> playerList)
    {
        setPlayerList(playerList);
        setGamemodeType(null);
    }

    @Override
    public void setLanguage(Language language)
    {
        LanguageManager.getInstance().setLanguage(language);
    }

    @Override
    public Language getLanguage()
    {
        return LanguageManager.getInstance().getLanguage();
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

    @NonNull
    private Integer getPlayerCount()
    {
        return getPlayerList().size();
    }

    @NonNull
    private List<Player> getPlayerOfRoleTypeList(RoleType roleType)
    {
        List<Player> playerOfRoleTypeList = new ArrayList<>();

        for(Player player: getPlayerList())
            if(player.getRole().getType().equals(roleType))
                playerOfRoleTypeList.add(player);

        return playerOfRoleTypeList;
    }

    @NonNull
    private Integer getPlayerOfRoleTypeCount(RoleType roleType)
    {
        return getPlayerOfRoleTypeList(roleType).size();
    }

    @Override
    public void randomizePlayerRoles()
    {
        Collections.shuffle(getPlayerList());

        if(gamemodeTypeIs(GamemodeType.LIMITLESS_TYPE))
        {
            for(Player player: getPlayerList())
                player.setRole(RoleFactory.getRandomRole());
        }
        else
        {
            //Can randomize limitless among count constraintless roles
            for(Player player: getPlayerList())
                player.setRole(RoleFactory.getRandomCountConstraintlessRole());

            if(getPlayerCount() <= PLAYER_CONSTRAINTLESS_PER_UNIQUE + 1)
            {
                //Giving an unique role to a random player
                getPlayerList().get(
                    _random.nextInt(getPlayerCount())
                ).setRole(RoleFactory.getRandomUniqueRole());
            }
            else if(getPlayerCount() <= PLAYER_CONSTRAINTLESS_PER_UNIQUE + PLAYER_MINIMUM_GROUP_SIZE)
            {
                //PLAYER_CONSTRAINTLESS_PER_UNIQUE < Players count < PLAYER_MINIMUM_GROUP_SIZE

                //Can randomize with 1 group and count constraintless roles
                AbstractRole inGroupRole = RoleFactory.getRandomInGroupRole();

                //Giving the inGroup role to the 2 firsts players in the list
                int i = 0;
                for(Player player: getPlayerList())
                    if(i++ < PLAYER_MINIMUM_GROUP_SIZE)
                        player.setRole(inGroupRole);
            }
        }
    }

    @Override
    public void setGamemodeType(GamemodeType gamemodeType)
    {
        _gamemodeType = gamemodeType;
    }

    @Override
    public GamemodeType getGamemodeType()
    {
        return _gamemodeType;
    }

    @Override
    public Boolean gamemodeTypeIs(GamemodeType gamemodeType)
    {
        return _gamemodeType.equals(gamemodeType);
    }

    @Override
    public AbstractEvent getNextEvent()
    {
        return EventFactory.getRandomEvent();
    }
}