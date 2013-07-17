package model.meta;

public interface BankServiceMssgs {
    void accept(BankServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BankServiceDOWNMssgs extends ServiceDOWNMssgs, BankServiceMssgs{}
interface BankServiceUPMssgs extends Mssgs, BankServiceMssgs{}
