package model.meta;

public interface DebitNoteTransferTransactionMssgsVisitor extends DebitNoteTransferTransactionDOWNMssgsVisitor, DebitNoteTransferTransactionUPMssgsVisitor {}


interface DebitNoteTransferTransactionDOWNMssgsVisitor extends DebitNoteTransferDOWNMssgsVisitor, TransactionDOWNMssgsVisitor {

    
}


interface DebitNoteTransferTransactionUPMssgsVisitor  {

    
}
