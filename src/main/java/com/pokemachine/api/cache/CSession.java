package com.pokemachine.api.cache;

import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.forms.FLogin;
import com.pokemachine.api.interfaces.ProxyService;
import com.pokemachine.api.models.MSession;

public class CSession implements ProxyService{

    private MSession session = MSession.Build();

    private List<MSession> sessions = new ArrayList<MSession>();

    @Override
    public boolean startSession(FLogin data) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean authSession(FLogin data) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean endSession(FLogin data) {
        // TODO Auto-generated method stub
        return false;
    }
}
