
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class DebitGrant extends ViewObject implements DebitGrantView{
    
    protected AccountView permittedAccount;
    protected LimitTypeView limits;
    
    public DebitGrant(AccountView permittedAccount,LimitTypeView limits,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.permittedAccount = permittedAccount;
        this.limits = limits;        
    }
    
    static public long getTypeId() {
        return 191;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public AccountView getPermittedAccount()throws ModelException{
        return this.permittedAccount;
    }
    public void setPermittedAccount(AccountView newValue) throws ModelException {
        this.permittedAccount = newValue;
    }
    public LimitTypeView getLimits()throws ModelException{
        return this.limits;
    }
    public void setLimits(LimitTypeView newValue) throws ModelException {
        this.limits = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitGrant(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitGrant(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitGrant(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitGrant(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AccountView permittedAccount = this.getPermittedAccount();
        if (permittedAccount != null) {
            ((ViewProxi)permittedAccount).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(permittedAccount.getClassId(), permittedAccount.getId())));
        }
        LimitTypeView limits = this.getLimits();
        if (limits != null) {
            ((ViewProxi)limits).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(limits.getClassId(), limits.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getPermittedAccount() != null) return new PermittedAccountDebitGrantWrapper(this, originalIndex, (ViewRoot)this.getPermittedAccount());
        if(this.getPermittedAccount() != null) index = index - 1;
        if(index == 0 && this.getLimits() != null) return new LimitsDebitGrantWrapper(this, originalIndex, (ViewRoot)this.getLimits());
        if(this.getLimits() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPermittedAccount() == null ? 0 : 1)
            + (this.getLimits() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getPermittedAccount() == null ? true : false)
            && (this.getLimits() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getPermittedAccount() != null && this.getPermittedAccount().equals(child)) return result;
        if(this.getPermittedAccount() != null) result = result + 1;
        if(this.getLimits() != null && this.getLimits().equals(child)) return result;
        if(this.getLimits() != null) result = result + 1;
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
