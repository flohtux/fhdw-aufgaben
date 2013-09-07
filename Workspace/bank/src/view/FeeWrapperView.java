package view;

import view.objects.*;

import view.visitor.*;

public interface FeeWrapperView extends Anything, AbstractViewRoot {
    
    public TransactionFeeView getFee()throws ModelException;
    public void setFee(TransactionFeeView newValue) throws ModelException ;
    public InternalFeeView getInternalFee()throws ModelException;
    public void setInternalFee(InternalFeeView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

