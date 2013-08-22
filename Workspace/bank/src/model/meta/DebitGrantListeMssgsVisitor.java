package model.meta;

public interface DebitGrantListeMssgsVisitor extends DebitGrantListeDOWNMssgsVisitor, DebitGrantListeUPMssgsVisitor {}


interface DebitGrantListeDOWNMssgsVisitor  {

    public void handleDebitGrantListeCreateDebitGrantAccountLimitTypeMssg(DebitGrantListeCreateDebitGrantAccountLimitTypeMssg event) throws persistence.PersistenceException;
    
}


interface DebitGrantListeUPMssgsVisitor  {

    public void handleDebitGrantListeCreateDebitGrantAccountLimitTypeMssg(DebitGrantListeCreateDebitGrantAccountLimitTypeMssg event) throws persistence.PersistenceException;
    
}
