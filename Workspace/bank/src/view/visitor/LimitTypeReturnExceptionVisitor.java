
package view.visitor;
import view.UserException;
import view.*;

public interface LimitTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleNoLimit(NoLimitView noLimit) throws ModelException, E;
    public R handleLimit(LimitView limit) throws ModelException, E;
    
}
