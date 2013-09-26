
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class DebitGrantListePx extends ViewObject implements DebitGrantListePxView{
    
    protected DebitGrantListeView d1;
    
    public DebitGrantListePx(DebitGrantListeView d1,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.d1 = d1;        
    }
    
    static public long getTypeId() {
        return 286;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public DebitGrantListeView getD1()throws ModelException{
        return this.d1;
    }
    public void setD1(DebitGrantListeView newValue) throws ModelException {
        this.d1 = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitGrantListePx(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitGrantListePx(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitGrantListePx(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitGrantListePx(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        DebitGrantListeView d1 = this.getD1();
        if (d1 != null) {
            ((ViewProxi)d1).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(d1.getClassId(), d1.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getD1() != null && index < this.getD1().getTheObject().getChildCount())
            return this.getD1().getTheObject().getChild(index);
        if(this.getD1() != null) index = index - this.getD1().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getD1() == null ? 0 : this.getD1().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getD1() == null ? true : this.getD1().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getD1() != null && this.getD1().equals(child)) return result;
        if(this.getD1() != null) result = result + 1;
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
