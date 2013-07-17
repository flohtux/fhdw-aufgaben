package model.meta;

public interface AmountMssgs {
    void accept(AmountMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AmountDOWNMssgs extends Mssgs, AmountMssgs{}
interface AmountUPMssgs extends Mssgs, AmountMssgs{}
