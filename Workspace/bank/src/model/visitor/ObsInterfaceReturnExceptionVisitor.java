
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObsInterfaceReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    
}
