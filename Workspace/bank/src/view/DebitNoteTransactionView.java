package view;

import view.objects.*;

import view.visitor.*;

public interface DebitNoteTransactionView extends Anything, AbstractViewRoot {
    
    public long getBankNumber()throws ModelException;
    public void setBankNumber(long newValue) throws ModelException ;
    public long getAccountNumber()throws ModelException;
    public void setAccountNumber(long newValue) throws ModelException ;
    public MoneyView getMoney()throws ModelException;
    public void setMoney(MoneyView newValue) throws ModelException ;
    
    public void accept(DebitNoteTransactionVisitor visitor) throws ModelException;
    public <R> R accept(DebitNoteTransactionReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitNoteTransactionExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitNoteTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

