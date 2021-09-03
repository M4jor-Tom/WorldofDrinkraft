package com.example.worldofdrinkraft.role;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RoleFactory
{
    private static List<AbstractRole> _roleList = null;
    private final static Random _random = new Random();

    @Nullable
    public static AbstractRole getRoleByType(RoleType roleType)
    {
        for(AbstractRole role: getAllRoles())
            if(role.isOfType(roleType))
                return role;

        Log.e("RoleFactory::roleByType", "Unset role");
        return null;
    }

    public static AbstractRole getRandomRole()
    {
        return getRandomRole(Objects::nonNull);
    }

    public static AbstractRole getRandomRole(Predicate<? super AbstractRole> filterStatement)
    {
        List<AbstractRole> filteredList = getAllRoles()
                .stream()
                .filter(filterStatement)
                .collect(Collectors.toList());

        return filteredList
                .get(
                _random.nextInt(
                        filteredList.size()
                )
        );
    }

    public static List<AbstractRole> getAllRoles()
    {
        if(getRoleList() == null)
        {
            setRoleList(new ArrayList<>());

            addRoleToList(new CitizenRole());
            addRoleToList(new CowboyRole());
            addRoleToList(new FreezerRole());
            addRoleToList(new GypsyRole());
            addRoleToList(new NinjaRole());
            addRoleToList(new RomanRole());
            addRoleToList(new SadisticMasochistRole());
            addRoleToList(new VikingRole());
        }

        return getRoleList();
    }

    private static void setRoleList(List<AbstractRole> roleList)
    {
        _roleList = roleList;
    }

    private static List<AbstractRole> getRoleList()
    {
        return _roleList;
    }

    private static void addRoleToList(AbstractRole role)
    {
        getRoleList().add(role);
    }
}