
package view.visitor;
import view.UserException;
import view.*;

public interface TransactionFeeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException, E;
    public R handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException, E;
    public R handleMixedFee(MixedFeeView mixedFee) throws ModelException, E;
    
}
