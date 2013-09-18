package view.objects;

import view.DebitTransferTransactionView;
import view.DebitTransferView;
import view.ModelException;
import view.MoneyView;
import view.StornoStateView;
import view.TriggerValueView;
import viewClient.ExceptionAndEventHandler;

public abstract class DebitTransferProxi extends DebitTransferTransactionProxi implements DebitTransferView{
    
    public DebitTransferProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public long getReceiverAccountNumber()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getReceiverAccountNumber();
    }
    public void setReceiverAccountNumber(long newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setReceiverAccountNumber(newValue);
    }
    public long getReceiverBankNumber()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getReceiverBankNumber();
    }
    public void setReceiverBankNumber(long newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setReceiverBankNumber(newValue);
    }
    public MoneyView getMoney()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getMoney();
    }
    public void setMoney(MoneyView newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setMoney(newValue);
    }
    public TriggerValueView getInvokerTrigger()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getInvokerTrigger();
    }
    public void setInvokerTrigger(TriggerValueView newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setInvokerTrigger(newValue);
    }
    public java.util.Vector<DebitTransferTransactionView> getNextDebitTransferTransactionstriggers()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getNextDebitTransferTransactionstriggers();
    }
    public void setNextDebitTransferTransactionstriggers(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setNextDebitTransferTransactionstriggers(newValue);
    }
    public DebitTransferView getPreviousDebitTransfer()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getPreviousDebitTransfer();
    }
    public void setPreviousDebitTransfer(DebitTransferView newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setPreviousDebitTransfer(newValue);
    }
    public StornoStateView getStornoState()throws ModelException{
        return ((DebitTransfer)this.getTheObject()).getStornoState();
    }
    public void setStornoState(StornoStateView newValue) throws ModelException {
        ((DebitTransfer)this.getTheObject()).setStornoState(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
