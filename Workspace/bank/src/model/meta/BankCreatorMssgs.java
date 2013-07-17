package model.meta;

public interface BankCreatorMssgs {
    void accept(BankCreatorMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BankCreatorDOWNMssgs extends Mssgs, BankCreatorMssgs{}
interface BankCreatorUPMssgs extends Mssgs, BankCreatorMssgs{}
