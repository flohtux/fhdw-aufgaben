
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitNoteTransactionExceptionVisitor<E extends UserException> {
    
    public void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException, E;
    public void handleTrancaction(PersistentTrancaction trancaction) throws PersistenceException, E;
    
}
