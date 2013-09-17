package model.meta;

public interface BankOwnAccountPxMssgs {
    void accept(BankOwnAccountPxMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BankOwnAccountPxDOWNMssgs extends Mssgs, BankOwnAccountPxMssgs{}
interface BankOwnAccountPxUPMssgs extends Mssgs, BankOwnAccountPxMssgs{}
