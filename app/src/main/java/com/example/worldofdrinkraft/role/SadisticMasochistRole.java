package com.example.worldofdrinkraft.role;

public class SadisticMasochistRole extends AbstractRole
{
    @Override
    public RoleType getType()
    {
        return RoleType.SADISTIC_MASOCHIST_TYPE;
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
        return "sadistic masochist";
    }

    @Override
    protected String getFrenchLabel()
    {
        return "sado-maso";
    }

    @Override
    protected String getEnglishRule()
    {
        return "Can force anyone to drink, but has to drink the half then.";
    }

    @Override
    protected String getFrenchRule()
    {
        return "Peut forcer n'importe qui à boire, mais doit en boire la moitié.";
    }
}