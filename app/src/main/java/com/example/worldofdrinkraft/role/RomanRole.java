package com.example.worldofdrinkraft.role;

public class RomanRole extends AbstractRole
{
    @Override
    public RoleType getType()
    {
        return RoleType.ROMAN_TYPE;
    }

    @Override
    public Boolean isNormallyUnique()
    {
        return Boolean.valueOf(false);
    }

    @Override
    public Boolean isNormallyInGroup()
    {
        return Boolean.valueOf(true);
    }

    @Override
    protected String getEnglishLabel()
    {
        return "roman";
    }

    @Override
    protected String getFrenchLabel()
    {
        return "romain";
    }

    @Override
    protected String getEnglishRule()
    {
        return "All romans have to drink the same as a drinking one. They can, after a vote, decide to avoid drinking once every X turns.";
    }

    @Override
    protected String getFrenchRule()
    {
        return "Tous les romains doivent boire autant qu'un qui boit. Après un vote, ils peuvent décider de refuser de boire un fois tous les X tours.";
    }
}