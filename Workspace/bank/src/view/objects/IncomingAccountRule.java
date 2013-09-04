
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class IncomingAccountRule extends view.objects.Rule implements IncomingAccountRuleView{
    
    protected long accountNumber;
    protected long bankNumber;
    
    public IncomingAccountRule(long accountNumber,long bankNumber,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.accountNumber = accountNumber;
        this.bankNumber = bankNumber;        
    }
    
    static public long getTypeId() {
        return 229;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getAccountNumber()throws ModelException{
        return this.accountNumber;
    }
    public void setAccountNumber(long newValue) throws ModelException {
        this.accountNumber = newValue;
    }
    public long getBankNumber()throws ModelException{
        return this.bankNumber;
    }
    public void setBankNumber(long newValue) throws ModelException {
        this.bankNumber = newValue;
    }
    
    public void accept(RuleVisitor visitor) throws ModelException {
        visitor.handleIncomingAccountRule(this);
    }
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleIncomingAccountRule(this);
    }
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleIncomingAccountRule(this);
    }
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleIncomingAccountRule(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleIncomingAccountRule(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleIncomingAccountRule(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleIncomingAccountRule(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleIncomingAccountRule(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        
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
    public int getAccountNumberIndex() throws ModelException {
        return 0;
    }
    public int getBankNumberIndex() throws ModelException {
        return 0 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "accountNumber";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "bankNumber";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getAccountNumber());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getBankNumber());
                rowIndex = rowIndex - 1;
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
        if(rowIndex == 0){
            this.setAccountNumber(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setBankNumber(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
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
