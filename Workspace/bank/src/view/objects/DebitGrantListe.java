
package view.objects;

import view.DebitGrantListeView;
import view.DebitGrantView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class DebitGrantListe extends ViewObject implements DebitGrantListeView{
    
    protected java.util.Vector<DebitGrantView> debitGrants;
    
    public DebitGrantListe(java.util.Vector<DebitGrantView> debitGrants,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.debitGrants = debitGrants;        
    }
    
    static public long getTypeId() {
        return 202;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<DebitGrantView> getDebitGrants()throws ModelException{
        return this.debitGrants;
    }
    public void setDebitGrants(java.util.Vector<DebitGrantView> newValue) throws ModelException {
        this.debitGrants = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitGrantListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitGrantListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitGrantListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitGrantListe(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> debitGrants = this.getDebitGrants();
        if (debitGrants != null) {
            ViewObject.resolveVectorProxies(debitGrants, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getDebitGrants().size()) return new DebitGrantsDebitGrantListeWrapper(this, originalIndex, (ViewRoot)this.getDebitGrants().get(index));
        index = index - this.getDebitGrants().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDebitGrants().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getDebitGrants().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getDebitGrantsIterator = this.getDebitGrants().iterator();
        while(getDebitGrantsIterator.hasNext()){
            if(getDebitGrantsIterator.next().equals(child)) return result;
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
