package model.meta;

public interface TransactionMssgsVisitor extends TransactionDOWNMssgsVisitor, TransactionUPMssgsVisitor {}


interface TransactionDOWNMssgsVisitor  {

    
}


interface TransactionUPMssgsVisitor extends DebitNoteTransferTransactionUPMssgsVisitor {

    
}
