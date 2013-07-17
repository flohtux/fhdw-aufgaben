
package model.visitor;

import persistence.*;

public interface ObsInterfaceVisitor {
    
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    
}
