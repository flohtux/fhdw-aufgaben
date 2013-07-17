
package view.visitor;

import view.*;

public interface TransactionFeeVisitor {
    
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException;
    public void handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException;
    public void handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException;
    
}
