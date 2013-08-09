
package model.visitor;

import persistence.*;

public interface CurrencyReturnVisitor<R> {
    
    public R handleEuro(PersistentEuro euro) throws PersistenceException;
    public R handleYen(PersistentYen yen) throws PersistenceException;
    public R handlePfund(PersistentPfund pfund) throws PersistenceException;
    public R handleDollar(PersistentDollar dollar) throws PersistenceException;
    public R handleFranken(PersistentFranken franken) throws PersistenceException;
    
}
