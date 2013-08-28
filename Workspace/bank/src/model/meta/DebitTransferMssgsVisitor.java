package model.meta;

public interface DebitTransferMssgsVisitor extends DebitTransferDOWNMssgsVisitor, DebitTransferUPMssgsVisitor {}


interface DebitTransferDOWNMssgsVisitor extends TransferDOWNMssgsVisitor, DebitDOWNMssgsVisitor {

    public void handleDebitTransferChangeReceiverBankDebitTransferIntegerMssg(DebitTransferChangeReceiverBankDebitTransferIntegerMssg event) throws persistence.PersistenceException;
    
}


interface DebitTransferUPMssgsVisitor extends DebitTransferTransactionUPMssgsVisitor {

    public void handleDebitTransferChangeReceiverBankDebitTransferIntegerMssg(DebitTransferChangeReceiverBankDebitTransferIntegerMssg event) throws persistence.PersistenceException;
    
}
