package model.meta;

public interface DebitTransferStateMssgsVisitor extends DebitTransferStateDOWNMssgsVisitor, DebitTransferStateUPMssgsVisitor {}


interface DebitTransferStateDOWNMssgsVisitor extends ExecutedStateDOWNMssgsVisitor, NotSuccessfulStateDOWNMssgsVisitor, SuccessfulStateDOWNMssgsVisitor, TemplateStateDOWNMssgsVisitor, NotExecutetStateDOWNMssgsVisitor, NotExecutableStateDOWNMssgsVisitor {

    
}


interface DebitTransferStateUPMssgsVisitor  {

    
}
