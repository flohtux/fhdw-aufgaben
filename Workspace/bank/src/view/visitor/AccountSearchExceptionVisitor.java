
package view.visitor;

import view.*;

public interface AccountSearchExceptionVisitor {
    
    public void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException;
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException;
    
}
