package view;

import view.visitor.*;

public interface NoRequestStateView extends StornoStateView {
    
    
    public void accept(StornoStateVisitor visitor) throws ModelException;
    public <R> R accept(StornoStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(StornoStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(StornoStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

