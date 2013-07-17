
package model.visitor;
import model.UserException;
import persistence.*;

public interface ComponentHierarchyHIERARCHYExceptionVisitor<E extends UserException> extends ComponentExceptionVisitor<E>{
    
    public void handleQPart(PersistentQPart qPart) throws PersistenceException, E;
    
}
