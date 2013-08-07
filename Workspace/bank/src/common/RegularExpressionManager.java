package common;

import expressions.RegularExpressionHandler;

public class RegularExpressionManager {

    public static RegularExpressionHandler currencySUBTYPEName = new RegularExpressionHandler( "[(Dollar)" + 
		"(Euro)]" );
    public static RegularExpressionHandler transactionFeeSUBTYPEName = new RegularExpressionHandler( "[(FixTransactionFee)" + 
		"(MixedFee)" + 
		"(ProcentualFee)]" );
    

}
