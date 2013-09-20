
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountSearchExceptionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException, E;
    public R handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException, E;
    
}
