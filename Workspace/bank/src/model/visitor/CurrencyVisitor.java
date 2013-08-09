
package model.visitor;

import persistence.*;

public interface CurrencyVisitor {
    
    public void handleEuro(PersistentEuro euro) throws PersistenceException;
    public void handleYen(PersistentYen yen) throws PersistenceException;
    public void handlePfund(PersistentPfund pfund) throws PersistenceException;
    public void handleDollar(PersistentDollar dollar) throws PersistenceException;
    public void handleFranken(PersistentFranken franken) throws PersistenceException;
    
}
