
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObsInterfaceExceptionVisitor<E extends UserException> {
    
    public void handleAccountDebitNoteTransferTransactions(PersistentAccountDebitNoteTransferTransactions accountDebitNoteTransferTransactions) throws PersistenceException, E;
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    
}
