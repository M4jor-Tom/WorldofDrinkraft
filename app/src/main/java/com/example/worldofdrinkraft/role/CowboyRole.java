package com.example.worldofdrinkraft.role;

public class CowboyRole extends AbstractRole
{
    @Override
    public RoleType getType()
    {
        return RoleType.COWBOY_TYPE;
    }

    @Override
    protected Boolean isNormallyUnique()
    {
        return Boolean.valueOf(false);
    }

    @Override
    protected Boolean isNormallyInGroup()
    {
        return Boolean.valueOf(true);
    }

    @Override
    protected String getEnglishLabel()
    {
        return "cowboy";
    }

    @Override
    protected String getFrenchLabel()
    {
        return "cowboy";
    }

    @Override
    protected String getEnglishRule()
    {
        return "Can shoot any other cowboy to force them drinking";
    }

    @Override
    protected String getFrenchRule()
    {
        return "Peut tirer sur n'importe quel cowboy pour le forcer à boire";
    }
}