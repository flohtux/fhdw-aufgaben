package model.meta;

public interface CurrencyMssgs {
    void accept(CurrencyMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CurrencyDOWNMssgs extends Mssgs, CurrencyMssgs{}
interface CurrencyUPMssgs extends DollarUPMssgs, FrankenUPMssgs, EuroUPMssgs, YenUPMssgs, PfundUPMssgs, CurrencyMssgs{}
