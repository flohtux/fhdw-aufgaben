
package view.objects;

import view.AccountView;
import view.LimitAccountView;
import view.LimitTypeView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class LimitAccount extends ViewObject implements LimitAccountView{
    
    protected LimitTypeView minLimit;
    protected LimitTypeView maxLimit;
    protected AccountView account;
    
    public LimitAccount(LimitTypeView minLimit,LimitTypeView maxLimit,AccountView account,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.account = account;        
    }
    
    static public long getTypeId() {
        return 127;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public LimitTypeView getMinLimit()throws ModelException{
        return this.minLimit;
    }
    public void setMinLimit(LimitTypeView newValue) throws ModelException {
        this.minLimit = newValue;
    }
    public LimitTypeView getMaxLimit()throws ModelException{
        return this.maxLimit;
    }
    public void setMaxLimit(LimitTypeView newValue) throws ModelException {
        this.maxLimit = newValue;
    }
    public AccountView getAccount()throws ModelException{
        return this.account;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleLimitAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLimitAccount(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLimitAccount(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLimitAccount(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        LimitTypeView minLimit = this.getMinLimit();
        if (minLimit != null) {
            ((ViewProxi)minLimit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(minLimit.getClassId(), minLimit.getId())));
        }
        LimitTypeView maxLimit = this.getMaxLimit();
        if (maxLimit != null) {
            ((ViewProxi)maxLimit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(maxLimit.getClassId(), maxLimit.getId())));
        }
        AccountView account = this.getAccount();
        if (account != null) {
            ((ViewProxi)account).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(account.getClassId(), account.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
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
