package com.example.worldofdrinkraft.role;

public class CitizenRole extends AbstractRole
{
    @Override
    public RoleType getType()
    {
        return RoleType.CITIZEN_TYPE;
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
        return "citizen";
    }

    @Override
    protected String getFrenchLabel()
    {
        return "citoyen";
    }

    @Override
    protected String getEnglishRule()
    {
        return "Citizens can vote every X turns to force someone drinking.";
    }

    @Override
    protected String getFrenchRule()
    {
        return "Les citoyens peuvent forcer une personne à boire tous les X tours.";
    }
}