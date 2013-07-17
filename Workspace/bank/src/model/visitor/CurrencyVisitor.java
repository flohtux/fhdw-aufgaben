
package model.visitor;

import persistence.*;

public interface CurrencyVisitor {
    
    public void handleEuro(PersistentEuro euro) throws PersistenceException;
    public void handleDollar(PersistentDollar dollar) throws PersistenceException;
    
}
