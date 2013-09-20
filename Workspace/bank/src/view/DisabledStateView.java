package view;

import view.visitor.*;

public interface DisabledStateView extends TriggerStateView {
    
    
    public void accept(TriggerStateVisitor visitor) throws ModelException;
    public <R> R accept(TriggerStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(TriggerStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(TriggerStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

