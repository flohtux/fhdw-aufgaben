
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class Bank extends ViewObject implements BankView{
    
    protected long bankNumber;
    protected String name;
    protected TransactionFeeView fee;
    protected InternalFeeView internalFee;
    protected AccountView ownAccount;
    protected AdministratorView administrator;
    protected java.util.Vector<AccountView> currentAccounts;
    
    public Bank(long bankNumber,String name,TransactionFeeView fee,InternalFeeView internalFee,AccountView ownAccount,AdministratorView administrator,java.util.Vector<AccountView> currentAccounts,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.bankNumber = bankNumber;
        this.name = name;
        this.fee = fee;
        this.internalFee = internalFee;
        this.ownAccount = ownAccount;
        this.administrator = administrator;
        this.currentAccounts = currentAccounts;        
    }
    
    static public long getTypeId() {
        return -149;
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
    public InternalFeeView getInternalFee()throws ModelException{
        return this.internalFee;
    }
    public void setInternalFee(InternalFeeView newValue) throws ModelException {
        this.internalFee = newValue;
    }
    public AccountView getOwnAccount()throws ModelException{
        return this.ownAccount;
    }
    public void setOwnAccount(AccountView newValue) throws ModelException {
        this.ownAccount = newValue;
    }
    public AdministratorView getAdministrator()throws ModelException{
        return this.administrator;
    }
    public void setAdministrator(AdministratorView newValue) throws ModelException {
        this.administrator = newValue;
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
        InternalFeeView internalFee = this.getInternalFee();
        if (internalFee != null) {
            ((ViewProxi)internalFee).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(internalFee.getClassId(), internalFee.getId())));
        }
        AccountView ownAccount = this.getOwnAccount();
        if (ownAccount != null) {
            ((ViewProxi)ownAccount).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(ownAccount.getClassId(), ownAccount.getId())));
        }
        AdministratorView administrator = this.getAdministrator();
        if (administrator != null) {
            ((ViewProxi)administrator).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(administrator.getClassId(), administrator.getId())));
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
        if(index == 0 && this.getInternalFee() != null) return new InternalFeeBankWrapper(this, originalIndex, (ViewRoot)this.getInternalFee());
        if(this.getInternalFee() != null) index = index - 1;
        if(index == 0 && this.getOwnAccount() != null) return new OwnAccountBankWrapper(this, originalIndex, (ViewRoot)this.getOwnAccount());
        if(this.getOwnAccount() != null) index = index - 1;
        if(index < this.getCurrentAccounts().size()) return new CurrentAccountsBankWrapper(this, originalIndex, (ViewRoot)this.getCurrentAccounts().get(index));
        index = index - this.getCurrentAccounts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getFee() == null ? 0 : 1)
            + (this.getInternalFee() == null ? 0 : 1)
            + (this.getOwnAccount() == null ? 0 : 1)
            + (this.getCurrentAccounts().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getFee() == null ? true : false)
            && (this.getInternalFee() == null ? true : false)
            && (this.getOwnAccount() == null ? true : false)
            && (this.getCurrentAccounts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getFee() != null && this.getFee().equals(child)) return result;
        if(this.getFee() != null) result = result + 1;
        if(this.getInternalFee() != null && this.getInternalFee().equals(child)) return result;
        if(this.getInternalFee() != null) result = result + 1;
        if(this.getOwnAccount() != null && this.getOwnAccount().equals(child)) return result;
        if(this.getOwnAccount() != null) result = result + 1;
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
