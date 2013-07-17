
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class MaxLimitState extends view.objects.LimitState implements MaxLimitStateView{
    
    
    public MaxLimitState(AmountView balance,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((AmountView)balance,id, classId);        
    }
    
    static public long getTypeId() {
        return 145;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(LimitStateVisitor visitor) throws ModelException {
        visitor.handleMaxLimitState(this);
    }
    public <R> R accept(LimitStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMaxLimitState(this);
    }
    public <E extends UserException>  void accept(LimitStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMaxLimitState(this);
    }
    public <R, E extends UserException> R accept(LimitStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMaxLimitState(this);
    }
    public void accept(AccountLimitStateVisitor visitor) throws ModelException {
        visitor.handleMaxLimitState(this);
    }
    public <R> R accept(AccountLimitStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMaxLimitState(this);
    }
    public <E extends UserException>  void accept(AccountLimitStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMaxLimitState(this);
    }
    public <R, E extends UserException> R accept(AccountLimitStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMaxLimitState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMaxLimitState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMaxLimitState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMaxLimitState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMaxLimitState(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AmountView balance = this.getBalance();
        if (balance != null) {
            ((ViewProxi)balance).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(balance.getClassId(), balance.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getBalance() != null) return new BalanceLimitStateWrapper(this, originalIndex, (ViewRoot)this.getBalance());
        if(this.getBalance() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getBalance() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getBalance() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getBalance() != null && this.getBalance().equals(child)) return result;
        if(this.getBalance() != null) result = result + 1;
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
