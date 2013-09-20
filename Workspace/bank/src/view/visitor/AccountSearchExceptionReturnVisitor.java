
package view.visitor;

import view.*;

public interface AccountSearchExceptionReturnVisitor<R> {
    
    public R handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException;
    public R handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException;
    
}
