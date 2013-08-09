package model.meta;

public interface CurrencyMssgs {
    void accept(CurrencyMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CurrencyDOWNMssgs extends Mssgs, CurrencyMssgs{}
interface CurrencyUPMssgs extends EuroUPMssgs, YenUPMssgs, PfundUPMssgs, DollarUPMssgs, FrankenUPMssgs, CurrencyMssgs{}
