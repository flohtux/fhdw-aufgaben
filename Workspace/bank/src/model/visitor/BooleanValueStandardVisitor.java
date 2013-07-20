
package model.visitor;

import persistence.*;

public abstract class BooleanValueStandardVisitor implements BooleanValueVisitor {
    
    public void handleFalseValue(PersistentFalseValue falseValue) throws PersistenceException{
        this.standardHandling(falseValue);
    }
    public void handleTrueValue(PersistentTrueValue trueValue) throws PersistenceException{
        this.standardHandling(trueValue);
    }
    protected abstract void standardHandling(PersistentBooleanValue booleanValue) throws PersistenceException;
}
