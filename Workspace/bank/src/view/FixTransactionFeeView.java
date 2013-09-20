package view;

import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.TransactionFeeExceptionVisitor;
import view.visitor.TransactionFeeReturnExceptionVisitor;
import view.visitor.TransactionFeeReturnVisitor;
import view.visitor.TransactionFeeVisitor;

public interface FixTransactionFeeView extends TransactionFeeView {
    
    public MoneyView getValue()throws ModelException;
    public void setValue(MoneyView newValue) throws ModelException ;
    
    public void accept(TransactionFeeVisitor visitor) throws ModelException;
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

