package view;

import view.objects.AbstractViewRoot;
import view.visitor.TriggerValueExceptionVisitor;
import view.visitor.TriggerValueReturnExceptionVisitor;
import view.visitor.TriggerValueReturnVisitor;
import view.visitor.TriggerValueVisitor;

public interface TriggerValueView extends Anything, AbstractViewRoot {
    
    
    public void accept(TriggerValueVisitor visitor) throws ModelException;
    public <R> R accept(TriggerValueReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(TriggerValueExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(TriggerValueReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

