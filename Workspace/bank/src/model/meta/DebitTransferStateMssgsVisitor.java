package model.meta;

public interface DebitTransferStateMssgsVisitor extends DebitTransferStateDOWNMssgsVisitor, DebitTransferStateUPMssgsVisitor {}


interface DebitTransferStateDOWNMssgsVisitor extends ExecutedStateDOWNMssgsVisitor, NotSuccessfulStateDOWNMssgsVisitor, SuccessfulStateDOWNMssgsVisitor, CompensationRequestedStateDOWNMssgsVisitor, CompensatedStateDOWNMssgsVisitor, NotExecutedStateDOWNMssgsVisitor, TemplateStateDOWNMssgsVisitor, NotExecutableStateDOWNMssgsVisitor {

    
}


interface DebitTransferStateUPMssgsVisitor  {

    
}
