
package view.visitor;

import view.*;

public abstract class DebitNoteTransferStandardVisitor implements DebitNoteTransferVisitor {
    
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    public void handleDebitNote(DebitNoteView debitNote) throws ModelException{
        this.standardHandling(debitNote);
    }
    protected abstract void standardHandling(DebitNoteTransferView debitNoteTransfer) throws ModelException;
}
