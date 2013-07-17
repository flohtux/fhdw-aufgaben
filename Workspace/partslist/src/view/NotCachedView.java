package view;

import view.visitor.*;

public interface NotCachedView extends StateView {
    
    
    public void accept(StateVisitor visitor) throws ModelException;
    public <R> R accept(StateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(StateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(StateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

