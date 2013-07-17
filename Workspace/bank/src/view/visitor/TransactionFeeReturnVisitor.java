
package view.visitor;

import view.*;

public interface TransactionFeeReturnVisitor<R> {
    
    public R handleMixedFee(MixedFeeView mixedFee) throws ModelException;
    public R handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException;
    public R handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException;
    
}
