package model.meta;

public interface CurrencyMssgsVisitor extends CurrencyDOWNMssgsVisitor, CurrencyUPMssgsVisitor {}


interface CurrencyDOWNMssgsVisitor extends DollarDOWNMssgsVisitor, FrankenDOWNMssgsVisitor, EuroDOWNMssgsVisitor, YenDOWNMssgsVisitor, PfundDOWNMssgsVisitor {

    
}


interface CurrencyUPMssgsVisitor  {

    
}
