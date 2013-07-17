
package view.visitor;

import view.*;

public abstract class TransactionFeeStandardVisitor implements TransactionFeeVisitor {
    
    public void handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException{
        this.standardHandling(fixTransactionFee);
    }
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException{
        this.standardHandling(mixedFee);
    }
    public void handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException{
        this.standardHandling(procentualFee);
    }
    protected abstract void standardHandling(TransactionFeeView transactionFee) throws ModelException;
}
