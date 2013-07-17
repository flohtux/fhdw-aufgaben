package model.meta;

public interface MoneyMssgs {
    void accept(MoneyMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MoneyDOWNMssgs extends Mssgs, MoneyMssgs{}
interface MoneyUPMssgs extends Mssgs, MoneyMssgs{}
