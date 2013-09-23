package view;

import view.objects.*;

import view.visitor.*;

public interface NoDebitTransferView extends Anything, DebitTransferNoValue, AbstractViewRoot {
    
    
    public void accept(DebitTransferNoValueVisitor visitor) throws ModelException;
    public <R> R accept(DebitTransferNoValueReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitTransferNoValueExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitTransferNoValueReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

