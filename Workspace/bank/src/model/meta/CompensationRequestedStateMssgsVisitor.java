package model.meta;

public interface CompensationRequestedStateMssgsVisitor extends CompensationRequestedStateDOWNMssgsVisitor, CompensationRequestedStateUPMssgsVisitor {}


interface CompensationRequestedStateDOWNMssgsVisitor  {

    
}


interface CompensationRequestedStateUPMssgsVisitor extends DebitTransferStateUPMssgsVisitor {

    
}
