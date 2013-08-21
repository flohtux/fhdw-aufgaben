package model.meta;

public interface AccountServiceMssgsVisitor extends AccountServiceDOWNMssgsVisitor, AccountServiceUPMssgsVisitor {}


interface AccountServiceDOWNMssgsVisitor  {

    public void handleAccountServiceExecuteTransferDebitTransferMssg(AccountServiceExecuteTransferDebitTransferMssg event) throws persistence.PersistenceException;
    
}


interface AccountServiceUPMssgsVisitor extends ServiceUPMssgsVisitor {

    public void handleAccountServiceExecuteTransferDebitTransferMssg(AccountServiceExecuteTransferDebitTransferMssg event) throws persistence.PersistenceException;
    
}
