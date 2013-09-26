
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class DebitTransferPayedFees extends ViewObject implements DebitTransferPayedFeesView{
    
    protected MoneyView payedFees;
    protected AccountView payingAccount;
    
    public DebitTransferPayedFees(MoneyView payedFees,AccountView payingAccount,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.payedFees = payedFees;
        this.payingAccount = payingAccount;        
    }
    
    static public long getTypeId() {
        return 288;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public MoneyView getPayedFees()throws ModelException{
        return this.payedFees;
    }
    public void setPayedFees(MoneyView newValue) throws ModelException {
        this.payedFees = newValue;
    }
    public AccountView getPayingAccount()throws ModelException{
        return this.payingAccount;
    }
    public void setPayingAccount(AccountView newValue) throws ModelException {
        this.payingAccount = newValue;
    }
    
    public void accept(DebitTransferPayedFeesVisitor visitor) throws ModelException {
        visitor.handleDebitTransferPayedFees(this);
    }
    public <R> R accept(DebitTransferPayedFeesReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public <E extends UserException>  void accept(DebitTransferPayedFeesExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferPayedFees(this);
    }
    public <R, E extends UserException> R accept(DebitTransferPayedFeesReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferPayedFees(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferPayedFees(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferPayedFees(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        MoneyView payedFees = this.getPayedFees();
        if (payedFees != null) {
            ((ViewProxi)payedFees).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(payedFees.getClassId(), payedFees.getId())));
        }
        AccountView payingAccount = this.getPayingAccount();
        if (payingAccount != null) {
            ((ViewProxi)payingAccount).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(payingAccount.getClassId(), payingAccount.getId())));
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
