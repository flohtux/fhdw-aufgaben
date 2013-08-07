package model.meta;

public interface DebitNoteTransferTransactionMssgsVisitor extends DebitNoteTransferTransactionDOWNMssgsVisitor, DebitNoteTransferTransactionUPMssgsVisitor {}


interface DebitNoteTransferTransactionDOWNMssgsVisitor extends DebitNoteTransferDOWNMssgsVisitor, TransactionDOWNMssgsVisitor {

    public void handleDebitNoteTransferTransactionExecuteMssg(DebitNoteTransferTransactionExecuteMssg event) throws persistence.PersistenceException;
    
}


interface DebitNoteTransferTransactionUPMssgsVisitor  {

    public void handleDebitNoteTransferTransactionExecuteMssg(DebitNoteTransferTransactionExecuteMssg event) throws persistence.PersistenceException;
    
}
