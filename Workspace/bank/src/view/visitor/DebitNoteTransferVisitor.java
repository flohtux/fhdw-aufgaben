
package view.visitor;

import view.*;

public interface DebitNoteTransferVisitor {
    
    public void handleDebitNote(DebitNoteView debitNote) throws ModelException;
    public void handleTransfer(TransferView transfer) throws ModelException;
    
}
