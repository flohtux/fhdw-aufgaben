package view;

import view.visitor.*;

public interface NoTriggerView extends TriggerValueView {
    
    
    public void accept(TriggerValueVisitor visitor) throws ModelException;
    public <R> R accept(TriggerValueReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(TriggerValueExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(TriggerValueReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

