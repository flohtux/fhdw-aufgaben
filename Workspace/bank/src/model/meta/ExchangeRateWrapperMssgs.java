package model.meta;

public interface ExchangeRateWrapperMssgs {
    void accept(ExchangeRateWrapperMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ExchangeRateWrapperDOWNMssgs extends Mssgs, ExchangeRateWrapperMssgs{}
interface ExchangeRateWrapperUPMssgs extends Mssgs, ExchangeRateWrapperMssgs{}
