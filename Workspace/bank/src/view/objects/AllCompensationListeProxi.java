package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AllCompensationListeProxi extends ViewProxi implements AllCompensationListeView{
    
    public AllCompensationListeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public AllCompensationListeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi outgoingCompensations = null;
        String outgoingCompensations$String = (String)resultTable.get("outgoingCompensations");
        if (outgoingCompensations$String != null) {
            common.ProxiInformation outgoingCompensations$Info = common.RPCConstantsAndServices.createProxiInformation(outgoingCompensations$String);
            outgoingCompensations = view.objects.ViewProxi.createProxi(outgoingCompensations$Info,connectionKey);
            outgoingCompensations.setToString(outgoingCompensations$Info.getToString());
        }
        ViewProxi pendingCompensationRequests = null;
        String pendingCompensationRequests$String = (String)resultTable.get("pendingCompensationRequests");
        if (pendingCompensationRequests$String != null) {
            common.ProxiInformation pendingCompensationRequests$Info = common.RPCConstantsAndServices.createProxiInformation(pendingCompensationRequests$String);
            pendingCompensationRequests = view.objects.ViewProxi.createProxi(pendingCompensationRequests$Info,connectionKey);
            pendingCompensationRequests.setToString(pendingCompensationRequests$Info.getToString());
        }
        AllCompensationListeView result$$ = new AllCompensationListe((CompensationListeView)outgoingCompensations,(CompensationRequestListeView)pendingCompensationRequests, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getOutgoingCompensations() != null) return new OutgoingCompensationsAllCompensationListeWrapper(this, originalIndex, (ViewRoot)this.getOutgoingCompensations());
        if(this.getOutgoingCompensations() != null) index = index - 1;
        if(index == 0 && this.getPendingCompensationRequests() != null) return new PendingCompensationRequestsAllCompensationListeWrapper(this, originalIndex, (ViewRoot)this.getPendingCompensationRequests());
        if(this.getPendingCompensationRequests() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getOutgoingCompensations() == null ? 0 : 1)
            + (this.getPendingCompensationRequests() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getOutgoingCompensations() == null ? true : false)
            && (this.getPendingCompensationRequests() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getOutgoingCompensations() != null && this.getOutgoingCompensations().equals(child)) return result;
        if(this.getOutgoingCompensations() != null) result = result + 1;
        if(this.getPendingCompensationRequests() != null && this.getPendingCompensationRequests().equals(child)) return result;
        if(this.getPendingCompensationRequests() != null) result = result + 1;
        return -1;
    }
    
    public CompensationListeView getOutgoingCompensations()throws ModelException{
        return ((AllCompensationListe)this.getTheObject()).getOutgoingCompensations();
    }
    public void setOutgoingCompensations(CompensationListeView newValue) throws ModelException {
        ((AllCompensationListe)this.getTheObject()).setOutgoingCompensations(newValue);
    }
    public CompensationRequestListeView getPendingCompensationRequests()throws ModelException{
        return ((AllCompensationListe)this.getTheObject()).getPendingCompensationRequests();
    }
    public void setPendingCompensationRequests(CompensationRequestListeView newValue) throws ModelException {
        ((AllCompensationListe)this.getTheObject()).setPendingCompensationRequests(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAllCompensationListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAllCompensationListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAllCompensationListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAllCompensationListe(this);
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
