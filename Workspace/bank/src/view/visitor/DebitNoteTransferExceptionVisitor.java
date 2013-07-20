
package view.visitor;
import view.UserException;
import view.*;

public interface DebitNoteTransferExceptionVisitor<E extends UserException> {
    
    public void handleDebitNote(DebitNoteView debitNote) throws ModelException, E;
    public void handleTransfer(TransferView transfer) throws ModelException, E;
    
}
