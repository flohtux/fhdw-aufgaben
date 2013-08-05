package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TransferProxi extends DebitNoteTransferProxi implements TransferView{
    
    public TransferProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public TransferView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Date timestamp = (java.util.Date)resultTable.get("timestamp");
        long receiverAccountNumber = new Long((String)resultTable.get("receiverAccountNumber")).longValue();
        long receiverBankNumber = new Long((String)resultTable.get("receiverBankNumber")).longValue();
        ViewProxi sender = null;
        String sender$String = (String)resultTable.get("sender");
        if (sender$String != null) {
            common.ProxiInformation sender$Info = common.RPCConstantsAndServices.createProxiInformation(sender$String);
            sender = view.objects.ViewProxi.createProxi(sender$Info,connectionKey);
            sender.setToString(sender$Info.getToString());
        }
        ViewProxi money = null;
        String money$String = (String)resultTable.get("money");
        if (money$String != null) {
            common.ProxiInformation money$Info = common.RPCConstantsAndServices.createProxiInformation(money$String);
            money = view.objects.ViewProxi.createProxi(money$Info,connectionKey);
            money.setToString(money$Info.getToString());
        }
        ViewProxi state = null;
        String state$String = (String)resultTable.get("state");
        if (state$String != null) {
            common.ProxiInformation state$Info = common.RPCConstantsAndServices.createProxiInformation(state$String);
            state = view.objects.ViewProxi.createProxi(state$Info,connectionKey);
            state.setToString(state$Info.getToString());
        }
        ViewProxi stornoState = null;
        String stornoState$String = (String)resultTable.get("stornoState");
        if (stornoState$String != null) {
            common.ProxiInformation stornoState$Info = common.RPCConstantsAndServices.createProxiInformation(stornoState$String);
            stornoState = view.objects.ViewProxi.createProxi(stornoState$Info,connectionKey);
            stornoState.setToString(stornoState$Info.getToString());
        }
        TransferView result$$ = new Transfer((java.util.Date)timestamp,(long)receiverAccountNumber,(long)receiverBankNumber,(AccountView)sender,(MoneyView)money,(DebitNoteTransferStateView)state,(StornoStateView)stornoState, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getState() != null) return new StateDebitNoteTransferWrapper(this, originalIndex, (ViewRoot)this.getState());
        if(this.getState() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getState() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getState() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getState() != null && this.getState().equals(child)) return result;
        if(this.getState() != null) result = result + 1;
        return -1;
    }
    
    
    public void accept(DebitNoteTransferVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitNoteTransferReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(DebitNoteTransferTransactionVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitNoteTransferTransactionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferTransactionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
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
