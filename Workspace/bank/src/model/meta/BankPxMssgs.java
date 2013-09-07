package model.meta;

public interface BankPxMssgs {
    void accept(BankPxMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BankPxDOWNMssgs extends Mssgs, BankPxMssgs{}
interface BankPxUPMssgs extends Mssgs, BankPxMssgs{}
