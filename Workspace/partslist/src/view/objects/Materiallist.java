
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Materiallist extends ViewObject implements MateriallistView{
    
    protected java.util.Vector<MateriallistValueView> values;
    
    public Materiallist(java.util.Vector<MateriallistValueView> values,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.values = values;        
    }
    
    static public long getTypeId() {
        return 111;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<MateriallistValueView> getValues()throws ModelException{
        return this.values;
    }
    public void setValues(java.util.Vector<MateriallistValueView> newValue) throws ModelException {
        this.values = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMateriallist(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMateriallist(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMateriallist(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMateriallist(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> values = this.getValues();
        if (values != null) {
            ViewObject.resolveVectorProxies(values, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getValues().size()) return new ValuesMateriallistWrapper(this, originalIndex, (ViewRoot)this.getValues().get(index));
        index = index - this.getValues().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getValues().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getValues().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getValuesIterator = this.getValues().iterator();
        while(getValuesIterator.hasNext()){
            if(getValuesIterator.next().equals(child)) return result;
            result = result + 1;
        }
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
