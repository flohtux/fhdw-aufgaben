package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TransferProxi extends DebitTransferProxi implements TransferView{
    
    public TransferProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public TransferView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Date timestamp = (java.util.Date)resultTable.get("timestamp");
        String subject = (String)resultTable.get("subject");
        ViewProxi sender = null;
        String sender$String = (String)resultTable.get("sender");
        if (sender$String != null) {
            common.ProxiInformation sender$Info = common.RPCConstantsAndServices.createProxiInformation(sender$String);
            sender = view.objects.ViewProxi.createProxi(sender$Info,connectionKey);
            sender.setToString(sender$Info.getToString());
        }
        ViewProxi state = null;
        String state$String = (String)resultTable.get("state");
        if (state$String != null) {
            common.ProxiInformation state$Info = common.RPCConstantsAndServices.createProxiInformation(state$String);
            state = view.objects.ViewProxi.createProxi(state$Info,connectionKey);
            state.setToString(state$Info.getToString());
        }
        long receiverAccountNumber = new Long((String)resultTable.get("receiverAccountNumber")).longValue();
        long receiverBankNumber = new Long((String)resultTable.get("receiverBankNumber")).longValue();
        ViewProxi receiver = null;
        String receiver$String = (String)resultTable.get("receiver");
        if (receiver$String != null) {
            common.ProxiInformation receiver$Info = common.RPCConstantsAndServices.createProxiInformation(receiver$String);
            receiver = view.objects.ViewProxi.createProxi(receiver$Info,connectionKey);
            receiver.setToString(receiver$Info.getToString());
        }
        ViewProxi money = null;
        String money$String = (String)resultTable.get("money");
        if (money$String != null) {
            common.ProxiInformation money$Info = common.RPCConstantsAndServices.createProxiInformation(money$String);
            money = view.objects.ViewProxi.createProxi(money$Info,connectionKey);
            money.setToString(money$Info.getToString());
        }
        ViewProxi invokerTrigger = null;
        String invokerTrigger$String = (String)resultTable.get("invokerTrigger");
        if (invokerTrigger$String != null) {
            common.ProxiInformation invokerTrigger$Info = common.RPCConstantsAndServices.createProxiInformation(invokerTrigger$String);
            invokerTrigger = view.objects.ViewProxi.createProxi(invokerTrigger$Info,connectionKey);
            invokerTrigger.setToString(invokerTrigger$Info.getToString());
        }
        java.util.Vector<String> nextDebitTransferTransactionstriggers_string = (java.util.Vector<String>)resultTable.get("nextDebitTransferTransactionstriggers");
        java.util.Vector<DebitTransferTransactionView> nextDebitTransferTransactionstriggers = ViewProxi.getProxiVector(nextDebitTransferTransactionstriggers_string, connectionKey);
        ViewProxi previousDebitTransfer = null;
        String previousDebitTransfer$String = (String)resultTable.get("previousDebitTransfer");
        if (previousDebitTransfer$String != null) {
            common.ProxiInformation previousDebitTransfer$Info = common.RPCConstantsAndServices.createProxiInformation(previousDebitTransfer$String);
            previousDebitTransfer = view.objects.ViewProxi.createProxi(previousDebitTransfer$Info,connectionKey);
            previousDebitTransfer.setToString(previousDebitTransfer$Info.getToString());
        }
        TransferView result$$ = new Transfer((java.util.Date)timestamp,(String)subject,(AccountView)sender,(DebitTransferStateView)state,(long)receiverAccountNumber,(long)receiverBankNumber,(AccountView)receiver,(MoneyView)money,(TriggerValueView)invokerTrigger,nextDebitTransferTransactionstriggers,(DebitTransferNoValue)previousDebitTransfer, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    
    public void accept(DebitTransferVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitTransferReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitTransferExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(DebitTransferTransactionVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(DebitTransferNoValueVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitTransferNoValueReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitTransferNoValueExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitTransferNoValueReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
