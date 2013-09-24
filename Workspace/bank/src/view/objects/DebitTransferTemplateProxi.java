package view.objects;

import view.DebitTransferTemplateView;
import view.DebitTransferTransactionView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import viewClient.ExceptionAndEventHandler;

public class DebitTransferTemplateProxi extends ViewProxi implements DebitTransferTemplateView{
    
    public DebitTransferTemplateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public DebitTransferTemplateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> templates_string = (java.util.Vector<String>)resultTable.get("templates");
        java.util.Vector<DebitTransferTransactionView> templates = ViewProxi.getProxiVector(templates_string, connectionKey);
        DebitTransferTemplateView result$$ = new DebitTransferTemplate(templates, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getTemplates().size()) return new TemplatesDebitTransferTemplateWrapper(this, originalIndex, (ViewRoot)this.getTemplates().get(index));
        index = index - this.getTemplates().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTemplates().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getTemplates().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTemplatesIterator = this.getTemplates().iterator();
        while(getTemplatesIterator.hasNext()){
            if(getTemplatesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<DebitTransferTransactionView> getTemplates()throws ModelException{
        return ((DebitTransferTemplate)this.getTheObject()).getTemplates();
    }
    public void setTemplates(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        ((DebitTransferTemplate)this.getTheObject()).setTemplates(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferTemplate(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferTemplate(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferTemplate(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferTemplate(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
