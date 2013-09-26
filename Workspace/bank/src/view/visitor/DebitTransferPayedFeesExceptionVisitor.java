
package view.visitor;
import view.UserException;
import view.*;

public interface DebitTransferPayedFeesExceptionVisitor<E extends UserException> {
    
    public void handleNoPayedFees(NoPayedFeesView noPayedFees) throws ModelException, E;
    public void handleDebitTransferPayedFees(DebitTransferPayedFeesView debitTransferPayedFees) throws ModelException, E;
    
}
