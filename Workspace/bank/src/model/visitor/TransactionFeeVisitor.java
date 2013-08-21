
package model.visitor;

import persistence.*;

public interface TransactionFeeVisitor {
    
    public void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException;
    public void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException;
    public void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException;
    
}
