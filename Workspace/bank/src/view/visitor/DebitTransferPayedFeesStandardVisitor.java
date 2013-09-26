
package view.visitor;

import view.*;

public abstract class DebitTransferPayedFeesStandardVisitor implements DebitTransferPayedFeesVisitor {
    
    public void handleDebitTransferPayedFees(DebitTransferPayedFeesView debitTransferPayedFees) throws ModelException{
        this.standardHandling(debitTransferPayedFees);
    }
    public void handleNoPayedFees(NoPayedFeesView noPayedFees) throws ModelException{
        this.standardHandling(noPayedFees);
    }
    protected abstract void standardHandling(DebitTransferPayedFeesView debitTransferPayedFees) throws ModelException;
}
