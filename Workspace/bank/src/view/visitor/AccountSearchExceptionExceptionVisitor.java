
package view.visitor;
import view.UserException;
import view.*;

public interface AccountSearchExceptionExceptionVisitor<E extends UserException> {
    
    public void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException, E;
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException, E;
    
}
