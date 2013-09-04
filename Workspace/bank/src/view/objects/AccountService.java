
package view.objects;

import view.AccountServiceView;
import view.AccountView;
import view.DebitTransferNotExecutedView;
import view.DebitTransferSuccessfulView;
import view.DebitTransferTemplateView;
import view.ErrorDisplayView;
import view.EventWrapperView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.RemoteExceptionVisitor;
import view.visitor.RemoteReturnExceptionVisitor;
import view.visitor.RemoteReturnVisitor;
import view.visitor.RemoteVisitor;
import view.visitor.ServiceExceptionVisitor;
import view.visitor.ServiceReturnExceptionVisitor;
import view.visitor.ServiceReturnVisitor;
import view.visitor.ServiceVisitor;
import viewClient.AccountServiceConnection;
import viewClient.ConnectionIndex;
import viewClient.ConnectionMaster;
import viewClient.ExceptionAndEventHandler;


/* Additional import section end */

public class AccountService extends view.objects.Service implements AccountServiceView{
    
    protected AccountView account;
    protected EventWrapperView eventhandle;
    protected DebitTransferSuccessfulView successful;
    protected DebitTransferNotExecutedView notExecuted;
    protected DebitTransferTemplateView template;
    
    public AccountService(java.util.Vector<ErrorDisplayView> errors,AccountView account,EventWrapperView eventhandle,DebitTransferSuccessfulView successful,DebitTransferNotExecutedView notExecuted,DebitTransferTemplateView template,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(errors,id, classId);
        this.account = account;
        this.eventhandle = eventhandle;
        this.successful = successful;
        this.notExecuted = notExecuted;
        this.template = template;        
    }
    
    static public long getTypeId() {
        return -130;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public AccountView getAccount()throws ModelException{
        return this.account;
    }
    public void setAccount(AccountView newValue) throws ModelException {
        this.account = newValue;
    }
    public EventWrapperView getEventhandle()throws ModelException{
        return this.eventhandle;
    }
    public void setEventhandle(EventWrapperView newValue) throws ModelException {
        this.eventhandle = newValue;
    }
    public DebitTransferSuccessfulView getSuccessful()throws ModelException{
        return this.successful;
    }
    public void setSuccessful(DebitTransferSuccessfulView newValue) throws ModelException {
        this.successful = newValue;
    }
    public DebitTransferNotExecutedView getNotExecuted()throws ModelException{
        return this.notExecuted;
    }
    public void setNotExecuted(DebitTransferNotExecutedView newValue) throws ModelException {
        this.notExecuted = newValue;
    }
    public DebitTransferTemplateView getTemplate()throws ModelException{
        return this.template;
    }
    public void setTemplate(DebitTransferTemplateView newValue) throws ModelException {
        this.template = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        AccountView account = this.getAccount();
        if (account != null) {
            ((ViewProxi)account).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(account.getClassId(), account.getId())));
        }
        EventWrapperView eventhandle = this.getEventhandle();
        if (eventhandle != null) {
            ((ViewProxi)eventhandle).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(eventhandle.getClassId(), eventhandle.getId())));
        }
        DebitTransferSuccessfulView successful = this.getSuccessful();
        if (successful != null) {
            ((ViewProxi)successful).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(successful.getClassId(), successful.getId())));
        }
        DebitTransferNotExecutedView notExecuted = this.getNotExecuted();
        if (notExecuted != null) {
            ((ViewProxi)notExecuted).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(notExecuted.getClassId(), notExecuted.getId())));
        }
        DebitTransferTemplateView template = this.getTemplate();
        if (template != null) {
            ((ViewProxi)template).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(template.getClassId(), template.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        
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
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
