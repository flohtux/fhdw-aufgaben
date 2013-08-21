
package view.visitor;

import view.*;

public interface TransactionFeeVisitor {
    
    public void handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException;
    public void handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException;
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException;
    
}
