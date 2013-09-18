package view.objects;

import view.AccountView;
import view.DebitTransferStateView;
import view.DebitTransferTransactionView;
import view.DebitTransferView;
import view.ModelException;
import view.MoneyView;
import view.StornoStateView;
import view.TransferView;
import view.TriggerValueView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.DebitTransferExceptionVisitor;
import view.visitor.DebitTransferReturnExceptionVisitor;
import view.visitor.DebitTransferReturnVisitor;
import view.visitor.DebitTransferTransactionExceptionVisitor;
import view.visitor.DebitTransferTransactionReturnExceptionVisitor;
import view.visitor.DebitTransferTransactionReturnVisitor;
import view.visitor.DebitTransferTransactionVisitor;
import view.visitor.DebitTransferVisitor;
import viewClient.ExceptionAndEventHandler;

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
        ViewProxi stornoState = null;
        String stornoState$String = (String)resultTable.get("stornoState");
        if (stornoState$String != null) {
            common.ProxiInformation stornoState$Info = common.RPCConstantsAndServices.createProxiInformation(stornoState$String);
            stornoState = view.objects.ViewProxi.createProxi(stornoState$Info,connectionKey);
            stornoState.setToString(stornoState$Info.getToString());
        }
        TransferView result$$ = new Transfer((java.util.Date)timestamp,(String)subject,(AccountView)sender,(DebitTransferStateView)state,(long)receiverAccountNumber,(long)receiverBankNumber,(MoneyView)money,(TriggerValueView)invokerTrigger,nextDebitTransferTransactionstriggers,(DebitTransferView)previousDebitTransfer,(StornoStateView)stornoState, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getState() != null) return new StateDebitTransferTransactionWrapper(this, originalIndex, (ViewRoot)this.getState());
        if(this.getState() != null) index = index - 1;
        if(index == 0 && this.getInvokerTrigger() != null) return new InvokerTriggerDebitTransferWrapper(this, originalIndex, (ViewRoot)this.getInvokerTrigger());
        if(this.getInvokerTrigger() != null) index = index - 1;
        if(index < this.getNextDebitTransferTransactionstriggers().size()) return new NextDebitTransferTransactionstriggersDebitTransferWrapper(this, originalIndex, (ViewRoot)this.getNextDebitTransferTransactionstriggers().get(index));
        index = index - this.getNextDebitTransferTransactionstriggers().size();
        if(index == 0 && this.getPreviousDebitTransfer() != null) return new PreviousDebitTransferDebitTransferWrapper(this, originalIndex, (ViewRoot)this.getPreviousDebitTransfer());
        if(this.getPreviousDebitTransfer() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getState() == null ? 0 : 1)
            + (this.getInvokerTrigger() == null ? 0 : 1)
            + (this.getNextDebitTransferTransactionstriggers().size())
            + (this.getPreviousDebitTransfer() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getState() == null ? true : false)
            && (this.getInvokerTrigger() == null ? true : false)
            && (this.getNextDebitTransferTransactionstriggers().size() == 0)
            && (this.getPreviousDebitTransfer() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getState() != null && this.getState().equals(child)) return result;
        if(this.getState() != null) result = result + 1;
        if(this.getInvokerTrigger() != null && this.getInvokerTrigger().equals(child)) return result;
        if(this.getInvokerTrigger() != null) result = result + 1;
        java.util.Iterator<?> getNextDebitTransferTransactionstriggersIterator = this.getNextDebitTransferTransactionstriggers().iterator();
        while(getNextDebitTransferTransactionstriggersIterator.hasNext()){
            if(getNextDebitTransferTransactionstriggersIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getPreviousDebitTransfer() != null && this.getPreviousDebitTransfer().equals(child)) return result;
        if(this.getPreviousDebitTransfer() != null) result = result + 1;
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
