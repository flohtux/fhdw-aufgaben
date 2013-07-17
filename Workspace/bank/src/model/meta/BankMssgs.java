package model.meta;

public interface BankMssgs {
    void accept(BankMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BankDOWNMssgs extends Mssgs, BankMssgs{}
interface BankUPMssgs extends Mssgs, BankMssgs{}
