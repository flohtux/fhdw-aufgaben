package model.meta;

public interface AcceptedStateMssgsVisitor extends AcceptedStateDOWNMssgsVisitor, AcceptedStateUPMssgsVisitor {}


interface AcceptedStateDOWNMssgsVisitor  {

    
}


interface AcceptedStateUPMssgsVisitor extends CompensationRequestStateUPMssgsVisitor {

    
}
