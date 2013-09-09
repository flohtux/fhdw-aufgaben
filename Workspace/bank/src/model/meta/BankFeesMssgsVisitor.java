package model.meta;

public interface BankFeesMssgsVisitor extends BankFeesDOWNMssgsVisitor, BankFeesUPMssgsVisitor {}


interface BankFeesDOWNMssgsVisitor  {

    public void handleBankFeesChangeInternalFeeInternalFeeMssg(BankFeesChangeInternalFeeInternalFeeMssg event) throws persistence.PersistenceException;
    public void handleBankFeesChangeTransactionFeeTransactionFeeMssg(BankFeesChangeTransactionFeeTransactionFeeMssg event) throws persistence.PersistenceException;
    
}


interface BankFeesUPMssgsVisitor  {

    public void handleBankFeesChangeInternalFeeInternalFeeMssg(BankFeesChangeInternalFeeInternalFeeMssg event) throws persistence.PersistenceException;
    public void handleBankFeesChangeTransactionFeeTransactionFeeMssg(BankFeesChangeTransactionFeeTransactionFeeMssg event) throws persistence.PersistenceException;
    
}
