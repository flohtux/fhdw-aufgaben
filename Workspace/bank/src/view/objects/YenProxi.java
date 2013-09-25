package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class YenProxi extends CurrencyProxi implements YenView{
    
    public YenProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public YenView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        YenView result$$ = new Yen( this.getId(), this.getClassId());
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
