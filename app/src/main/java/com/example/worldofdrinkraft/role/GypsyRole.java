package com.example.worldofdrinkraft.role;

public class GypsyRole extends AbstractRole
{
    @Override
    public RoleType getType()
    {
        return RoleType.GYPSY_TYPE;
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
        return "gypsy";
    }

    @Override
    protected String getFrenchLabel()
    {
        return "gitant";
    }

    @Override
    protected String getEnglishRule()
    {
        return "Gypsies can exchange their drinks as they want.";
    }

    @Override
    protected String getFrenchRule()
    {
        return "Les gitans peuvent s'échanger leurs gogrées à volonté.";
    }
}