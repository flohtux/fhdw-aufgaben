package view.objects;

import view.AccountView;
import view.CompensationRequestView;
import view.CompensationStateView;
import view.CompensationView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import viewClient.ExceptionAndEventHandler;

public class CompensationProxi extends ViewProxi implements CompensationView{
    
    public CompensationProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public CompensationView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi requestingAccount = null;
        String requestingAccount$String = (String)resultTable.get("requestingAccount");
        if (requestingAccount$String != null) {
            common.ProxiInformation requestingAccount$Info = common.RPCConstantsAndServices.createProxiInformation(requestingAccount$String);
            requestingAccount = view.objects.ViewProxi.createProxi(requestingAccount$Info,connectionKey);
            requestingAccount.setToString(requestingAccount$Info.getToString());
        }
        java.util.Vector<String> pendingRequests_string = (java.util.Vector<String>)resultTable.get("pendingRequests");
        java.util.Vector<CompensationRequestView> pendingRequests = ViewProxi.getProxiVector(pendingRequests_string, connectionKey);
        ViewProxi state = null;
        String state$String = (String)resultTable.get("state");
        if (state$String != null) {
            common.ProxiInformation state$Info = common.RPCConstantsAndServices.createProxiInformation(state$String);
            state = view.objects.ViewProxi.createProxi(state$Info,connectionKey);
            state.setToString(state$Info.getToString());
        }
        CompensationView result$$ = new Compensation((AccountView)requestingAccount,pendingRequests,(CompensationStateView)state, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getRequestingAccount() != null) return new RequestingAccountCompensationWrapper(this, originalIndex, (ViewRoot)this.getRequestingAccount());
        if(this.getRequestingAccount() != null) index = index - 1;
        if(index < this.getPendingRequests().size()) return new PendingRequestsCompensationWrapper(this, originalIndex, (ViewRoot)this.getPendingRequests().get(index));
        index = index - this.getPendingRequests().size();
        if(index == 0 && this.getState() != null) return new StateCompensationWrapper(this, originalIndex, (ViewRoot)this.getState());
        if(this.getState() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getRequestingAccount() == null ? 0 : 1)
            + (this.getPendingRequests().size())
            + (this.getState() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getRequestingAccount() == null ? true : false)
            && (this.getPendingRequests().size() == 0)
            && (this.getState() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getRequestingAccount() != null && this.getRequestingAccount().equals(child)) return result;
        if(this.getRequestingAccount() != null) result = result + 1;
        java.util.Iterator<?> getPendingRequestsIterator = this.getPendingRequests().iterator();
        while(getPendingRequestsIterator.hasNext()){
            if(getPendingRequestsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getState() != null && this.getState().equals(child)) return result;
        if(this.getState() != null) result = result + 1;
        return -1;
    }
    
    public AccountView getRequestingAccount()throws ModelException{
        return ((Compensation)this.getTheObject()).getRequestingAccount();
    }
    public void setRequestingAccount(AccountView newValue) throws ModelException {
        ((Compensation)this.getTheObject()).setRequestingAccount(newValue);
    }
    public java.util.Vector<CompensationRequestView> getPendingRequests()throws ModelException{
        return ((Compensation)this.getTheObject()).getPendingRequests();
    }
    public void setPendingRequests(java.util.Vector<CompensationRequestView> newValue) throws ModelException {
        ((Compensation)this.getTheObject()).setPendingRequests(newValue);
    }
    public CompensationStateView getState()throws ModelException{
        return ((Compensation)this.getTheObject()).getState();
    }
    public void setState(CompensationStateView newValue) throws ModelException {
        ((Compensation)this.getTheObject()).setState(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompensation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompensation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompensation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompensation(this);
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
