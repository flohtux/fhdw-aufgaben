
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class Bank extends ViewObject implements BankView{
    
    protected long bankNumber;
    protected String name;
    protected TransactionFeeView fee;
    protected java.util.Vector<AccountView> currentAccounts;
    
    public Bank(long bankNumber,String name,TransactionFeeView fee,java.util.Vector<AccountView> currentAccounts,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.bankNumber = bankNumber;
        this.name = name;
        this.fee = fee;
        this.currentAccounts = currentAccounts;        
    }
    
    static public long getTypeId() {
        return -113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getBankNumber()throws ModelException{
        return this.bankNumber;
    }
    public void setBankNumber(long newValue) throws ModelException {
        this.bankNumber = newValue;
    }
    public String getName()throws ModelException{
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public TransactionFeeView getFee()throws ModelException{
        return this.fee;
    }
    public void setFee(TransactionFeeView newValue) throws ModelException {
        this.fee = newValue;
    }
    public java.util.Vector<AccountView> getCurrentAccounts()throws ModelException{
        return this.currentAccounts;
    }
    public void setCurrentAccounts(java.util.Vector<AccountView> newValue) throws ModelException {
        this.currentAccounts = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleBank(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleBank(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleBank(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleBank(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        TransactionFeeView fee = this.getFee();
        if (fee != null) {
            ((ViewProxi)fee).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(fee.getClassId(), fee.getId())));
        }
        java.util.Vector<?> currentAccounts = this.getCurrentAccounts();
        if (currentAccounts != null) {
            ViewObject.resolveVectorProxies(currentAccounts, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getFee() != null) return new FeeBankWrapper(this, originalIndex, (ViewRoot)this.getFee());
        if(this.getFee() != null) index = index - 1;
        if(index < this.getCurrentAccounts().size()) return new CurrentAccountsBankWrapper(this, originalIndex, (ViewRoot)this.getCurrentAccounts().get(index));
        index = index - this.getCurrentAccounts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getFee() == null ? 0 : 1)
            + (this.getCurrentAccounts().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getFee() == null ? true : false)
            && (this.getCurrentAccounts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getFee() != null && this.getFee().equals(child)) return result;
        if(this.getFee() != null) result = result + 1;
        java.util.Iterator<?> getCurrentAccountsIterator = this.getCurrentAccounts().iterator();
        while(getCurrentAccountsIterator.hasNext()){
            if(getCurrentAccountsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getBankNumberIndex() throws ModelException {
        return 0;
    }
    public int getNameIndex() throws ModelException {
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
                if(rowIndex == 0) return "BLZ";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "Name";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getBankNumber());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getName();
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
            this.setName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
