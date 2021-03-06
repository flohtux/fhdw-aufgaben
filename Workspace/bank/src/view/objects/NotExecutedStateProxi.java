package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class NotExecutedStateProxi extends DebitTransferStateProxi implements NotExecutedStateView{
    
    public NotExecutedStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public NotExecutedStateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi debitTransfer = null;
        String debitTransfer$String = (String)resultTable.get("debitTransfer");
        if (debitTransfer$String != null) {
            common.ProxiInformation debitTransfer$Info = common.RPCConstantsAndServices.createProxiInformation(debitTransfer$String);
            debitTransfer = view.objects.ViewProxi.createProxi(debitTransfer$Info,connectionKey);
            debitTransfer.setToString(debitTransfer$Info.getToString());
        }
        NotExecutedStateView result$$ = new NotExecutedState((DebitTransferTransactionView)debitTransfer, this.getId(), this.getClassId());
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
    
    
    public void accept(DebitTransferStateVisitor visitor) throws ModelException {
        visitor.handleNotExecutedState(this);
    }
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotExecutedState(this);
    }
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotExecutedState(this);
    }
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotExecutedState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNotExecutedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotExecutedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotExecutedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotExecutedState(this);
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
