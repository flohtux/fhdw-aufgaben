
package model.visitor;
import model.UserException;
import persistence.*;

public interface BooleanValueExceptionVisitor<E extends UserException> {
    
    public void handleFalseValue(PersistentFalseValue falseValue) throws PersistenceException, E;
    public void handleTrueValue(PersistentTrueValue trueValue) throws PersistenceException, E;
    
}
