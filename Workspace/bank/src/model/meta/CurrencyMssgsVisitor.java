package model.meta;

public interface CurrencyMssgsVisitor extends CurrencyDOWNMssgsVisitor, CurrencyUPMssgsVisitor {}


interface CurrencyDOWNMssgsVisitor extends EuroDOWNMssgsVisitor, YenDOWNMssgsVisitor, PfundDOWNMssgsVisitor, DollarDOWNMssgsVisitor, FrankenDOWNMssgsVisitor {

    
}


interface CurrencyUPMssgsVisitor  {

    
}
