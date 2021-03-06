
package view.objects;

import view.FixTransactionFeeView;
import view.MixedFeeView;
import view.ModelException;
import view.MoneyView;
import view.ProcentualFeeView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.TransactionFeeExceptionVisitor;
import view.visitor.TransactionFeeReturnExceptionVisitor;
import view.visitor.TransactionFeeReturnVisitor;
import view.visitor.TransactionFeeVisitor;


/* Additional import section end */

public class MixedFee extends view.objects.TransactionFee implements MixedFeeView{
    
    protected FixTransactionFeeView fix;
    protected ProcentualFeeView procentual;
    protected MoneyView limit;
    
    public MixedFee(FixTransactionFeeView fix,ProcentualFeeView procentual,MoneyView limit,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.fix = fix;
        this.procentual = procentual;
        this.limit = limit;        
    }
    
    static public long getTypeId() {
        return 129;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public FixTransactionFeeView getFix()throws ModelException{
        return this.fix;
    }
    public void setFix(FixTransactionFeeView newValue) throws ModelException {
        this.fix = newValue;
    }
    public ProcentualFeeView getProcentual()throws ModelException{
        return this.procentual;
    }
    public void setProcentual(ProcentualFeeView newValue) throws ModelException {
        this.procentual = newValue;
    }
    public MoneyView getLimit()throws ModelException{
        return this.limit;
    }
    public void setLimit(MoneyView newValue) throws ModelException {
        this.limit = newValue;
    }
    
    public void accept(TransactionFeeVisitor visitor) throws ModelException {
        visitor.handleMixedFee(this);
    }
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMixedFee(this);
    }
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMixedFee(this);
    }
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMixedFee(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMixedFee(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMixedFee(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMixedFee(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMixedFee(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        FixTransactionFeeView fix = this.getFix();
        if (fix != null) {
            ((ViewProxi)fix).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(fix.getClassId(), fix.getId())));
        }
        ProcentualFeeView procentual = this.getProcentual();
        if (procentual != null) {
            ((ViewProxi)procentual).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(procentual.getClassId(), procentual.getId())));
        }
        MoneyView limit = this.getLimit();
        if (limit != null) {
            ((ViewProxi)limit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(limit.getClassId(), limit.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getFix() != null) return new FixMixedFeeWrapper(this, originalIndex, (ViewRoot)this.getFix());
        if(this.getFix() != null) index = index - 1;
        if(index == 0 && this.getProcentual() != null) return new ProcentualMixedFeeWrapper(this, originalIndex, (ViewRoot)this.getProcentual());
        if(this.getProcentual() != null) index = index - 1;
        if(index == 0 && this.getLimit() != null) return new LimitMixedFeeWrapper(this, originalIndex, (ViewRoot)this.getLimit());
        if(this.getLimit() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getFix() == null ? 0 : 1)
            + (this.getProcentual() == null ? 0 : 1)
            + (this.getLimit() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getFix() == null ? true : false)
            && (this.getProcentual() == null ? true : false)
            && (this.getLimit() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getFix() != null && this.getFix().equals(child)) return result;
        if(this.getFix() != null) result = result + 1;
        if(this.getProcentual() != null && this.getProcentual().equals(child)) return result;
        if(this.getProcentual() != null) result = result + 1;
        if(this.getLimit() != null && this.getLimit().equals(child)) return result;
        if(this.getLimit() != null) result = result + 1;
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
