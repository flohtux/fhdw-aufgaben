package model.meta;

public interface ServiceMssgs {
    void accept(ServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ServiceDOWNMssgs extends Mssgs, ServiceMssgs{}
interface ServiceUPMssgs extends AdministratorUPMssgs, BankServiceUPMssgs, AccountServiceUPMssgs, ServiceMssgs{}
