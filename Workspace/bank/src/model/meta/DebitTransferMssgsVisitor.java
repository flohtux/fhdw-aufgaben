package model.meta;

public interface DebitTransferMssgsVisitor extends DebitTransferDOWNMssgsVisitor, DebitTransferUPMssgsVisitor {}


interface DebitTransferDOWNMssgsVisitor extends TransferDOWNMssgsVisitor, DebitDOWNMssgsVisitor {

    public void handleDebitTransferChangeCurrencyCurrencyMssg(DebitTransferChangeCurrencyCurrencyMssg event) throws persistence.PersistenceException;
    public void handleDebitTransferChangeMoneyFractionMssg(DebitTransferChangeMoneyFractionMssg event) throws persistence.PersistenceException;
    public void handleDebitTransferChangeReceiverAccountIntegerMssg(DebitTransferChangeReceiverAccountIntegerMssg event) throws persistence.PersistenceException;
    public void handleDebitTransferChangeReceiverBankIntegerMssg(DebitTransferChangeReceiverBankIntegerMssg event) throws persistence.PersistenceException;
    
}


interface DebitTransferUPMssgsVisitor extends DebitTransferTransactionUPMssgsVisitor, DebitTransferNoValueUPMssgsVisitor {

    public void handleDebitTransferChangeCurrencyCurrencyMssg(DebitTransferChangeCurrencyCurrencyMssg event) throws persistence.PersistenceException;
    public void handleDebitTransferChangeMoneyFractionMssg(DebitTransferChangeMoneyFractionMssg event) throws persistence.PersistenceException;
    public void handleDebitTransferChangeReceiverAccountIntegerMssg(DebitTransferChangeReceiverAccountIntegerMssg event) throws persistence.PersistenceException;
    public void handleDebitTransferChangeReceiverBankIntegerMssg(DebitTransferChangeReceiverBankIntegerMssg event) throws persistence.PersistenceException;
    
}
