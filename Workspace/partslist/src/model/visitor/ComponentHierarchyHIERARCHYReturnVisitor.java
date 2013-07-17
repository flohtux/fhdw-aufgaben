
package model.visitor;

import persistence.*;

public interface ComponentHierarchyHIERARCHYReturnVisitor<R> extends ComponentReturnVisitor<R> {
    
    public R handleQPart(PersistentQPart qPart) throws PersistenceException;
    
}
