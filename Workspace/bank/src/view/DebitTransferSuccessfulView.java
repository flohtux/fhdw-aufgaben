package view;

import view.objects.*;

import view.visitor.*;

public interface DebitTransferSuccessfulView extends Anything, AbstractViewRoot {
    
    public java.util.Vector<DebitTransferTransactionView> getSuccessfuls()throws ModelException;
    public void setSuccessfuls(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

