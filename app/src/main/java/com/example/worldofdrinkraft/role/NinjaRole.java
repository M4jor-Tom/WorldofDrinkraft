package com.example.worldofdrinkraft.role;

public class NinjaRole extends AbstractRole
{
    @Override
    public RoleType getType()
    {
        return RoleType.NINJA_TYPE;
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
        return "ninja";
    }

    @Override
    protected String getFrenchLabel()
    {
        return "ninja";
    }

    @Override
    protected String getEnglishRule()
    {
        return "Can redirect drinks from anyone to anyone, but has to drink half of them when done.";
    }

    @Override
    protected String getFrenchRule()
    {
        return "Peut rediriger les gorgées de n'importe qui à n'importe qui, mais doit alors en boire la moitié.";
    }
}