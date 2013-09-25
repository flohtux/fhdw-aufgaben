
package view.objects;

import view.AccountView;
import view.DebitTransferStateView;
import view.DebitTransferTransactionView;
import view.ModelException;


/* Additional import section end */

public abstract class DebitTransferTransaction extends ViewObject implements DebitTransferTransactionView{
    
    protected java.util.Date timestamp;
    protected String subject;
    protected AccountView sender;
    protected DebitTransferStateView state;
    
    public DebitTransferTransaction(java.util.Date timestamp,String subject,AccountView sender,DebitTransferStateView state,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.timestamp = timestamp;
        this.subject = subject;
        this.sender = sender;
        this.state = state;        
    }
    
    public java.util.Date getTimestamp()throws ModelException{
        return this.timestamp;
    }
    public void setTimestamp(java.util.Date newValue) throws ModelException {
        this.timestamp = newValue;
    }
    public String getSubject()throws ModelException{
        return this.subject;
    }
    public void setSubject(String newValue) throws ModelException {
        this.subject = newValue;
    }
    public AccountView getSender()throws ModelException{
        return this.sender;
    }
    public void setSender(AccountView newValue) throws ModelException {
        this.sender = newValue;
    }
    public DebitTransferStateView getState()throws ModelException{
        return this.state;
    }
    public void setState(DebitTransferStateView newValue) throws ModelException {
        this.state = newValue;
    }
    
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AccountView sender = this.getSender();
        if (sender != null) {
            ((ViewProxi)sender).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(sender.getClassId(), sender.getId())));
        }
        DebitTransferStateView state = this.getState();
        if (state != null) {
            ((ViewProxi)state).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(state.getClassId(), state.getId())));
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
    public int getTimestampIndex() throws ModelException {
        return 0;
    }
    public int getSubjectIndex() throws ModelException {
        return 0 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "Zeitstempel";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "Betreff";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return ViewRoot.toString(getTimestamp(), true );
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getSubject();
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
            this.setTimestamp(new java.text.SimpleDateFormat(TIMESTAMPFORMAT).parse(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setSubject(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
