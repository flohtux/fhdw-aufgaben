
package model.visitor;
import model.UserException;
import persistence.*;

public interface CurrencyReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleEuro(PersistentEuro euro) throws PersistenceException, E;
    public R handleYen(PersistentYen yen) throws PersistenceException, E;
    public R handlePfund(PersistentPfund pfund) throws PersistenceException, E;
    public R handleDollar(PersistentDollar dollar) throws PersistenceException, E;
    public R handleFranken(PersistentFranken franken) throws PersistenceException, E;
    
}
