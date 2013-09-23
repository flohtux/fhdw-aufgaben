package model.meta;

public interface DebitTransferTransactionMssgsVisitor extends DebitTransferTransactionDOWNMssgsVisitor, DebitTransferTransactionUPMssgsVisitor {}


interface DebitTransferTransactionDOWNMssgsVisitor extends DebitTransferDOWNMssgsVisitor, TransactionDOWNMssgsVisitor, DebitTransferNoValueUPMssgsVisitor {

    public void handleDebitTransferTransactionChangeStateDebitTransferStateMssg(DebitTransferTransactionChangeStateDebitTransferStateMssg event) throws persistence.PersistenceException;
    public void handleDebitTransferTransactionExecuteMssg(DebitTransferTransactionExecuteMssg event) throws persistence.PersistenceException;
    
}


interface DebitTransferTransactionUPMssgsVisitor  {

    public void handleDebitTransferTransactionChangeStateDebitTransferStateMssg(DebitTransferTransactionChangeStateDebitTransferStateMssg event) throws persistence.PersistenceException;
    public void handleDebitTransferTransactionExecuteMssg(DebitTransferTransactionExecuteMssg event) throws persistence.PersistenceException;
    
}
