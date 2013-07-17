
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Material extends view.objects.Component implements MaterialView{
    
    
    public Material(String name,StateView currentState,java.util.Vector<QPartView> partOf,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,(StateView)currentState,partOf,id, classId);        
    }
    
    static public long getTypeId() {
        return 106;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(ComponentVisitor visitor) throws ModelException {
        visitor.handleMaterial(this);
    }
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMaterial(this);
    }
    public <E extends UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMaterial(this);
    }
    public <R, E extends UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMaterial(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMaterial(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMaterial(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMaterial(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMaterial(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        StateView currentState = this.getCurrentState();
        if (currentState != null) {
            ((ViewProxi)currentState).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(currentState.getClassId(), currentState.getId())));
        }
        java.util.Vector<?> partOf = this.getPartOf();
        if (partOf != null) {
            ViewObject.resolveVectorProxies(partOf, resultTable);
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
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
            } else {
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
            this.setName(newValue);
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
