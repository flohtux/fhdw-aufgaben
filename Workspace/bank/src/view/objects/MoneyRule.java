
package view.objects;

import view.AmountView;
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
    protected AmountView minLimit;
    protected AmountView maxLimit;
    
    public MoneyRule(CurrencyView currency,AmountView minLimit,AmountView maxLimit,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.currency = currency;
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;        
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
    public AmountView getMinLimit()throws ModelException{
        return this.minLimit;
    }
    public void setMinLimit(AmountView newValue) throws ModelException {
        this.minLimit = newValue;
    }
    public AmountView getMaxLimit()throws ModelException{
        return this.maxLimit;
    }
    public void setMaxLimit(AmountView newValue) throws ModelException {
        this.maxLimit = newValue;
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
        AmountView minLimit = this.getMinLimit();
        if (minLimit != null) {
            ((ViewProxi)minLimit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(minLimit.getClassId(), minLimit.getId())));
        }
        AmountView maxLimit = this.getMaxLimit();
        if (maxLimit != null) {
            ((ViewProxi)maxLimit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(maxLimit.getClassId(), maxLimit.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getMinLimit() != null && index < this.getMinLimit().getTheObject().getChildCount())
            return this.getMinLimit().getTheObject().getChild(index);
        if(this.getMinLimit() != null) index = index - this.getMinLimit().getTheObject().getChildCount();
        if(this.getMaxLimit() != null && index < this.getMaxLimit().getTheObject().getChildCount())
            return this.getMaxLimit().getTheObject().getChild(index);
        if(this.getMaxLimit() != null) index = index - this.getMaxLimit().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMinLimit() == null ? 0 : this.getMinLimit().getTheObject().getChildCount())
            + (this.getMaxLimit() == null ? 0 : this.getMaxLimit().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMinLimit() == null ? true : this.getMinLimit().getTheObject().isLeaf())
            && (this.getMaxLimit() == null ? true : this.getMaxLimit().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMinLimit() != null && this.getMinLimit().equals(child)) return result;
        if(this.getMinLimit() != null) result = result + 1;
        if(this.getMaxLimit() != null && this.getMaxLimit().equals(child)) return result;
        if(this.getMaxLimit() != null) result = result + 1;
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
