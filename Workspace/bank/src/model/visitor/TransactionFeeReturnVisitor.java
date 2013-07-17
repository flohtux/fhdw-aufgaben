
package model.visitor;

import persistence.*;

public interface TransactionFeeReturnVisitor<R> {
    
    public R handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException;
    public R handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException;
    public R handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException;
    
}
