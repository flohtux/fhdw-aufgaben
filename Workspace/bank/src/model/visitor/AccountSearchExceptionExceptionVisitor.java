
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountSearchExceptionExceptionVisitor<E extends UserException> {
    
    public void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException, E;
    public void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException, E;
    
}
