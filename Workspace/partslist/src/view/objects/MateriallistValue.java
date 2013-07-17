
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class MateriallistValue extends ViewObject implements MateriallistValueView{
    
    protected MaterialView material;
    protected long amount;
    
    public MateriallistValue(MaterialView material,long amount,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.material = material;
        this.amount = amount;        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public MaterialView getMaterial()throws ModelException{
        return this.material;
    }
    public void setMaterial(MaterialView newValue) throws ModelException {
        this.material = newValue;
    }
    public long getAmount()throws ModelException{
        return this.amount;
    }
    public void setAmount(long newValue) throws ModelException {
        this.amount = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMateriallistValue(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMateriallistValue(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMateriallistValue(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMateriallistValue(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        MaterialView material = this.getMaterial();
        if (material != null) {
            ((ViewProxi)material).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(material.getClassId(), material.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getMaterial() != null && index < this.getMaterial().getTheObject().getChildCount())
            return this.getMaterial().getTheObject().getChild(index);
        if(this.getMaterial() != null) index = index - this.getMaterial().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMaterial() == null ? 0 : this.getMaterial().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMaterial() == null ? true : this.getMaterial().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMaterial() != null && this.getMaterial().equals(child)) return result;
        if(this.getMaterial() != null) result = result + 1;
        return -1;
    }
    public int getAmountIndex() throws ModelException {
        return 0 + (this.getMaterial() == null ? 0 : 1);
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
