package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class CompensationProxi extends ViewProxi implements CompensationView{
    
    public CompensationProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public CompensationView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> transactionsToBeCompensated_string = (java.util.Vector<String>)resultTable.get("transactionsToBeCompensated");
        java.util.Vector<DebitTransferTransactionView> transactionsToBeCompensated = ViewProxi.getProxiVector(transactionsToBeCompensated_string, connectionKey);
        ViewProxi requestingAccount = null;
        String requestingAccount$String = (String)resultTable.get("requestingAccount");
        if (requestingAccount$String != null) {
            common.ProxiInformation requestingAccount$Info = common.RPCConstantsAndServices.createProxiInformation(requestingAccount$String);
            requestingAccount = view.objects.ViewProxi.createProxi(requestingAccount$Info,connectionKey);
            requestingAccount.setToString(requestingAccount$Info.getToString());
        }
        java.util.Vector<String> pendingRequests_string = (java.util.Vector<String>)resultTable.get("pendingRequests");
        java.util.Vector<CompensationRequestView> pendingRequests = ViewProxi.getProxiVector(pendingRequests_string, connectionKey);
        CompensationView result$$ = new Compensation(transactionsToBeCompensated,(AccountView)requestingAccount,pendingRequests, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getTransactionsToBeCompensated().size()) return new TransactionsToBeCompensatedCompensationWrapper(this, originalIndex, (ViewRoot)this.getTransactionsToBeCompensated().get(index));
        index = index - this.getTransactionsToBeCompensated().size();
        if(index == 0 && this.getRequestingAccount() != null) return new RequestingAccountCompensationWrapper(this, originalIndex, (ViewRoot)this.getRequestingAccount());
        if(this.getRequestingAccount() != null) index = index - 1;
        if(index < this.getPendingRequests().size()) return new PendingRequestsCompensationWrapper(this, originalIndex, (ViewRoot)this.getPendingRequests().get(index));
        index = index - this.getPendingRequests().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTransactionsToBeCompensated().size())
            + (this.getRequestingAccount() == null ? 0 : 1)
            + (this.getPendingRequests().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getTransactionsToBeCompensated().size() == 0)
            && (this.getRequestingAccount() == null ? true : false)
            && (this.getPendingRequests().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTransactionsToBeCompensatedIterator = this.getTransactionsToBeCompensated().iterator();
        while(getTransactionsToBeCompensatedIterator.hasNext()){
            if(getTransactionsToBeCompensatedIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getRequestingAccount() != null && this.getRequestingAccount().equals(child)) return result;
        if(this.getRequestingAccount() != null) result = result + 1;
        java.util.Iterator<?> getPendingRequestsIterator = this.getPendingRequests().iterator();
        while(getPendingRequestsIterator.hasNext()){
            if(getPendingRequestsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<DebitTransferTransactionView> getTransactionsToBeCompensated()throws ModelException{
        return ((Compensation)this.getTheObject()).getTransactionsToBeCompensated();
    }
    public void setTransactionsToBeCompensated(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        ((Compensation)this.getTheObject()).setTransactionsToBeCompensated(newValue);
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
