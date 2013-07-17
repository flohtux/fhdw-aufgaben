package model.meta;

public interface BankMssgsVisitor extends BankDOWNMssgsVisitor, BankUPMssgsVisitor {}


interface BankDOWNMssgsVisitor  {

    public void handleBankChangeNameStringMssg(BankChangeNameStringMssg event) throws persistence.PersistenceException;
    
}


interface BankUPMssgsVisitor  {

    public void handleBankChangeNameStringMssg(BankChangeNameStringMssg event) throws persistence.PersistenceException;
    
}
