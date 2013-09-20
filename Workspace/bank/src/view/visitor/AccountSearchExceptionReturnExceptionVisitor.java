
package view.visitor;
import view.UserException;
import view.*;

public interface AccountSearchExceptionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException, E;
    public R handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException, E;
    
}
