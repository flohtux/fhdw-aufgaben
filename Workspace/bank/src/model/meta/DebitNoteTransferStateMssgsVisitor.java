package model.meta;

public interface DebitNoteTransferStateMssgsVisitor extends DebitNoteTransferStateDOWNMssgsVisitor, DebitNoteTransferStateUPMssgsVisitor {}


interface DebitNoteTransferStateDOWNMssgsVisitor extends TemplateStateDOWNMssgsVisitor, NotExecutetStateDOWNMssgsVisitor, ExecutedStateDOWNMssgsVisitor, NotSuccessfullStateDOWNMssgsVisitor, NotExecutableStateDOWNMssgsVisitor, SuccessfullStateDOWNMssgsVisitor {

    
}


interface DebitNoteTransferStateUPMssgsVisitor  {

    
}
