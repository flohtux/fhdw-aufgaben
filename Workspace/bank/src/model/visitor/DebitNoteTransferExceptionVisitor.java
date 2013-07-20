
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitNoteTransferExceptionVisitor<E extends UserException> {
    
    public void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException, E;
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException, E;
    
}
