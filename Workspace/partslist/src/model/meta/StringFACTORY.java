package model.meta;

public class StringFACTORY{

    public static persistence.PersistentComponent createObjectBySubTypeNameForComponent(String name, ComponentSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("Produkt")) return switchAssistant.handleProduct();
        if(name.equals("Material")) return switchAssistant.handleMaterial();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
}
