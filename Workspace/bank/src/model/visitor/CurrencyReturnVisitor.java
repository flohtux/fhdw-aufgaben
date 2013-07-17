
package model.visitor;

import persistence.*;

public interface CurrencyReturnVisitor<R> {
    
    public R handleEuro(PersistentEuro euro) throws PersistenceException;
    public R handleDollar(PersistentDollar dollar) throws PersistenceException;
    
}
