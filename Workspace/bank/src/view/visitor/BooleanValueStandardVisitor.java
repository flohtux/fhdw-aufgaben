
package view.visitor;

import view.*;

public abstract class BooleanValueStandardVisitor implements BooleanValueVisitor {
    
    public void handleFalseValue(FalseValueView falseValue) throws ModelException{
        this.standardHandling(falseValue);
    }
    public void handleTrueValue(TrueValueView trueValue) throws ModelException{
        this.standardHandling(trueValue);
    }
    protected abstract void standardHandling(BooleanValueView booleanValue) throws ModelException;
}
