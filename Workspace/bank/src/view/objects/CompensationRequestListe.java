
package view.objects;

import view.CompensationRequestListeView;
import view.CompensationRequestView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class CompensationRequestListe extends ViewObject implements CompensationRequestListeView{
    
    protected java.util.Vector<CompensationRequestView> compensationrequests;
    
    public CompensationRequestListe(java.util.Vector<CompensationRequestView> compensationrequests,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.compensationrequests = compensationrequests;        
    }
    
    static public long getTypeId() {
        return 260;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<CompensationRequestView> getCompensationrequests()throws ModelException{
        return this.compensationrequests;
    }
    public void setCompensationrequests(java.util.Vector<CompensationRequestView> newValue) throws ModelException {
        this.compensationrequests = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompensationRequestListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompensationRequestListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompensationRequestListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompensationRequestListe(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> compensationrequests = this.getCompensationrequests();
        if (compensationrequests != null) {
            ViewObject.resolveVectorProxies(compensationrequests, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getCompensationrequests().size()) return new CompensationrequestsCompensationRequestListeWrapper(this, originalIndex, (ViewRoot)this.getCompensationrequests().get(index));
        index = index - this.getCompensationrequests().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCompensationrequests().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getCompensationrequests().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getCompensationrequestsIterator = this.getCompensationrequests().iterator();
        while(getCompensationrequestsIterator.hasNext()){
            if(getCompensationrequestsIterator.next().equals(child)) return result;
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
