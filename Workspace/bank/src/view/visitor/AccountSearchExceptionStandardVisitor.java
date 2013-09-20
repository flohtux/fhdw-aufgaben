
package view.visitor;

import view.*;

public abstract class AccountSearchExceptionStandardVisitor implements AccountSearchExceptionVisitor {
    
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException{
        this.standardHandling(invalidBankNumberException);
    }
    public void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException{
        this.standardHandling(invalidAccountNumberException);
    }
    protected abstract void standardHandling(AccountSearchException accountSearchException) throws ModelException;
}
