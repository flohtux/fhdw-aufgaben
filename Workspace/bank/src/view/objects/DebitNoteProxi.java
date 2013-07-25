package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class DebitNoteProxi extends DebitNoteTransferProxi implements DebitNoteView{
    
    public DebitNoteProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public DebitNoteView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
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
        DebitNoteView result$$ = new DebitNote((long)receiverAccountNumber,(long)receiverBankNumber,(AccountView)sender,(MoneyView)money,(DebitNoteTransferStateView)state,(StornoStateView)stornoState, this.getId(), this.getClassId());
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
    
    
    public void accept(DebitNoteTransferVisitor visitor) throws ModelException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(DebitNoteTransferReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitNote(this);
    }
    public void accept(DebitNoteTransferTransactionVisitor visitor) throws ModelException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(DebitNoteTransferTransactionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferTransactionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitNote(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitNote(this);
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
