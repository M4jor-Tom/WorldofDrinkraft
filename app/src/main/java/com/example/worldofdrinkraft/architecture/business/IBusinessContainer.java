package com.example.worldofdrinkraft.architecture.business;

abstract public class IBusinessContainer
{
    private static IBusiness _iBusiness;

    public static IBusiness getInstance()
    {
        if(_iBusiness == null)
        {
            _iBusiness = new Business(
                    null
            );
        }

        return _iBusiness;
    }
}