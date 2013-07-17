package model.meta;

public interface EuroMssgs {
    void accept(EuroMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface EuroDOWNMssgs extends CurrencyDOWNMssgs, EuroMssgs{}
interface EuroUPMssgs extends Mssgs, EuroMssgs{}
