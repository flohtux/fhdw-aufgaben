
package view.objects;

import view.AccountView;
import view.DebitTransferNoValue;
import view.DebitTransferStateView;
import view.DebitTransferTransactionView;
import view.DebitTransferView;
import view.ModelException;
import view.MoneyView;
import view.TriggerValueView;


/* Additional import section end */

public abstract class DebitTransfer extends view.objects.DebitTransferTransaction implements DebitTransferView{
    
    protected long receiverAccountNumber;
    protected long receiverBankNumber;
    protected AccountView receiver;
    protected MoneyView money;
    protected TriggerValueView invokerTrigger;
    protected java.util.Vector<DebitTransferTransactionView> nextDebitTransferTransactionstriggers;
    protected DebitTransferNoValue previousDebitTransfer;
    
    public DebitTransfer(java.util.Date timestamp,String subject,AccountView sender,DebitTransferStateView state,long receiverAccountNumber,long receiverBankNumber,AccountView receiver,MoneyView money,TriggerValueView invokerTrigger,java.util.Vector<DebitTransferTransactionView> nextDebitTransferTransactionstriggers,DebitTransferNoValue previousDebitTransfer,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((java.util.Date)timestamp,(String)subject,(AccountView)sender,(DebitTransferStateView)state,id, classId);
        this.receiverAccountNumber = receiverAccountNumber;
        this.receiverBankNumber = receiverBankNumber;
        this.receiver = receiver;
        this.money = money;
        this.invokerTrigger = invokerTrigger;
        this.nextDebitTransferTransactionstriggers = nextDebitTransferTransactionstriggers;
        this.previousDebitTransfer = previousDebitTransfer;        
    }
    
    public long getReceiverAccountNumber()throws ModelException{
        return this.receiverAccountNumber;
    }
    public void setReceiverAccountNumber(long newValue) throws ModelException {
        this.receiverAccountNumber = newValue;
    }
    public long getReceiverBankNumber()throws ModelException{
        return this.receiverBankNumber;
    }
    public void setReceiverBankNumber(long newValue) throws ModelException {
        this.receiverBankNumber = newValue;
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
    public TriggerValueView getInvokerTrigger()throws ModelException{
        return this.invokerTrigger;
    }
    public void setInvokerTrigger(TriggerValueView newValue) throws ModelException {
        this.invokerTrigger = newValue;
    }
    public java.util.Vector<DebitTransferTransactionView> getNextDebitTransferTransactionstriggers()throws ModelException{
        return this.nextDebitTransferTransactionstriggers;
    }
    public void setNextDebitTransferTransactionstriggers(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        this.nextDebitTransferTransactionstriggers = newValue;
    }
    public DebitTransferNoValue getPreviousDebitTransfer()throws ModelException{
        return this.previousDebitTransfer;
    }
    public void setPreviousDebitTransfer(DebitTransferNoValue newValue) throws ModelException {
        this.previousDebitTransfer = newValue;
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
        AccountView receiver = this.getReceiver();
        if (receiver != null) {
            ((ViewProxi)receiver).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(receiver.getClassId(), receiver.getId())));
        }
        MoneyView money = this.getMoney();
        if (money != null) {
            ((ViewProxi)money).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(money.getClassId(), money.getId())));
        }
        TriggerValueView invokerTrigger = this.getInvokerTrigger();
        if (invokerTrigger != null) {
            ((ViewProxi)invokerTrigger).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(invokerTrigger.getClassId(), invokerTrigger.getId())));
        }
        java.util.Vector<?> nextDebitTransferTransactionstriggers = this.getNextDebitTransferTransactionstriggers();
        if (nextDebitTransferTransactionstriggers != null) {
            ViewObject.resolveVectorProxies(nextDebitTransferTransactionstriggers, resultTable);
        }
        DebitTransferNoValue previousDebitTransfer = this.getPreviousDebitTransfer();
        if (previousDebitTransfer != null) {
            ((ViewProxi)previousDebitTransfer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(previousDebitTransfer.getClassId(), previousDebitTransfer.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getState() != null) return new StateDebitTransferTransactionWrapper(this, originalIndex, (ViewRoot)this.getState());
        if(this.getState() != null) index = index - 1;
        if(index == 0 && this.getInvokerTrigger() != null) return new InvokerTriggerDebitTransferWrapper(this, originalIndex, (ViewRoot)this.getInvokerTrigger());
        if(this.getInvokerTrigger() != null) index = index - 1;
        if(index < this.getNextDebitTransferTransactionstriggers().size()) return new NextDebitTransferTransactionstriggersDebitTransferWrapper(this, originalIndex, (ViewRoot)this.getNextDebitTransferTransactionstriggers().get(index));
        index = index - this.getNextDebitTransferTransactionstriggers().size();
        if(index == 0 && this.getPreviousDebitTransfer() != null) return new PreviousDebitTransferDebitTransferWrapper(this, originalIndex, (ViewRoot)this.getPreviousDebitTransfer());
        if(this.getPreviousDebitTransfer() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getState() == null ? 0 : 1)
            + (this.getInvokerTrigger() == null ? 0 : 1)
            + (this.getNextDebitTransferTransactionstriggers().size())
            + (this.getPreviousDebitTransfer() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getState() == null ? true : false)
            && (this.getInvokerTrigger() == null ? true : false)
            && (this.getNextDebitTransferTransactionstriggers().size() == 0)
            && (this.getPreviousDebitTransfer() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getState() != null && this.getState().equals(child)) return result;
        if(this.getState() != null) result = result + 1;
        if(this.getInvokerTrigger() != null && this.getInvokerTrigger().equals(child)) return result;
        if(this.getInvokerTrigger() != null) result = result + 1;
        java.util.Iterator<?> getNextDebitTransferTransactionstriggersIterator = this.getNextDebitTransferTransactionstriggers().iterator();
        while(getNextDebitTransferTransactionstriggersIterator.hasNext()){
            if(getNextDebitTransferTransactionstriggersIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getPreviousDebitTransfer() != null && this.getPreviousDebitTransfer().equals(child)) return result;
        if(this.getPreviousDebitTransfer() != null) result = result + 1;
        return -1;
    }
    public int getTimestampIndex() throws ModelException {
        return 0;
    }
    public int getSubjectIndex() throws ModelException {
        return 0 + 1;
    }
    public int getReceiverAccountNumberIndex() throws ModelException {
        return 0 + 1 + 1 + (this.getState() == null ? 0 : 1);
    }
    public int getReceiverBankNumberIndex() throws ModelException {
        return 0 + 1 + 1 + (this.getState() == null ? 0 : 1) + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1
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
                if(rowIndex == 0) return "Empfänger Konto";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "Empfänger Bank";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return ViewRoot.toString(getTimestamp(), true );
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getSubject();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getReceiverAccountNumber());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getReceiverBankNumber());
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
        if(rowIndex == 0){
            this.setReceiverAccountNumber(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setReceiverBankNumber(Long.parseLong(newValue));
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
