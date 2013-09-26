
package view.objects;

import view.AccountView;
import view.DebitTransferNoValue;
import view.DebitTransferPayedFeesView;
import view.DebitTransferStateView;
import view.DebitTransferTransactionView;
import view.ModelException;
import view.MoneyView;
import view.TransferView;
import view.TriggerValueView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.DebitTransferExceptionVisitor;
import view.visitor.DebitTransferNoValueExceptionVisitor;
import view.visitor.DebitTransferNoValueReturnExceptionVisitor;
import view.visitor.DebitTransferNoValueReturnVisitor;
import view.visitor.DebitTransferNoValueVisitor;
import view.visitor.DebitTransferReturnExceptionVisitor;
import view.visitor.DebitTransferReturnVisitor;
import view.visitor.DebitTransferTransactionExceptionVisitor;
import view.visitor.DebitTransferTransactionReturnExceptionVisitor;
import view.visitor.DebitTransferTransactionReturnVisitor;
import view.visitor.DebitTransferTransactionVisitor;
import view.visitor.DebitTransferVisitor;


/* Additional import section end */

public class Transfer extends view.objects.DebitTransfer implements TransferView{
    
    
    public Transfer(java.util.Date timestamp,String subject,AccountView sender,DebitTransferStateView state,long receiverAccountNumber,long receiverBankNumber,DebitTransferPayedFeesView payedFees,AccountView receiver,MoneyView money,TriggerValueView invokerTrigger,java.util.Vector<DebitTransferTransactionView> nextDebitTransferTransactionstriggers,DebitTransferNoValue previousDebitTransfer,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((java.util.Date)timestamp,(String)subject,(AccountView)sender,(DebitTransferStateView)state,(long)receiverAccountNumber,(long)receiverBankNumber,(DebitTransferPayedFeesView)payedFees,(AccountView)receiver,(MoneyView)money,(TriggerValueView)invokerTrigger,nextDebitTransferTransactionstriggers,(DebitTransferNoValue)previousDebitTransfer,id, classId);        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(DebitTransferVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitTransferReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitTransferExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(DebitTransferTransactionVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(DebitTransferNoValueVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitTransferNoValueReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitTransferNoValueExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitTransferNoValueReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
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
        DebitTransferPayedFeesView payedFees = this.getPayedFees();
        if (payedFees != null) {
            ((ViewProxi)payedFees).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(payedFees.getClassId(), payedFees.getId())));
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
        if(index == 0 && this.getPayedFees() != null) return new PayedFeesDebitTransferWrapper(this, originalIndex, (ViewRoot)this.getPayedFees());
        if(this.getPayedFees() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPayedFees() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getPayedFees() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getPayedFees() != null && this.getPayedFees().equals(child)) return result;
        if(this.getPayedFees() != null) result = result + 1;
        return -1;
    }
    public int getTimestampIndex() throws ModelException {
        return 0;
    }
    public int getSubjectIndex() throws ModelException {
        return 0 + 1;
    }
    public int getReceiverAccountNumberIndex() throws ModelException {
        return 0 + 1 + 1;
    }
    public int getReceiverBankNumberIndex() throws ModelException {
        return 0 + 1 + 1 + 1;
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
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
