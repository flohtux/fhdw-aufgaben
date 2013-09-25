package model.meta;

public interface DebitTransferStateMssgsVisitor extends DebitTransferStateDOWNMssgsVisitor, DebitTransferStateUPMssgsVisitor {}


interface DebitTransferStateDOWNMssgsVisitor extends ExecutedStateDOWNMssgsVisitor, NotSuccessfulStateDOWNMssgsVisitor, SuccessfulStateDOWNMssgsVisitor, CompensatedStateDOWNMssgsVisitor, NotExecutedStateDOWNMssgsVisitor, TemplateStateDOWNMssgsVisitor, NotExecutableStateDOWNMssgsVisitor {

    
}


interface DebitTransferStateUPMssgsVisitor  {

    
}
