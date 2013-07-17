package model.meta;

public interface DebitNoteTransactionMssgsVisitor extends DebitNoteTransactionDOWNMssgsVisitor, DebitNoteTransactionUPMssgsVisitor {}


interface DebitNoteTransactionDOWNMssgsVisitor extends DebitNoteDOWNMssgsVisitor, TrancactionDOWNMssgsVisitor {

    
}


interface DebitNoteTransactionUPMssgsVisitor  {

    
}
