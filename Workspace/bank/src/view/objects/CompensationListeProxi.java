package view.objects;

import view.CompensationListeView;
import view.CompensationView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import viewClient.ExceptionAndEventHandler;

public class CompensationListeProxi extends ViewProxi implements CompensationListeView{
    
    public CompensationListeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public CompensationListeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> compensations_string = (java.util.Vector<String>)resultTable.get("compensations");
        java.util.Vector<CompensationView> compensations = ViewProxi.getProxiVector(compensations_string, connectionKey);
        CompensationListeView result$$ = new CompensationListe(compensations, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getCompensations().size()) return new CompensationsCompensationListeWrapper(this, originalIndex, (ViewRoot)this.getCompensations().get(index));
        index = index - this.getCompensations().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCompensations().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getCompensations().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getCompensationsIterator = this.getCompensations().iterator();
        while(getCompensationsIterator.hasNext()){
            if(getCompensationsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<CompensationView> getCompensations()throws ModelException{
        return ((CompensationListe)this.getTheObject()).getCompensations();
    }
    public void setCompensations(java.util.Vector<CompensationView> newValue) throws ModelException {
        ((CompensationListe)this.getTheObject()).setCompensations(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompensationListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompensationListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompensationListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompensationListe(this);
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
