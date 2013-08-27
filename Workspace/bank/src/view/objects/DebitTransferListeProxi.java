package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class DebitTransferListeProxi extends ViewProxi implements DebitTransferListeView{
    
    public DebitTransferListeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public DebitTransferListeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> debitTransfers_string = (java.util.Vector<String>)resultTable.get("debitTransfers");
        java.util.Vector<DebitTransferView> debitTransfers = ViewProxi.getProxiVector(debitTransfers_string, connectionKey);
        DebitTransferListeView result$$ = new DebitTransferListe(debitTransfers, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getDebitTransfers().size()) return new DebitTransfersDebitTransferListeWrapper(this, originalIndex, (ViewRoot)this.getDebitTransfers().get(index));
        index = index - this.getDebitTransfers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDebitTransfers().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getDebitTransfers().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getDebitTransfersIterator = this.getDebitTransfers().iterator();
        while(getDebitTransfersIterator.hasNext()){
            if(getDebitTransfersIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<DebitTransferView> getDebitTransfers()throws ModelException{
        return ((DebitTransferListe)this.getTheObject()).getDebitTransfers();
    }
    public void setDebitTransfers(java.util.Vector<DebitTransferView> newValue) throws ModelException {
        ((DebitTransferListe)this.getTheObject()).setDebitTransfers(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferListe(this);
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
