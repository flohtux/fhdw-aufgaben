
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class Server extends ViewObject implements ServerView{
    
    protected java.util.Vector<ComponentView> components;
    protected PartsListManagerView manager;
    protected java.util.Vector<ErrorDisplayView> errors;
    protected String user;
    
    public Server(java.util.Vector<ComponentView> components,PartsListManagerView manager,java.util.Vector<ErrorDisplayView> errors,String user,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.components = components;
        this.manager = manager;
        this.errors = errors;
        this.user = user;        
    }
    
    static public long getTypeId() {
        return -109;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ComponentView> getComponents()throws ModelException{
        return this.components;
    }
    public void setComponents(java.util.Vector<ComponentView> newValue) throws ModelException {
        this.components = newValue;
    }
    public PartsListManagerView getManager()throws ModelException{
        return this.manager;
    }
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException{
        return this.errors;
    }
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException {
        this.errors = newValue;
    }
    public String getUser()throws ModelException{
        return this.user;
    }
    public void setUser(String newValue) throws ModelException {
        this.user = newValue;
    }
    
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServer(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServer(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> components = this.getComponents();
        if (components != null) {
            ViewObject.resolveVectorProxies(components, resultTable);
        }
        PartsListManagerView manager = this.getManager();
        if (manager != null) {
            ((ViewProxi)manager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(manager.getClassId(), manager.getId())));
        }
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getComponents().size()) return new ComponentsServerWrapper(this, originalIndex, (ViewRoot)this.getComponents().get(index));
        index = index - this.getComponents().size();
        if(this.getManager() != null && index < this.getManager().getTheObject().getChildCount())
            return this.getManager().getTheObject().getChild(index);
        if(this.getManager() != null) index = index - this.getManager().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getComponents().size())
            + (this.getManager() == null ? 0 : this.getManager().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getComponents().size() == 0)
            && (this.getManager() == null ? true : this.getManager().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getComponentsIterator = this.getComponents().iterator();
        while(getComponentsIterator.hasNext()){
            if(getComponentsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getManager() != null && this.getManager().equals(child)) return result;
        if(this.getManager() != null) result = result + 1;
        return -1;
    }
    public int getUserIndex() throws ModelException {
        return 0 + this.getComponents().size() + (this.getManager() == null ? 0 : 1);
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "user";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getUser();
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
            this.setUser(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public ServerConnection connectServer(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        ServerConnection result;
		try {
			result = (ServerConnection) new ServerConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
