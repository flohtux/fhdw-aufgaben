
package model.visitor;
import model.UserException;
import persistence.*;

public interface CurrencyReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleEuro(PersistentEuro euro) throws PersistenceException, E;
    public R handleDollar(PersistentDollar dollar) throws PersistenceException, E;
    
}
