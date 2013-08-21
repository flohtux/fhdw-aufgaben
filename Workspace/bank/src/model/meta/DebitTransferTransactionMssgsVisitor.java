package model.meta;

public interface DebitTransferTransactionMssgsVisitor extends DebitTransferTransactionDOWNMssgsVisitor, DebitTransferTransactionUPMssgsVisitor {}


interface DebitTransferTransactionDOWNMssgsVisitor extends DebitTransferDOWNMssgsVisitor, TransactionDOWNMssgsVisitor {

    public void handleDebitTransferTransactionExecuteMssg(DebitTransferTransactionExecuteMssg event) throws persistence.PersistenceException;
    
}


interface DebitTransferTransactionUPMssgsVisitor  {

    public void handleDebitTransferTransactionExecuteMssg(DebitTransferTransactionExecuteMssg event) throws persistence.PersistenceException;
    
}
