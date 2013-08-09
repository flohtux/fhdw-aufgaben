package model.meta;

public interface FrankenMssgs {
    void accept(FrankenMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FrankenDOWNMssgs extends CurrencyDOWNMssgs, FrankenMssgs{}
interface FrankenUPMssgs extends Mssgs, FrankenMssgs{}
