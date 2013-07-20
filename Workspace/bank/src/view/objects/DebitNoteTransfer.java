
package view.objects;

import view.*;


/* Additional import section end */

public abstract class DebitNoteTransfer extends view.objects.DebitNoteTransferTransaction implements DebitNoteTransferView{
    
    protected AccountView sender;
    protected AccountView receiver;
    protected MoneyView money;
    
    public DebitNoteTransfer(AccountView sender,AccountView receiver,MoneyView money,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.sender = sender;
        this.receiver = receiver;
        this.money = money;        
    }
    
    public AccountView getSender()throws ModelException{
        return this.sender;
    }
    public void setSender(AccountView newValue) throws ModelException {
        this.sender = newValue;
    }
    public AccountView getReceiver()throws ModelException{
        return this.receiver;
    }
    public void setReceiver(AccountView newValue) throws ModelException {
        this.receiver = newValue;
    }
    public MoneyView getMoney()throws ModelException{
        return this.money;
    }
    public void setMoney(MoneyView newValue) throws ModelException {
        this.money = newValue;
    }
    
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AccountView sender = this.getSender();
        if (sender != null) {
            ((ViewProxi)sender).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(sender.getClassId(), sender.getId())));
        }
        AccountView receiver = this.getReceiver();
        if (receiver != null) {
            ((ViewProxi)receiver).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(receiver.getClassId(), receiver.getId())));
        }
        MoneyView money = this.getMoney();
        if (money != null) {
            ((ViewProxi)money).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(money.getClassId(), money.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getSender() != null) return new SenderDebitNoteTransferWrapper(this, originalIndex, (ViewRoot)this.getSender());
        if(this.getSender() != null) index = index - 1;
        if(index == 0 && this.getReceiver() != null) return new ReceiverDebitNoteTransferWrapper(this, originalIndex, (ViewRoot)this.getReceiver());
        if(this.getReceiver() != null) index = index - 1;
        if(index == 0 && this.getMoney() != null) return new MoneyDebitNoteTransferWrapper(this, originalIndex, (ViewRoot)this.getMoney());
        if(this.getMoney() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSender() == null ? 0 : 1)
            + (this.getReceiver() == null ? 0 : 1)
            + (this.getMoney() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSender() == null ? true : false)
            && (this.getReceiver() == null ? true : false)
            && (this.getMoney() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSender() != null && this.getSender().equals(child)) return result;
        if(this.getSender() != null) result = result + 1;
        if(this.getReceiver() != null && this.getReceiver().equals(child)) return result;
        if(this.getReceiver() != null) result = result + 1;
        if(this.getMoney() != null && this.getMoney().equals(child)) return result;
        if(this.getMoney() != null) result = result + 1;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
