
package model.visitor;

import persistence.*;

public interface BooleanValueReturnVisitor<R> {
    
    public R handleFalseValue(PersistentFalseValue falseValue) throws PersistenceException;
    public R handleTrueValue(PersistentTrueValue trueValue) throws PersistenceException;
    
}
