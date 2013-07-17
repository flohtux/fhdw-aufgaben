
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class DebitNote extends view.objects.DebitNoteTransaction implements DebitNoteView{
    
    
    public DebitNote(long bankNumber,long accountNumber,MoneyView money,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((long)bankNumber,(long)accountNumber,(MoneyView)money,id, classId);        
    }
    
    static public long getTypeId() {
        return 151;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(DebitNoteTransactionVisitor visitor) throws ModelException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(DebitNoteTransactionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransactionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitNote(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitNote(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        MoneyView money = this.getMoney();
        if (money != null) {
            ((ViewProxi)money).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(money.getClassId(), money.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMoney() != null) return new MoneyDebitNoteTransactionWrapper(this, originalIndex, (ViewRoot)this.getMoney());
        if(this.getMoney() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMoney() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMoney() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMoney() != null && this.getMoney().equals(child)) return result;
        if(this.getMoney() != null) result = result + 1;
        return -1;
    }
    public int getBankNumberIndex() throws ModelException {
        return 0;
    }
    public int getAccountNumberIndex() throws ModelException {
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
                if(rowIndex == 0) return "bankNumber";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "accountNumber";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getBankNumber());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getAccountNumber());
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
            this.setBankNumber(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setAccountNumber(Long.parseLong(newValue));
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
