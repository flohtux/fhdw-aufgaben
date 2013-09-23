package view.objects;

import view.DebitGrantListeView;
import view.DebitGrantView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import viewClient.ExceptionAndEventHandler;

public class DebitGrantListeProxi extends ViewProxi implements DebitGrantListeView{
    
    public DebitGrantListeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public DebitGrantListeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> debitGrants_string = (java.util.Vector<String>)resultTable.get("debitGrants");
        java.util.Vector<DebitGrantView> debitGrants = ViewProxi.getProxiVector(debitGrants_string, connectionKey);
        DebitGrantListeView result$$ = new DebitGrantListe(debitGrants, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getDebitGrants().size()) return new DebitGrantsDebitGrantListeWrapper(this, originalIndex, (ViewRoot)this.getDebitGrants().get(index));
        index = index - this.getDebitGrants().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDebitGrants().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getDebitGrants().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getDebitGrantsIterator = this.getDebitGrants().iterator();
        while(getDebitGrantsIterator.hasNext()){
            if(getDebitGrantsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<DebitGrantView> getDebitGrants()throws ModelException{
        return ((DebitGrantListe)this.getTheObject()).getDebitGrants();
    }
    public void setDebitGrants(java.util.Vector<DebitGrantView> newValue) throws ModelException {
        ((DebitGrantListe)this.getTheObject()).setDebitGrants(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitGrantListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitGrantListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitGrantListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitGrantListe(this);
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
