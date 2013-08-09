
package model.visitor;

import persistence.*;

public abstract class CurrencyStandardVisitor implements CurrencyVisitor {
    
    public void handleDollar(PersistentDollar dollar) throws PersistenceException{
        this.standardHandling(dollar);
    }
    public void handleFranken(PersistentFranken franken) throws PersistenceException{
        this.standardHandling(franken);
    }
    public void handlePfund(PersistentPfund pfund) throws PersistenceException{
        this.standardHandling(pfund);
    }
    public void handleEuro(PersistentEuro euro) throws PersistenceException{
        this.standardHandling(euro);
    }
    public void handleYen(PersistentYen yen) throws PersistenceException{
        this.standardHandling(yen);
    }
    protected abstract void standardHandling(PersistentCurrency currency) throws PersistenceException;
}
