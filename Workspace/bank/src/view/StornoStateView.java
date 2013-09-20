package view;

import view.objects.AbstractViewRoot;
import view.visitor.StornoStateExceptionVisitor;
import view.visitor.StornoStateReturnExceptionVisitor;
import view.visitor.StornoStateReturnVisitor;
import view.visitor.StornoStateVisitor;

public interface StornoStateView extends Anything, AbstractViewRoot {
    
    public CompensationView getDebitTransfer()throws ModelException;
    
    public void accept(StornoStateVisitor visitor) throws ModelException;
    public <R> R accept(StornoStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(StornoStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(StornoStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

