package model.meta;

public interface WaitingStateMssgsVisitor extends WaitingStateDOWNMssgsVisitor, WaitingStateUPMssgsVisitor {}


interface WaitingStateDOWNMssgsVisitor  {

    
}


interface WaitingStateUPMssgsVisitor extends CompensationRequestStateUPMssgsVisitor {

    
}
