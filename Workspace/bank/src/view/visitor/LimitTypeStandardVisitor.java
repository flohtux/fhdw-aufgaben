
package view.visitor;

import view.*;

public abstract class LimitTypeStandardVisitor implements LimitTypeVisitor {
    
    public void handleNoLimit(NoLimitView noLimit) throws ModelException{
        this.standardHandling(noLimit);
    }
    public void handleLimit(LimitView limit) throws ModelException{
        this.standardHandling(limit);
    }
    protected abstract void standardHandling(LimitTypeView limitType) throws ModelException;
}
