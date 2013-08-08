package model.meta;

public interface CurrencyManagerMssgs {
    void accept(CurrencyManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CurrencyManagerDOWNMssgs extends Mssgs, CurrencyManagerMssgs{}
interface CurrencyManagerUPMssgs extends Mssgs, CurrencyManagerMssgs{}
