
package view.visitor;

import view.*;

public interface LimitTypeReturnVisitor<R> {
    
    public R handleNoLimit(NoLimitView noLimit) throws ModelException;
    public R handleLimit(LimitView limit) throws ModelException;
    
}
