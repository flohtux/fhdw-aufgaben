
package view.visitor;

import view.*;

public interface BooleanValueVisitor {
    
    public void handleFalseValue(FalseValueView falseValue) throws ModelException;
    public void handleTrueValue(TrueValueView trueValue) throws ModelException;
    
}
