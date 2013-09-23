package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class CompensationRequestListeProxi extends ViewProxi implements CompensationRequestListeView{
    
    public CompensationRequestListeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public CompensationRequestListeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> compensationrequests_string = (java.util.Vector<String>)resultTable.get("compensationrequests");
        java.util.Vector<CompensationRequestView> compensationrequests = ViewProxi.getProxiVector(compensationrequests_string, connectionKey);
        CompensationRequestListeView result$$ = new CompensationRequestListe(compensationrequests, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getCompensationrequests().size()) return new CompensationrequestsCompensationRequestListeWrapper(this, originalIndex, (ViewRoot)this.getCompensationrequests().get(index));
        index = index - this.getCompensationrequests().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCompensationrequests().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getCompensationrequests().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getCompensationrequestsIterator = this.getCompensationrequests().iterator();
        while(getCompensationrequestsIterator.hasNext()){
            if(getCompensationrequestsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<CompensationRequestView> getCompensationrequests()throws ModelException{
        return ((CompensationRequestListe)this.getTheObject()).getCompensationrequests();
    }
    public void setCompensationrequests(java.util.Vector<CompensationRequestView> newValue) throws ModelException {
        ((CompensationRequestListe)this.getTheObject()).setCompensationrequests(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompensationRequestListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompensationRequestListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompensationRequestListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompensationRequestListe(this);
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
