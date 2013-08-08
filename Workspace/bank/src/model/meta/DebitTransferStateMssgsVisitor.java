package model.meta;

public interface DebitTransferStateMssgsVisitor extends DebitTransferStateDOWNMssgsVisitor, DebitTransferStateUPMssgsVisitor {}


interface DebitTransferStateDOWNMssgsVisitor extends TemplateStateDOWNMssgsVisitor, NotExecutetStateDOWNMssgsVisitor, ExecutedStateDOWNMssgsVisitor, NotExecutableStateDOWNMssgsVisitor, NotSuccessfulStateDOWNMssgsVisitor, SuccessfulStateDOWNMssgsVisitor {

    
}


interface DebitTransferStateUPMssgsVisitor  {

    
}
