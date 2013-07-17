
package view.objects;

import view.*;


/* Additional import section end */

public abstract class LimitState extends view.objects.AccountLimitState implements LimitStateView{
    
    protected AmountView balance;
    
    public LimitState(AmountView balance,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.balance = balance;        
    }
    
    public AmountView getBalance()throws ModelException{
        return this.balance;
    }
    public void setBalance(AmountView newValue) throws ModelException {
        this.balance = newValue;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
