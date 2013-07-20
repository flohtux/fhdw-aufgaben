
package view.visitor;
import view.UserException;
import view.*;

public interface LimitTypeExceptionVisitor<E extends UserException> {
    
    public void handleNoLimit(NoLimitView noLimit) throws ModelException, E;
    public void handleLimit(LimitView limit) throws ModelException, E;
    
}
