package com.example.worldofdrinkraft.role;

public class FreezerRole extends AbstractRole
{
    @Override
    public RoleType getType()
    {
        return RoleType.FREEZER_TYPE;
    }

    @Override
    public Boolean isNormallyUnique()
    {
        return Boolean.valueOf(true);
    }

    @Override
    public Boolean isNormallyInGroup()
    {
        return Boolean.valueOf(false);
    }

    @Override
    protected String getEnglishLabel()
    {
        return "freezer";
    }

    @Override
    protected String getFrenchLabel()
    {
        return "freezer";
    }

    @Override
    protected String getEnglishRule()
    {
        return "Makes the last player to stop moving after he does drinking";
    }

    @Override
    protected String getFrenchRule()
    {
        return "Fait boire le dernier joueur à s'arrêter de bouger après lui";
    }
}