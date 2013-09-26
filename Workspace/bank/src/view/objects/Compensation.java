
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


/* Additional import section end */

public class Compensation extends ViewObject implements CompensationView{
    
    protected AccountView requestingAccount;
    protected java.util.Vector<CompensationRequestView> pendingRequests;
    protected CompensationStateView state;
    
    public Compensation(AccountView requestingAccount,java.util.Vector<CompensationRequestView> pendingRequests,CompensationStateView state,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.requestingAccount = requestingAccount;
        this.pendingRequests = pendingRequests;
        this.state = state;        
    }
    
    static public long getTypeId() {
        return 254;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public AccountView getRequestingAccount()throws ModelException{
        return this.requestingAccount;
    }
    public void setRequestingAccount(AccountView newValue) throws ModelException {
        this.requestingAccount = newValue;
    }
    public java.util.Vector<CompensationRequestView> getPendingRequests()throws ModelException{
        return this.pendingRequests;
    }
    public void setPendingRequests(java.util.Vector<CompensationRequestView> newValue) throws ModelException {
        this.pendingRequests = newValue;
    }
    public CompensationStateView getState()throws ModelException{
        return this.state;
    }
    public void setState(CompensationStateView newValue) throws ModelException {
        this.state = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AccountView requestingAccount = this.getRequestingAccount();
        if (requestingAccount != null) {
            ((ViewProxi)requestingAccount).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(requestingAccount.getClassId(), requestingAccount.getId())));
        }
        java.util.Vector<?> pendingRequests = this.getPendingRequests();
        if (pendingRequests != null) {
            ViewObject.resolveVectorProxies(pendingRequests, resultTable);
        }
        CompensationStateView state = this.getState();
        if (state != null) {
            ((ViewProxi)state).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(state.getClassId(), state.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getPendingRequests().size()) return new PendingRequestsCompensationWrapper(this, originalIndex, (ViewRoot)this.getPendingRequests().get(index));
        index = index - this.getPendingRequests().size();
        if(index == 0 && this.getState() != null) return new StateCompensationWrapper(this, originalIndex, (ViewRoot)this.getState());
        if(this.getState() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPendingRequests().size())
            + (this.getState() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getPendingRequests().size() == 0)
            && (this.getState() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getPendingRequestsIterator = this.getPendingRequests().iterator();
        while(getPendingRequestsIterator.hasNext()){
            if(getPendingRequestsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getState() != null && this.getState().equals(child)) return result;
        if(this.getState() != null) result = result + 1;
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
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
