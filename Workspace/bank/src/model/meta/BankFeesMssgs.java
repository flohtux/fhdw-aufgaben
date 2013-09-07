package model.meta;

public interface BankFeesMssgs {
    void accept(BankFeesMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BankFeesDOWNMssgs extends Mssgs, BankFeesMssgs{}
interface BankFeesUPMssgs extends Mssgs, BankFeesMssgs{}
