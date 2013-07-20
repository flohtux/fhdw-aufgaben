
package view.visitor;
import view.UserException;
import view.*;

public interface BooleanValueExceptionVisitor<E extends UserException> {
    
    public void handleFalseValue(FalseValueView falseValue) throws ModelException, E;
    public void handleTrueValue(TrueValueView trueValue) throws ModelException, E;
    
}
