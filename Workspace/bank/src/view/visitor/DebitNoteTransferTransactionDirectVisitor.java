
package view.visitor;

import view.*;

public abstract class DebitNoteTransferTransactionDirectVisitor implements DebitNoteTransferTransactionVisitor {
    
    public abstract void handleTransaction(TransactionView transaction) throws ModelException;
    
    public abstract void handleDebitNoteTransfer(DebitNoteTransferView debitNoteTransfer) throws ModelException;
    
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.handleDebitNoteTransfer(transfer);
    }
    public void handleDebitNote(DebitNoteView debitNote) throws ModelException{
        this.handleDebitNoteTransfer(debitNote);
    }
    
}
