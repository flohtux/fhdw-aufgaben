package view;

import view.visitor.*;

public interface DebitTransferView extends DebitTransferNoValue, DebitTransferTransactionView {
    
    public long getReceiverAccountNumber()throws ModelException;
    public void setReceiverAccountNumber(long newValue) throws ModelException ;
    public long getReceiverBankNumber()throws ModelException;
    public void setReceiverBankNumber(long newValue) throws ModelException ;
    public AccountView getReceiver()throws ModelException;
    public void setReceiver(AccountView newValue) throws ModelException ;
    public MoneyView getMoney()throws ModelException;
    public void setMoney(MoneyView newValue) throws ModelException ;
    public TriggerValueView getInvokerTrigger()throws ModelException;
    public void setInvokerTrigger(TriggerValueView newValue) throws ModelException ;
    public java.util.Vector<DebitTransferTransactionView> getNextDebitTransferTransactionstriggers()throws ModelException;
    public void setNextDebitTransferTransactionstriggers(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException ;
    public DebitTransferNoValue getPreviousDebitTransfer()throws ModelException;
    public void setPreviousDebitTransfer(DebitTransferNoValue newValue) throws ModelException ;
    
    public void accept(DebitTransferVisitor visitor) throws ModelException;
    public <R> R accept(DebitTransferReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitTransferExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

