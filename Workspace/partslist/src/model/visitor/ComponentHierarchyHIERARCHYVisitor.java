
package model.visitor;

import persistence.*;

public interface ComponentHierarchyHIERARCHYVisitor extends ComponentVisitor{
    
    public void handleQPart(PersistentQPart qPart) throws PersistenceException;
    
}
