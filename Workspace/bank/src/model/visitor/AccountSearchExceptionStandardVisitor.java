
package model.visitor;

import persistence.*;

public abstract class AccountSearchExceptionStandardVisitor implements AccountSearchExceptionVisitor {
    
    public void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException{
        this.standardHandling(invalidBankNumberException);
    }
    public void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException{
        this.standardHandling(invalidAccountNumberException);
    }
    protected abstract void standardHandling(model.AccountSearchException accountSearchException) throws PersistenceException;
}
