
package view.objects;

import view.AccountView;
import view.AllCompensationListeView;
import view.DebitGrantListePxView;
import view.DebitGrantListeView;
import view.DebitTransferTransactionView;
import view.LimitAccountView;
import view.ModelException;
import view.MoneyView;
import view.TriggerListeView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class Account extends ViewObject implements AccountView{
    
    protected long accountNumber;
    protected MoneyView money;
    protected LimitAccountView limit;
    protected java.util.Vector<DebitTransferTransactionView> debitTransferTransactions;
    protected DebitGrantListeView grantedDebitGrant;
    protected DebitGrantListePxView receivedDebitGrant;
    protected TriggerListeView triggerListe;
    protected AllCompensationListeView allCompensation;
    
    public Account(long accountNumber,MoneyView money,LimitAccountView limit,java.util.Vector<DebitTransferTransactionView> debitTransferTransactions,DebitGrantListeView grantedDebitGrant,DebitGrantListePxView receivedDebitGrant,TriggerListeView triggerListe,AllCompensationListeView allCompensation,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.accountNumber = accountNumber;
        this.money = money;
        this.limit = limit;
        this.debitTransferTransactions = debitTransferTransactions;
        this.grantedDebitGrant = grantedDebitGrant;
        this.receivedDebitGrant = receivedDebitGrant;
        this.triggerListe = triggerListe;
        this.allCompensation = allCompensation;        
    }
    
    static public long getTypeId() {
        return 133;
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
    public MoneyView getMoney()throws ModelException{
        return this.money;
    }
    public void setMoney(MoneyView newValue) throws ModelException {
        this.money = newValue;
    }
    public LimitAccountView getLimit()throws ModelException{
        return this.limit;
    }
    public void setLimit(LimitAccountView newValue) throws ModelException {
        this.limit = newValue;
    }
    public java.util.Vector<DebitTransferTransactionView> getDebitTransferTransactions()throws ModelException{
        return this.debitTransferTransactions;
    }
    public void setDebitTransferTransactions(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        this.debitTransferTransactions = newValue;
    }
    public DebitGrantListeView getGrantedDebitGrant()throws ModelException{
        return this.grantedDebitGrant;
    }
    public void setGrantedDebitGrant(DebitGrantListeView newValue) throws ModelException {
        this.grantedDebitGrant = newValue;
    }
    public DebitGrantListePxView getReceivedDebitGrant()throws ModelException{
        return this.receivedDebitGrant;
    }
    public void setReceivedDebitGrant(DebitGrantListePxView newValue) throws ModelException {
        this.receivedDebitGrant = newValue;
    }
    public TriggerListeView getTriggerListe()throws ModelException{
        return this.triggerListe;
    }
    public void setTriggerListe(TriggerListeView newValue) throws ModelException {
        this.triggerListe = newValue;
    }
    public AllCompensationListeView getAllCompensation()throws ModelException{
        return this.allCompensation;
    }
    public void setAllCompensation(AllCompensationListeView newValue) throws ModelException {
        this.allCompensation = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccount(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        MoneyView money = this.getMoney();
        if (money != null) {
            ((ViewProxi)money).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(money.getClassId(), money.getId())));
        }
        LimitAccountView limit = this.getLimit();
        if (limit != null) {
            ((ViewProxi)limit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(limit.getClassId(), limit.getId())));
        }
        java.util.Vector<?> debitTransferTransactions = this.getDebitTransferTransactions();
        if (debitTransferTransactions != null) {
            ViewObject.resolveVectorProxies(debitTransferTransactions, resultTable);
        }
        DebitGrantListeView grantedDebitGrant = this.getGrantedDebitGrant();
        if (grantedDebitGrant != null) {
            ((ViewProxi)grantedDebitGrant).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(grantedDebitGrant.getClassId(), grantedDebitGrant.getId())));
        }
        DebitGrantListePxView receivedDebitGrant = this.getReceivedDebitGrant();
        if (receivedDebitGrant != null) {
            ((ViewProxi)receivedDebitGrant).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(receivedDebitGrant.getClassId(), receivedDebitGrant.getId())));
        }
        TriggerListeView triggerListe = this.getTriggerListe();
        if (triggerListe != null) {
            ((ViewProxi)triggerListe).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(triggerListe.getClassId(), triggerListe.getId())));
        }
        AllCompensationListeView allCompensation = this.getAllCompensation();
        if (allCompensation != null) {
            ((ViewProxi)allCompensation).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(allCompensation.getClassId(), allCompensation.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMoney() != null) return new MoneyAccountWrapper(this, originalIndex, (ViewRoot)this.getMoney());
        if(this.getMoney() != null) index = index - 1;
        if(index == 0 && this.getLimit() != null) return new LimitAccountWrapper(this, originalIndex, (ViewRoot)this.getLimit());
        if(this.getLimit() != null) index = index - 1;
        if(index == 0 && this.getGrantedDebitGrant() != null) return new GrantedDebitGrantAccountWrapper(this, originalIndex, (ViewRoot)this.getGrantedDebitGrant());
        if(this.getGrantedDebitGrant() != null) index = index - 1;
        if(index == 0 && this.getReceivedDebitGrant() != null) return new ReceivedDebitGrantAccountWrapper(this, originalIndex, (ViewRoot)this.getReceivedDebitGrant());
        if(this.getReceivedDebitGrant() != null) index = index - 1;
        if(index == 0 && this.getTriggerListe() != null) return new TriggerListeAccountWrapper(this, originalIndex, (ViewRoot)this.getTriggerListe());
        if(this.getTriggerListe() != null) index = index - 1;
        if(index == 0 && this.getAllCompensation() != null) return new AllCompensationAccountWrapper(this, originalIndex, (ViewRoot)this.getAllCompensation());
        if(this.getAllCompensation() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMoney() == null ? 0 : 1)
            + (this.getLimit() == null ? 0 : 1)
            + (this.getGrantedDebitGrant() == null ? 0 : 1)
            + (this.getReceivedDebitGrant() == null ? 0 : 1)
            + (this.getTriggerListe() == null ? 0 : 1)
            + (this.getAllCompensation() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMoney() == null ? true : false)
            && (this.getLimit() == null ? true : false)
            && (this.getGrantedDebitGrant() == null ? true : false)
            && (this.getReceivedDebitGrant() == null ? true : false)
            && (this.getTriggerListe() == null ? true : false)
            && (this.getAllCompensation() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMoney() != null && this.getMoney().equals(child)) return result;
        if(this.getMoney() != null) result = result + 1;
        if(this.getLimit() != null && this.getLimit().equals(child)) return result;
        if(this.getLimit() != null) result = result + 1;
        if(this.getGrantedDebitGrant() != null && this.getGrantedDebitGrant().equals(child)) return result;
        if(this.getGrantedDebitGrant() != null) result = result + 1;
        if(this.getReceivedDebitGrant() != null && this.getReceivedDebitGrant().equals(child)) return result;
        if(this.getReceivedDebitGrant() != null) result = result + 1;
        if(this.getTriggerListe() != null && this.getTriggerListe().equals(child)) return result;
        if(this.getTriggerListe() != null) result = result + 1;
        if(this.getAllCompensation() != null && this.getAllCompensation().equals(child)) return result;
        if(this.getAllCompensation() != null) result = result + 1;
        return -1;
    }
    public int getAccountNumberIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "Kontonummer";
                rowIndex = rowIndex - 1;
            } else {
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
