
package view.visitor;

import view.*;

public interface DebitTransferPayedFeesVisitor {
    
    public void handleNoPayedFees(NoPayedFeesView noPayedFees) throws ModelException;
    public void handleDebitTransferPayedFees(DebitTransferPayedFeesView debitTransferPayedFees) throws ModelException;
    
}
