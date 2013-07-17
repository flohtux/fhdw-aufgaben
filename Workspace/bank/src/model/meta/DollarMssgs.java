package model.meta;

public interface DollarMssgs {
    void accept(DollarMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DollarDOWNMssgs extends CurrencyDOWNMssgs, DollarMssgs{}
interface DollarUPMssgs extends Mssgs, DollarMssgs{}
