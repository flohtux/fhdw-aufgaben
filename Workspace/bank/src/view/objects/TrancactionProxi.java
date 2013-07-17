package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TrancactionProxi extends DebitNoteTransactionProxi implements TrancactionView{
    
    public TrancactionProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public TrancactionView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long bankNumber = new Long((String)resultTable.get("bankNumber")).longValue();
        long accountNumber = new Long((String)resultTable.get("accountNumber")).longValue();
        ViewProxi money = null;
        String money$String = (String)resultTable.get("money");
        if (money$String != null) {
            common.ProxiInformation money$Info = common.RPCConstantsAndServices.createProxiInformation(money$String);
            money = view.objects.ViewProxi.createProxi(money$Info,connectionKey);
            money.setToString(money$Info.getToString());
        }
        TrancactionView result$$ = new Trancaction((long)bankNumber,(long)accountNumber,(MoneyView)money, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMoney() != null) return new MoneyDebitNoteTransactionWrapper(this, originalIndex, (ViewRoot)this.getMoney());
        if(this.getMoney() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMoney() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMoney() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMoney() != null && this.getMoney().equals(child)) return result;
        if(this.getMoney() != null) result = result + 1;
        return -1;
    }
    
    
    public void accept(DebitNoteTransactionVisitor visitor) throws ModelException {
        visitor.handleTrancaction(this);
    }
    public <R> R accept(DebitNoteTransactionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTrancaction(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransactionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTrancaction(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTrancaction(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTrancaction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTrancaction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTrancaction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTrancaction(this);
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
