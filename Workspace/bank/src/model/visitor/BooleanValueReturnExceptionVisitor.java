
package model.visitor;
import model.UserException;
import persistence.*;

public interface BooleanValueReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleFalseValue(PersistentFalseValue falseValue) throws PersistenceException, E;
    public R handleTrueValue(PersistentTrueValue trueValue) throws PersistenceException, E;
    
}
