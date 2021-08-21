package com.example.worldofdrinkraft.role;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RoleFactory
{
    private static List<AbstractRole> _roleList = null;

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
        return RoleFactory.getRoleByType(RoleType.randomRoleType());
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

    @NonNull
    public static List<AbstractRole> getCountConstraintlessRoleList()
    {
        List<AbstractRole> countConstraintlessRoleList = new ArrayList<>();

        for(AbstractRole role: getAllRoles())
            if(!role.hasCountConstraint())
                countConstraintlessRoleList.add(role);

        return countConstraintlessRoleList;
    }

    @NonNull
    public static List<AbstractRole> getUniqueRoleList()
    {
        List<AbstractRole> uniqueRoleList = new ArrayList<>();

        for(AbstractRole role: getAllRoles())
            if(role.isUnique())
                uniqueRoleList.add(role);

        return uniqueRoleList;
    }

    @NonNull
    public static List<AbstractRole> getInGroupRoleList()
    {
        List<AbstractRole> groupRoleList = new ArrayList<>();

        for(AbstractRole role: getAllRoles())
            if(role.isInGroup())
                groupRoleList.add(role);

        return groupRoleList;
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