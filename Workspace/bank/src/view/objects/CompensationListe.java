
package view.objects;

import view.CompensationListeView;
import view.CompensationView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class CompensationListe extends ViewObject implements CompensationListeView{
    
    protected java.util.Vector<CompensationView> compensations;
    
    public CompensationListe(java.util.Vector<CompensationView> compensations,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.compensations = compensations;        
    }
    
    static public long getTypeId() {
        return 259;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<CompensationView> getCompensations()throws ModelException{
        return this.compensations;
    }
    public void setCompensations(java.util.Vector<CompensationView> newValue) throws ModelException {
        this.compensations = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompensationListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompensationListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompensationListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompensationListe(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> compensations = this.getCompensations();
        if (compensations != null) {
            ViewObject.resolveVectorProxies(compensations, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getCompensations().size()) return new CompensationsCompensationListeWrapper(this, originalIndex, (ViewRoot)this.getCompensations().get(index));
        index = index - this.getCompensations().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCompensations().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getCompensations().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getCompensationsIterator = this.getCompensations().iterator();
        while(getCompensationsIterator.hasNext()){
            if(getCompensationsIterator.next().equals(child)) return result;
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
