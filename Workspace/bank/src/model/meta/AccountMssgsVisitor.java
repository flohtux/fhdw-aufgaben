package model.meta;

public interface AccountMssgsVisitor extends AccountDOWNMssgsVisitor, AccountUPMssgsVisitor {}


interface AccountDOWNMssgsVisitor  {

    public void handleAccountCreateDebitGrantAccountLimitTypeMssg(AccountCreateDebitGrantAccountLimitTypeMssg event) throws persistence.PersistenceException;
    
}


interface AccountUPMssgsVisitor  {

    public void handleAccountCreateDebitGrantAccountLimitTypeMssg(AccountCreateDebitGrantAccountLimitTypeMssg event) throws persistence.PersistenceException;
    
}
