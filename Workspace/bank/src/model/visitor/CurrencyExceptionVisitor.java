
package model.visitor;
import model.UserException;
import persistence.*;

public interface CurrencyExceptionVisitor<E extends UserException> {
    
    public void handleEuro(PersistentEuro euro) throws PersistenceException, E;
    public void handleDollar(PersistentDollar dollar) throws PersistenceException, E;
    
}
