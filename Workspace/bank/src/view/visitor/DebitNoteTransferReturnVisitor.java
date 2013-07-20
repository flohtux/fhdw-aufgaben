
package view.visitor;

import view.*;

public interface DebitNoteTransferReturnVisitor<R> {
    
    public R handleDebitNote(DebitNoteView debitNote) throws ModelException;
    public R handleTransfer(TransferView transfer) throws ModelException;
    
}
