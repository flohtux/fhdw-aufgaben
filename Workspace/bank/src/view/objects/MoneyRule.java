
package view.objects;

import view.CurrencyView;
import view.LimitAccountView;
import view.ModelException;
import view.MoneyRuleView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.RuleExceptionVisitor;
import view.visitor.RuleReturnExceptionVisitor;
import view.visitor.RuleReturnVisitor;
import view.visitor.RuleVisitor;


/* Additional import section end */

public class MoneyRule extends view.objects.Rule implements MoneyRuleView{
    
    protected CurrencyView currency;
    protected LimitAccountView limitAccount;
    
    public MoneyRule(CurrencyView currency,LimitAccountView limitAccount,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.currency = currency;
        this.limitAccount = limitAccount;        
    }
    
    static public long getTypeId() {
        return 232;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public CurrencyView getCurrency()throws ModelException{
        return this.currency;
    }
    public void setCurrency(CurrencyView newValue) throws ModelException {
        this.currency = newValue;
    }
    public LimitAccountView getLimitAccount()throws ModelException{
        return this.limitAccount;
    }
    public void setLimitAccount(LimitAccountView newValue) throws ModelException {
        this.limitAccount = newValue;
    }
    
    public void accept(RuleVisitor visitor) throws ModelException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMoneyRule(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMoneyRule(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        CurrencyView currency = this.getCurrency();
        if (currency != null) {
            ((ViewProxi)currency).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(currency.getClassId(), currency.getId())));
        }
        LimitAccountView limitAccount = this.getLimitAccount();
        if (limitAccount != null) {
            ((ViewProxi)limitAccount).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(limitAccount.getClassId(), limitAccount.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getLimitAccount() != null) return new LimitAccountMoneyRuleWrapper(this, originalIndex, (ViewRoot)this.getLimitAccount());
        if(this.getLimitAccount() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getLimitAccount() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getLimitAccount() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getLimitAccount() != null && this.getLimitAccount().equals(child)) return result;
        if(this.getLimitAccount() != null) result = result + 1;
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
