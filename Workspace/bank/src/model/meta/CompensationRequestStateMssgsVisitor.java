package model.meta;

public interface CompensationRequestStateMssgsVisitor extends CompensationRequestStateDOWNMssgsVisitor, CompensationRequestStateUPMssgsVisitor {}


interface CompensationRequestStateDOWNMssgsVisitor extends AcceptedStateDOWNMssgsVisitor, WaitingStateDOWNMssgsVisitor, DeclinedStateDOWNMssgsVisitor {

    
}


interface CompensationRequestStateUPMssgsVisitor  {

    
}
