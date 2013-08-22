package model.meta;

public interface DebitGrantListeMssgsVisitor extends DebitGrantListeDOWNMssgsVisitor, DebitGrantListeUPMssgsVisitor {}


interface DebitGrantListeDOWNMssgsVisitor  {

    public void handleDebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg(DebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg event) throws persistence.PersistenceException;
    
}


interface DebitGrantListeUPMssgsVisitor  {

    public void handleDebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg(DebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg event) throws persistence.PersistenceException;
    
}
