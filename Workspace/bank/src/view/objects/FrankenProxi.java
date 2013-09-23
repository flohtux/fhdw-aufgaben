package view.objects;

import view.FrankenView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.CurrencyExceptionVisitor;
import view.visitor.CurrencyReturnExceptionVisitor;
import view.visitor.CurrencyReturnVisitor;
import view.visitor.CurrencyVisitor;
import viewClient.ExceptionAndEventHandler;

public class FrankenProxi extends CurrencyProxi implements FrankenView{
    
    public FrankenProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public FrankenView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        FrankenView result$$ = new Franken( this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
    
    
    public void accept(CurrencyVisitor visitor) throws ModelException {
        visitor.handleFranken(this);
    }
    public <R> R accept(CurrencyReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFranken(this);
    }
    public <E extends UserException>  void accept(CurrencyExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFranken(this);
    }
    public <R, E extends UserException> R accept(CurrencyReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFranken(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFranken(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFranken(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFranken(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFranken(this);
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
