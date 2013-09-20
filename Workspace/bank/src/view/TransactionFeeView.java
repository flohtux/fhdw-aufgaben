package view;

import view.objects.AbstractViewRoot;
import view.visitor.TransactionFeeExceptionVisitor;
import view.visitor.TransactionFeeReturnExceptionVisitor;
import view.visitor.TransactionFeeReturnVisitor;
import view.visitor.TransactionFeeVisitor;

public interface TransactionFeeView extends Anything, AbstractViewRoot {
    
    
    public void accept(TransactionFeeVisitor visitor) throws ModelException;
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

