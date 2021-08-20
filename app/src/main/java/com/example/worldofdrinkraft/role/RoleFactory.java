package com.example.worldofdrinkraft.role;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class RoleFactory
{
    public static AbstractRole getRoleByType(RoleType roleType)
    {
        switch(roleType)
        {
            case COWBOY_TYPE:
                return new CowboyRole();

            case FREEZER_TYPE:
                return new FreezerRole();
        }

        Log.e("RoleFactory::roleByType", "Unset role");
        return null;
    }

    public static AbstractRole getRandomRole()
    {
        return RoleFactory.getRoleByType(RoleType.randomRoleType());
    }

    public static List<AbstractRole> getAllRoles()
    {
        List<AbstractRole> roleList = new ArrayList<>();

        for(RoleType roleType: RoleType.values())
            roleList.add(RoleFactory.getRoleByType(roleType));

        return roleList;
    }
}