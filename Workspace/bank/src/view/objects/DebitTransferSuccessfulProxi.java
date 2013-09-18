package view.objects;

import view.DebitTransferSuccessfulView;
import view.DebitTransferTransactionView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import viewClient.ExceptionAndEventHandler;

public class DebitTransferSuccessfulProxi extends ViewProxi implements DebitTransferSuccessfulView{
    
    public DebitTransferSuccessfulProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public DebitTransferSuccessfulView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> successfuls_string = (java.util.Vector<String>)resultTable.get("successfuls");
        java.util.Vector<DebitTransferTransactionView> successfuls = ViewProxi.getProxiVector(successfuls_string, connectionKey);
        DebitTransferSuccessfulView result$$ = new DebitTransferSuccessful(successfuls, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getSuccessfuls().size()) return new SuccessfulsDebitTransferSuccessfulWrapper(this, originalIndex, (ViewRoot)this.getSuccessfuls().get(index));
        index = index - this.getSuccessfuls().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSuccessfuls().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getSuccessfuls().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getSuccessfulsIterator = this.getSuccessfuls().iterator();
        while(getSuccessfulsIterator.hasNext()){
            if(getSuccessfulsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<DebitTransferTransactionView> getSuccessfuls()throws ModelException{
        return ((DebitTransferSuccessful)this.getTheObject()).getSuccessfuls();
    }
    public void setSuccessfuls(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        ((DebitTransferSuccessful)this.getTheObject()).setSuccessfuls(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferSuccessful(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferSuccessful(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferSuccessful(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferSuccessful(this);
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
