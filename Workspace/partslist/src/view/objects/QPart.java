
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class QPart extends ViewObject implements QPartView{
    
    protected long amount;
    protected ComponentView component;
    protected ProductView master;
    
    public QPart(long amount,ComponentView component,ProductView master,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.amount = amount;
        this.component = component;
        this.master = master;        
    }
    
    static public long getTypeId() {
        return 105;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getAmount()throws ModelException{
        return this.amount;
    }
    public void setAmount(long newValue) throws ModelException {
        this.amount = newValue;
    }
    public ComponentView getComponent()throws ModelException{
        return this.component;
    }
    public void setComponent(ComponentView newValue) throws ModelException {
        this.component = newValue;
    }
    public ProductView getMaster()throws ModelException{
        return this.master;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleQPart(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQPart(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQPart(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQPart(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ComponentView component = this.getComponent();
        if (component != null) {
            ((ViewProxi)component).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(component.getClassId(), component.getId())));
        }
        ProductView master = this.getMaster();
        if (master != null) {
            ((ViewProxi)master).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(master.getClassId(), master.getId())));
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
    public int getAmountIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "amount";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getAmount());
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
            this.setAmount(Long.parseLong(newValue));
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
