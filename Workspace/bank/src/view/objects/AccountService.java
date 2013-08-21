
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class AccountService extends view.objects.Service implements AccountServiceView{
    
    protected AccountView account;
    protected java.util.Vector<DebitTransferView> successfullStates;
    protected java.util.Vector<DebitTransferView> notSuccessfullStates;
    
    public AccountService(java.util.Vector<ErrorDisplayView> errors,AccountView account,java.util.Vector<DebitTransferView> successfullStates,java.util.Vector<DebitTransferView> notSuccessfullStates,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(errors,id, classId);
        this.account = account;
        this.successfullStates = successfullStates;
        this.notSuccessfullStates = notSuccessfullStates;        
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
    public java.util.Vector<DebitTransferView> getSuccessfullStates()throws ModelException{
        return this.successfullStates;
    }
    public void setSuccessfullStates(java.util.Vector<DebitTransferView> newValue) throws ModelException {
        this.successfullStates = newValue;
    }
    public java.util.Vector<DebitTransferView> getNotSuccessfullStates()throws ModelException{
        return this.notSuccessfullStates;
    }
    public void setNotSuccessfullStates(java.util.Vector<DebitTransferView> newValue) throws ModelException {
        this.notSuccessfullStates = newValue;
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
        java.util.Vector<?> successfullStates = this.getSuccessfullStates();
        if (successfullStates != null) {
            ViewObject.resolveVectorProxies(successfullStates, resultTable);
        }
        java.util.Vector<?> notSuccessfullStates = this.getNotSuccessfullStates();
        if (notSuccessfullStates != null) {
            ViewObject.resolveVectorProxies(notSuccessfullStates, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
