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
        ViewProxi successful = null;
        String successful$String = (String)resultTable.get("successful");
        if (successful$String != null) {
            common.ProxiInformation successful$Info = common.RPCConstantsAndServices.createProxiInformation(successful$String);
            successful = view.objects.ViewProxi.createProxi(successful$Info,connectionKey);
            successful.setToString(successful$Info.getToString());
        }
        ViewProxi notExecuted = null;
        String notExecuted$String = (String)resultTable.get("notExecuted");
        if (notExecuted$String != null) {
            common.ProxiInformation notExecuted$Info = common.RPCConstantsAndServices.createProxiInformation(notExecuted$String);
            notExecuted = view.objects.ViewProxi.createProxi(notExecuted$Info,connectionKey);
            notExecuted.setToString(notExecuted$Info.getToString());
        }
        ViewProxi template = null;
        String template$String = (String)resultTable.get("template");
        if (template$String != null) {
            common.ProxiInformation template$Info = common.RPCConstantsAndServices.createProxiInformation(template$String);
            template = view.objects.ViewProxi.createProxi(template$Info,connectionKey);
            template.setToString(template$Info.getToString());
        }
        AccountServiceView result$$ = new AccountService(errors,(AccountView)account,(DebitTransferSuccessfulView)successful,(DebitTransferNotExecutedView)notExecuted,(DebitTransferTemplateView)template, this.getId(), this.getClassId());
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
        if(index == 0 && this.getSuccessful() != null) return new SuccessfulAccountServiceWrapper(this, originalIndex, (ViewRoot)this.getSuccessful());
        if(this.getSuccessful() != null) index = index - 1;
        if(index == 0 && this.getNotExecuted() != null) return new NotExecutedAccountServiceWrapper(this, originalIndex, (ViewRoot)this.getNotExecuted());
        if(this.getNotExecuted() != null) index = index - 1;
        if(index == 0 && this.getTemplate() != null) return new TemplateAccountServiceWrapper(this, originalIndex, (ViewRoot)this.getTemplate());
        if(this.getTemplate() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAccount() == null ? 0 : this.getAccount().getTheObject().getChildCount())
            + (this.getSuccessful() == null ? 0 : 1)
            + (this.getNotExecuted() == null ? 0 : 1)
            + (this.getTemplate() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAccount() == null ? true : this.getAccount().getTheObject().isLeaf())
            && (this.getSuccessful() == null ? true : false)
            && (this.getNotExecuted() == null ? true : false)
            && (this.getTemplate() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAccount() != null && this.getAccount().equals(child)) return result;
        if(this.getAccount() != null) result = result + 1;
        if(this.getSuccessful() != null && this.getSuccessful().equals(child)) return result;
        if(this.getSuccessful() != null) result = result + 1;
        if(this.getNotExecuted() != null && this.getNotExecuted().equals(child)) return result;
        if(this.getNotExecuted() != null) result = result + 1;
        if(this.getTemplate() != null && this.getTemplate().equals(child)) return result;
        if(this.getTemplate() != null) result = result + 1;
        return -1;
    }
    
    public AccountView getAccount()throws ModelException{
        return ((AccountService)this.getTheObject()).getAccount();
    }
    public void setAccount(AccountView newValue) throws ModelException {
        ((AccountService)this.getTheObject()).setAccount(newValue);
    }
    public DebitTransferSuccessfulView getSuccessful()throws ModelException{
        return ((AccountService)this.getTheObject()).getSuccessful();
    }
    public void setSuccessful(DebitTransferSuccessfulView newValue) throws ModelException {
        ((AccountService)this.getTheObject()).setSuccessful(newValue);
    }
    public DebitTransferNotExecutedView getNotExecuted()throws ModelException{
        return ((AccountService)this.getTheObject()).getNotExecuted();
    }
    public void setNotExecuted(DebitTransferNotExecutedView newValue) throws ModelException {
        ((AccountService)this.getTheObject()).setNotExecuted(newValue);
    }
    public DebitTransferTemplateView getTemplate()throws ModelException{
        return ((AccountService)this.getTheObject()).getTemplate();
    }
    public void setTemplate(DebitTransferTemplateView newValue) throws ModelException {
        ((AccountService)this.getTheObject()).setTemplate(newValue);
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
