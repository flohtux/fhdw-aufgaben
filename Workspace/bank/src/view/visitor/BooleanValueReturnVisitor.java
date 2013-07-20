
package view.visitor;

import view.*;

public interface BooleanValueReturnVisitor<R> {
    
    public R handleFalseValue(FalseValueView falseValue) throws ModelException;
    public R handleTrueValue(TrueValueView trueValue) throws ModelException;
    
}
