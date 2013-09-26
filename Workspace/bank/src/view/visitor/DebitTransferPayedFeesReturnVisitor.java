
package view.visitor;

import view.*;

public interface DebitTransferPayedFeesReturnVisitor<R> {
    
    public R handleNoPayedFees(NoPayedFeesView noPayedFees) throws ModelException;
    public R handleDebitTransferPayedFees(DebitTransferPayedFeesView debitTransferPayedFees) throws ModelException;
    
}
