package view;

import view.visitor.*;

public interface DebitTransferView extends DebitTransferTransactionView {
    
    public long getReceiverAccountNumber()throws ModelException;
    public void setReceiverAccountNumber(long newValue) throws ModelException ;
    public long getReceiverBankNumber()throws ModelException;
    public void setReceiverBankNumber(long newValue) throws ModelException ;
    public MoneyView getMoney()throws ModelException;
    public void setMoney(MoneyView newValue) throws ModelException ;
    public String getSubject()throws ModelException;
    public void setSubject(String newValue) throws ModelException ;
    public StornoStateView getStornoState()throws ModelException;
    public void setStornoState(StornoStateView newValue) throws ModelException ;
    
    public void accept(DebitTransferVisitor visitor) throws ModelException;
    public <R> R accept(DebitTransferReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitTransferExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

