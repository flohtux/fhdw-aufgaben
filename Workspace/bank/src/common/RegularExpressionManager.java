package common;

import expressions.RegularExpressionHandler;

public class RegularExpressionManager {

    public static RegularExpressionHandler currencySUBTYPEName = new RegularExpressionHandler( "[(Dollar)" + 
		"(Franken)" + 
		"(Pfund)" + 
		"(Euro)" + 
		"(Yen)]" );
    public static RegularExpressionHandler transactionFeeSUBTYPEName = new RegularExpressionHandler( "[(FixTransactionFee)" + 
		"(MixedFee)" + 
		"(ProcentualFee)]" );
    

}
