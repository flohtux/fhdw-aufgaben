package view;

import view.visitor.*;

public interface DebitNoteTransferView extends DebitNoteTransferTransactionView {
    
    public AccountView getSender()throws ModelException;
    public void setSender(AccountView newValue) throws ModelException ;
    public AccountView getReceiver()throws ModelException;
    public void setReceiver(AccountView newValue) throws ModelException ;
    public MoneyView getMoney()throws ModelException;
    public void setMoney(MoneyView newValue) throws ModelException ;
    
    public void accept(DebitNoteTransferVisitor visitor) throws ModelException;
    public <R> R accept(DebitNoteTransferReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitNoteTransferExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitNoteTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

