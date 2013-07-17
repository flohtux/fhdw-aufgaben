
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObsInterfaceExceptionVisitor<E extends UserException> {
    
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    
}
