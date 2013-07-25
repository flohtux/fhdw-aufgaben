package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class NotSuccessfullStateProxi extends DebitNoteTransferStateProxi implements NotSuccessfullStateView{
    
    public NotSuccessfullStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public NotSuccessfullStateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi debitNoteTransfer = null;
        String debitNoteTransfer$String = (String)resultTable.get("debitNoteTransfer");
        if (debitNoteTransfer$String != null) {
            common.ProxiInformation debitNoteTransfer$Info = common.RPCConstantsAndServices.createProxiInformation(debitNoteTransfer$String);
            debitNoteTransfer = view.objects.ViewProxi.createProxi(debitNoteTransfer$Info,connectionKey);
            debitNoteTransfer.setToString(debitNoteTransfer$Info.getToString());
        }
        NotSuccessfullStateView result$$ = new NotSuccessfullState((DebitNoteTransferView)debitNoteTransfer, this.getId(), this.getClassId());
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
        visitor.handleNotSuccessfullState(this);
    }
    public <R> R accept(DebitNoteTransferStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotSuccessfullState(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotSuccessfullState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNotSuccessfullState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotSuccessfullState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotSuccessfullState(this);
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
