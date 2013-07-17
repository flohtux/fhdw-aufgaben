
package model.visitor;

import persistence.*;

public abstract class CurrencyStandardVisitor implements CurrencyVisitor {
    
    public void handleDollar(PersistentDollar dollar) throws PersistenceException{
        this.standardHandling(dollar);
    }
    public void handleEuro(PersistentEuro euro) throws PersistenceException{
        this.standardHandling(euro);
    }
    protected abstract void standardHandling(PersistentCurrency currency) throws PersistenceException;
}
