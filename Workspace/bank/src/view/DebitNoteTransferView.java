package view;

import view.visitor.*;

public interface DebitNoteTransferView extends DebitNoteTransferTransactionView {
    
    public long getReceiverAccountNumber()throws ModelException;
    public void setReceiverAccountNumber(long newValue) throws ModelException ;
    public long getReceiverBankNumber()throws ModelException;
    public void setReceiverBankNumber(long newValue) throws ModelException ;
    public AccountView getSender()throws ModelException;
    public void setSender(AccountView newValue) throws ModelException ;
    public MoneyView getMoney()throws ModelException;
    public void setMoney(MoneyView newValue) throws ModelException ;
    public DebitNoteTransferStateView getState()throws ModelException;
    public void setState(DebitNoteTransferStateView newValue) throws ModelException ;
    public StornoStateView getStornoState()throws ModelException;
    public void setStornoState(StornoStateView newValue) throws ModelException ;
    
    public void accept(DebitNoteTransferVisitor visitor) throws ModelException;
    public <R> R accept(DebitNoteTransferReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitNoteTransferExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitNoteTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

