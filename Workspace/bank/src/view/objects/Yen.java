
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Yen extends view.objects.Currency implements YenView{
    
    
    public Yen(long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);        
    }
    
    static public long getTypeId() {
        return 181;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(CurrencyVisitor visitor) throws ModelException {
        visitor.handleYen(this);
    }
    public <R> R accept(CurrencyReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleYen(this);
    }
    public <E extends UserException>  void accept(CurrencyExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleYen(this);
    }
    public <R, E extends UserException> R accept(CurrencyReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleYen(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleYen(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleYen(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleYen(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleYen(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        
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
