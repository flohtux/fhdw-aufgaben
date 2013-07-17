
package model.visitor;

import persistence.*;

public interface TransactionFeeVisitor {
    
    public void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException;
    public void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException;
    public void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException;
    
}
