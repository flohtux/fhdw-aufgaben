package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class SuccessfullStateProxi extends DebitNoteTransferStateProxi implements SuccessfullStateView{
    
    public SuccessfullStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public SuccessfullStateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
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
        ViewProxi debitNoteTransfer = null;
        String debitNoteTransfer$String = (String)resultTable.get("debitNoteTransfer");
        if (debitNoteTransfer$String != null) {
            common.ProxiInformation debitNoteTransfer$Info = common.RPCConstantsAndServices.createProxiInformation(debitNoteTransfer$String);
            debitNoteTransfer = view.objects.ViewProxi.createProxi(debitNoteTransfer$Info,connectionKey);
            debitNoteTransfer.setToString(debitNoteTransfer$Info.getToString());
        }
        SuccessfullStateView result$$ = new SuccessfullState((DebitNoteTransferStateView)state,(StornoStateView)stornoState,(DebitNoteTransferStateView)debitNoteTransfer, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getState() != null) return new StateDebitNoteTransferStateWrapper(this, originalIndex, (ViewRoot)this.getState());
        if(this.getState() != null) index = index - 1;
        if(index == 0 && this.getStornoState() != null) return new StornoStateDebitNoteTransferStateWrapper(this, originalIndex, (ViewRoot)this.getStornoState());
        if(this.getStornoState() != null) index = index - 1;
        if(index == 0 && this.getDebitNoteTransfer() != null) return new DebitNoteTransferDebitNoteTransferStateWrapper(this, originalIndex, (ViewRoot)this.getDebitNoteTransfer());
        if(this.getDebitNoteTransfer() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getState() == null ? 0 : 1)
            + (this.getStornoState() == null ? 0 : 1)
            + (this.getDebitNoteTransfer() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getState() == null ? true : false)
            && (this.getStornoState() == null ? true : false)
            && (this.getDebitNoteTransfer() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getState() != null && this.getState().equals(child)) return result;
        if(this.getState() != null) result = result + 1;
        if(this.getStornoState() != null && this.getStornoState().equals(child)) return result;
        if(this.getStornoState() != null) result = result + 1;
        if(this.getDebitNoteTransfer() != null && this.getDebitNoteTransfer().equals(child)) return result;
        if(this.getDebitNoteTransfer() != null) result = result + 1;
        return -1;
    }
    
    
    public void accept(DebitNoteTransferStateVisitor visitor) throws ModelException {
        visitor.handleSuccessfullState(this);
    }
    public <R> R accept(DebitNoteTransferStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSuccessfullState(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSuccessfullState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleSuccessfullState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSuccessfullState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSuccessfullState(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
