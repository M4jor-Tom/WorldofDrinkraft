package com.example.worldofdrinkraft.role;

public class VikingRole extends AbstractRole
{
    @Override
    public RoleType getType()
    {
        return RoleType.VIKING_TYPE;
    }

    @Override
    protected Boolean isNormallyUnique()
    {
        return Boolean.valueOf(false);
    }

    @Override
    protected Boolean isNormallyInGroup()
    {
        return Boolean.valueOf(false);
    }

    @Override
    protected String getEnglishLabel()
    {
        return "viking";
    }

    @Override
    protected String getFrenchLabel()
    {
        return "viking";
    }

    @Override
    protected String getEnglishRule()
    {
        return "Drinks twice more, but can force anyone to drink.";
    }

    @Override
    protected String getFrenchRule()
    {
        return "Boit double, mais peut faire boire n'importe qui.";
    }
}