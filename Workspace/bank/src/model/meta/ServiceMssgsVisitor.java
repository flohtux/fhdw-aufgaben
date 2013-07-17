package model.meta;

public interface ServiceMssgsVisitor extends ServiceDOWNMssgsVisitor, ServiceUPMssgsVisitor {}


interface ServiceDOWNMssgsVisitor extends AccountServiceDOWNMssgsVisitor, AdministratorDOWNMssgsVisitor, BankServiceDOWNMssgsVisitor {

    
}


interface ServiceUPMssgsVisitor  {

    
}
