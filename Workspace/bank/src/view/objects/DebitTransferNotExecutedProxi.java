package view.objects;

import view.DebitTransferNotExecutedView;
import view.DebitTransferTransactionView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import viewClient.ExceptionAndEventHandler;

public class DebitTransferNotExecutedProxi extends ViewProxi implements DebitTransferNotExecutedView{
    
    public DebitTransferNotExecutedProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public DebitTransferNotExecutedView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> notExecuteds_string = (java.util.Vector<String>)resultTable.get("notExecuteds");
        java.util.Vector<DebitTransferTransactionView> notExecuteds = ViewProxi.getProxiVector(notExecuteds_string, connectionKey);
        DebitTransferNotExecutedView result$$ = new DebitTransferNotExecuted(notExecuteds, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getNotExecuteds().size()) return new NotExecutedsDebitTransferNotExecutedWrapper(this, originalIndex, (ViewRoot)this.getNotExecuteds().get(index));
        index = index - this.getNotExecuteds().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getNotExecuteds().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getNotExecuteds().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getNotExecutedsIterator = this.getNotExecuteds().iterator();
        while(getNotExecutedsIterator.hasNext()){
            if(getNotExecutedsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<DebitTransferTransactionView> getNotExecuteds()throws ModelException{
        return ((DebitTransferNotExecuted)this.getTheObject()).getNotExecuteds();
    }
    public void setNotExecuteds(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        ((DebitTransferNotExecuted)this.getTheObject()).setNotExecuteds(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferNotExecuted(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferNotExecuted(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferNotExecuted(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferNotExecuted(this);
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
