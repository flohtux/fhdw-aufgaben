package model.meta;

public interface CurrencyMssgsVisitor extends CurrencyDOWNMssgsVisitor, CurrencyUPMssgsVisitor {}


interface CurrencyDOWNMssgsVisitor extends EuroDOWNMssgsVisitor, DollarDOWNMssgsVisitor {

    
}


interface CurrencyUPMssgsVisitor  {

    
}
