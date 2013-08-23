package model.meta;

public interface YenMssgs {
    void accept(YenMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface YenDOWNMssgs extends CurrencyDOWNMssgs, YenMssgs{}
interface YenUPMssgs extends Mssgs, YenMssgs{}
