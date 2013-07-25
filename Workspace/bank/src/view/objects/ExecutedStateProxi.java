package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ExecutedStateProxi extends DebitNoteTransferStateProxi implements ExecutedStateView{
    
    public ExecutedStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public ExecutedStateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi debitNoteTransfer = null;
        String debitNoteTransfer$String = (String)resultTable.get("debitNoteTransfer");
        if (debitNoteTransfer$String != null) {
            common.ProxiInformation debitNoteTransfer$Info = common.RPCConstantsAndServices.createProxiInformation(debitNoteTransfer$String);
            debitNoteTransfer = view.objects.ViewProxi.createProxi(debitNoteTransfer$Info,connectionKey);
            debitNoteTransfer.setToString(debitNoteTransfer$Info.getToString());
        }
        ExecutedStateView result$$ = new ExecutedState((DebitNoteTransferView)debitNoteTransfer, this.getId(), this.getClassId());
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
    
    
    public void accept(DebitNoteTransferStateVisitor visitor) throws ModelException {
        visitor.handleExecutedState(this);
    }
    public <R> R accept(DebitNoteTransferStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleExecutedState(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleExecutedState(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleExecutedState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleExecutedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleExecutedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleExecutedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleExecutedState(this);
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
