package model.meta;

public interface MoneyMssgsVisitor extends MoneyDOWNMssgsVisitor, MoneyUPMssgsVisitor {}


interface MoneyDOWNMssgsVisitor  {

    public void handleMoneyAddMoneyMssg(MoneyAddMoneyMssg event) throws persistence.PersistenceException;
    
}


interface MoneyUPMssgsVisitor  {

    public void handleMoneyAddMoneyMssg(MoneyAddMoneyMssg event) throws persistence.PersistenceException;
    
}
