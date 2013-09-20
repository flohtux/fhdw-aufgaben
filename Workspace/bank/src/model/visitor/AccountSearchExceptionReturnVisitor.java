
package model.visitor;

import persistence.*;

public interface AccountSearchExceptionReturnVisitor<R> {
    
    public R handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException;
    public R handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException;
    
}
