
package view.visitor;

import view.*;

public abstract class DebitTransferTransactionDirectVisitor implements DebitTransferTransactionVisitor {
    
    public abstract void handleTransaction(TransactionView transaction) throws ModelException;
    
    public abstract void handleDebitTransfer(DebitTransferView debitTransfer) throws ModelException;
    
    public void handleDebit(DebitView debit) throws ModelException{
        this.handleDebitTransfer(debit);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.handleDebitTransfer(transfer);
    }
    
}
