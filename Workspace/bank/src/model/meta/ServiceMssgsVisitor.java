package model.meta;

public interface ServiceMssgsVisitor extends ServiceDOWNMssgsVisitor, ServiceUPMssgsVisitor {}


interface ServiceDOWNMssgsVisitor extends AdministratorDOWNMssgsVisitor, BankServiceDOWNMssgsVisitor, AccountServiceDOWNMssgsVisitor {

    
}


interface ServiceUPMssgsVisitor  {

    
}
