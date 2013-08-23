package model.meta;

public interface PfundMssgs {
    void accept(PfundMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface PfundDOWNMssgs extends CurrencyDOWNMssgs, PfundMssgs{}
interface PfundUPMssgs extends Mssgs, PfundMssgs{}
