package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AccountServiceProxi extends ServiceProxi implements AccountServiceView{
    
    public AccountServiceProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AccountServiceView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        ViewProxi account = null;
        String account$String = (String)resultTable.get("account");
        if (account$String != null) {
            common.ProxiInformation account$Info = common.RPCConstantsAndServices.createProxiInformation(account$String);
            account = view.objects.ViewProxi.createProxi(account$Info,connectionKey);
            account.setToString(account$Info.getToString());
        }
        java.util.Vector<String> successfullStates_string = (java.util.Vector<String>)resultTable.get("successfullStates");
        java.util.Vector<DebitTransferView> successfullStates = ViewProxi.getProxiVector(successfullStates_string, connectionKey);
        java.util.Vector<String> notSuccessfullStates_string = (java.util.Vector<String>)resultTable.get("notSuccessfullStates");
        java.util.Vector<DebitTransferView> notSuccessfullStates = ViewProxi.getProxiVector(notSuccessfullStates_string, connectionKey);
        AccountServiceView result$$ = new AccountService(errors,(AccountView)account,successfullStates,notSuccessfullStates, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getAccount() != null && index < this.getAccount().getTheObject().getChildCount())
            return this.getAccount().getTheObject().getChild(index);
        if(this.getAccount() != null) index = index - this.getAccount().getTheObject().getChildCount();
        if(index < this.getSuccessfullStates().size()) return new SuccessfullStatesAccountServiceWrapper(this, originalIndex, (ViewRoot)this.getSuccessfullStates().get(index));
        index = index - this.getSuccessfullStates().size();
        if(index < this.getNotSuccessfullStates().size()) return new NotSuccessfullStatesAccountServiceWrapper(this, originalIndex, (ViewRoot)this.getNotSuccessfullStates().get(index));
        index = index - this.getNotSuccessfullStates().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAccount() == null ? 0 : this.getAccount().getTheObject().getChildCount())
            + (this.getSuccessfullStates().size())
            + (this.getNotSuccessfullStates().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAccount() == null ? true : this.getAccount().getTheObject().isLeaf())
            && (this.getSuccessfullStates().size() == 0)
            && (this.getNotSuccessfullStates().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAccount() != null && this.getAccount().equals(child)) return result;
        if(this.getAccount() != null) result = result + 1;
        java.util.Iterator<?> getSuccessfullStatesIterator = this.getSuccessfullStates().iterator();
        while(getSuccessfullStatesIterator.hasNext()){
            if(getSuccessfullStatesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getNotSuccessfullStatesIterator = this.getNotSuccessfullStates().iterator();
        while(getNotSuccessfullStatesIterator.hasNext()){
            if(getNotSuccessfullStatesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public AccountView getAccount()throws ModelException{
        return ((AccountService)this.getTheObject()).getAccount();
    }
    public void setAccount(AccountView newValue) throws ModelException {
        ((AccountService)this.getTheObject()).setAccount(newValue);
    }
    public java.util.Vector<DebitTransferView> getSuccessfullStates()throws ModelException{
        return ((AccountService)this.getTheObject()).getSuccessfullStates();
    }
    public void setSuccessfullStates(java.util.Vector<DebitTransferView> newValue) throws ModelException {
        ((AccountService)this.getTheObject()).setSuccessfullStates(newValue);
    }
    public java.util.Vector<DebitTransferView> getNotSuccessfullStates()throws ModelException{
        return ((AccountService)this.getTheObject()).getNotSuccessfullStates();
    }
    public void setNotSuccessfullStates(java.util.Vector<DebitTransferView> newValue) throws ModelException {
        ((AccountService)this.getTheObject()).setNotSuccessfullStates(newValue);
    }
    
    public void accept(ServiceVisitor visitor) throws ModelException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccountService(this);
    }
    
    
    public AccountServiceConnection connectAccountService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        AccountServiceConnection result;
		try {
			result = (AccountServiceConnection) new AccountServiceConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
