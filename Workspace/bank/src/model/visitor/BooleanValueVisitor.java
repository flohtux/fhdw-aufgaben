
package model.visitor;

import persistence.*;

public interface BooleanValueVisitor {
    
    public void handleFalseValue(PersistentFalseValue falseValue) throws PersistenceException;
    public void handleTrueValue(PersistentTrueValue trueValue) throws PersistenceException;
    
}
