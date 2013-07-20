
package view.visitor;

import view.*;

public abstract class DebitNoteTransferTransactionStandardVisitor implements DebitNoteTransferTransactionVisitor {
    
    public void handleTransaction(TransactionView transaction) throws ModelException{
        this.standardHandling(transaction);
    }
    public void handleDebitNote(DebitNoteView debitNote) throws ModelException{
        this.standardHandling(debitNote);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    protected abstract void standardHandling(DebitNoteTransferTransactionView debitNoteTransferTransaction) throws ModelException;
}
