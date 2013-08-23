
package view.visitor;

import view.*;

public abstract class DebitTransferTransactionStandardVisitor implements DebitTransferTransactionVisitor {
    
    public void handleTransaction(TransactionView transaction) throws ModelException{
        this.standardHandling(transaction);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    public void handleDebit(DebitView debit) throws ModelException{
        this.standardHandling(debit);
    }
    protected abstract void standardHandling(DebitTransferTransactionView debitTransferTransaction) throws ModelException;
}
