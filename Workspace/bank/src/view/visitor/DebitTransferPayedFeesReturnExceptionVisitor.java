
package view.visitor;
import view.UserException;
import view.*;

public interface DebitTransferPayedFeesReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleNoPayedFees(NoPayedFeesView noPayedFees) throws ModelException, E;
    public R handleDebitTransferPayedFees(DebitTransferPayedFeesView debitTransferPayedFees) throws ModelException, E;
    
}
