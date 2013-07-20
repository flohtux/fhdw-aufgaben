
package view.visitor;
import view.UserException;
import view.*;

public interface BooleanValueReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleFalseValue(FalseValueView falseValue) throws ModelException, E;
    public R handleTrueValue(TrueValueView trueValue) throws ModelException, E;
    
}
