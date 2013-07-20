
package view.visitor;

import view.*;

public interface LimitTypeVisitor {
    
    public void handleNoLimit(NoLimitView noLimit) throws ModelException;
    public void handleLimit(LimitView limit) throws ModelException;
    
}
