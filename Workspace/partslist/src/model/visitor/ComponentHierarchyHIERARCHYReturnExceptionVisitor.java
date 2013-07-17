
package model.visitor;
import model.UserException;
import persistence.*;

public interface ComponentHierarchyHIERARCHYReturnExceptionVisitor<R, E extends UserException> extends ComponentReturnExceptionVisitor<R, E> {
    
    public R handleQPart(PersistentQPart qPart) throws PersistenceException, E;
    
}
