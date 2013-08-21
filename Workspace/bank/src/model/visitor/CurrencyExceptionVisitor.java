
package model.visitor;
import model.UserException;
import persistence.*;

public interface CurrencyExceptionVisitor<E extends UserException> {
    
    public void handleDollar(PersistentDollar dollar) throws PersistenceException, E;
    public void handleFranken(PersistentFranken franken) throws PersistenceException, E;
    public void handleEuro(PersistentEuro euro) throws PersistenceException, E;
    public void handleYen(PersistentYen yen) throws PersistenceException, E;
    public void handlePfund(PersistentPfund pfund) throws PersistenceException, E;
    
}
