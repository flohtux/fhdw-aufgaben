package model.meta;

public interface CompensationStateMssgsVisitor extends CompensationStateDOWNMssgsVisitor, CompensationStateUPMssgsVisitor {}


interface CompensationStateDOWNMssgsVisitor extends WaitingCompensationStateDOWNMssgsVisitor, SuccessfulCompensationStateDOWNMssgsVisitor, DeclinedCompensationStateDOWNMssgsVisitor {

    
}


interface CompensationStateUPMssgsVisitor  {

    
}
