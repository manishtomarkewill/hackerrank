package edu.njit.cs602.assignments;

import java.util.Scanner;

public class CashRegister {
	private int [] numUnits = new int[CurrencyUnitType.values().length];
	private static boolean flag=true;
	private static float change;
	private static float totalPaid;

    public enum CurrencyUnitType {
        PENNY("pennies"), DIME("dimes"), QUARTER("quarters"),
        ONE_DOLLAR("one dollar bills"), TEN_DOLLAR("ten dollar bills"),
        TWENTY_DOLLAR("twenty dollar bills");

        private final String desc;

        CurrencyUnitType(String desc) {
            this.desc = desc;
        }

        public String toString() { return desc; }
    }

    /**
     * Constructor
     * @param units number of units of each currency unit type
     */
    public CashRegister(int [] units) {
         for (int i=0;i<CurrencyUnitType.values().length;i++) {
             numUnits[i]=units[i];
         }
    }

    /**
     *  Display cash register.
     */
    public void display() {
    	System.out.println("------------------------------");
    	for (CurrencyUnitType unitType: CurrencyUnitType.values()) {
            System.out.println("Number of "+unitType.toString()+ " :"+numUnits[unitType.ordinal()]);
        }
    }

    /**
     * Display units The display format example:
     *  5 Quarters, 10 one dollar bills
     *  Omit currency units with 0 values
     * @param units to display
     */
    public static void display(int [] units) {
    	System.out.println("-------------Balance--------------");
    	if(flag && (change==0)){
    		System.out.println("Zero change ");
    	}else if(flag ){
    		for (CurrencyUnitType unitType: CurrencyUnitType.values()) {
                System.out.println(units[unitType.ordinal()]+"  "+unitType.toString());
            }
    	}else{
    			System.out.println("Cannot break change for " + Math.abs(change));
        }
    }

    /**
     * Add units of a currency unit type
     * @param unitType currency unit type
     * @param numUnits number of units
     */
    public void add(CurrencyUnitType unitType, int numUnits) {
    	if(unitType.equals(CurrencyUnitType.PENNY)){
    		this.numUnits[0]=this.numUnits[0]+numUnits;
    	}
    	else if(unitType.equals(CurrencyUnitType.DIME)){
    		this.numUnits[1]=this.numUnits[1]+numUnits;
    	}
    	else if(unitType.equals(CurrencyUnitType.QUARTER)){
    		this.numUnits[2]=this.numUnits[2]+numUnits;
    	}
    	else if(unitType.equals(CurrencyUnitType.ONE_DOLLAR)){
    		this.numUnits[3]=this.numUnits[3]+numUnits;
    	}
    	else if(unitType.equals(CurrencyUnitType.TEN_DOLLAR)){
    		this.numUnits[4]=this.numUnits[4]+numUnits;
    	}
    	else if(unitType.equals(CurrencyUnitType.TWENTY_DOLLAR)){
    		this.numUnits[5]=this.numUnits[5]+numUnits;
    	}
    }

    /**
     * Remove units if a currency unit type
     * @param unitType currency unit type
     * @param numUnits number of units
     * @return true if numUnits can be removed else false; in the latter case do not remove any units
     */
    public boolean remove(CurrencyUnitType unitType, int numUnits) { 
    	if(unitType.equals(CurrencyUnitType.PENNY)){
    		this.numUnits[0]=this.numUnits[0]-numUnits;
    	}
    	else if(unitType.equals(CurrencyUnitType.DIME)){
    		this.numUnits[1]=this.numUnits[1]-numUnits;
    	}
    	else if(unitType.equals(CurrencyUnitType.QUARTER)){
    		this.numUnits[2]=this.numUnits[2]-numUnits;
    	}
    	else if(unitType.equals(CurrencyUnitType.ONE_DOLLAR)){
    		this.numUnits[3]=this.numUnits[3]-numUnits;
    	}
    	else if(unitType.equals(CurrencyUnitType.TEN_DOLLAR)){
    		this.numUnits[4]=this.numUnits[4]-numUnits;
    	}
    	else if(unitType.equals(CurrencyUnitType.TWENTY_DOLLAR)){
    		this.numUnits[5]=this.numUnits[5]-numUnits;
    	}
    	for (int i=0;i<CurrencyUnitType.values().length;i++) {
    	    if(this.numUnits[i]<0){
    		    return false;
    	    }
    	}
    	 return true;
   }

    /**
     * Give change back for the difference between price and paid amount
     * @param price price of item to pay for
     * @param paidUnits currency units paid
     * @return currency units for difference or the paidUnits if we cannot make change
     */
    public int [] changeBack(float price, int [] paidUnits) {
    	totalPaid=amount(paidUnits);
    	int [] returnBack =new int[CurrencyUnitType.values().length];
    	float [] denominations={.01f,0.1f,0.25f,1,10,20};
    	change=totalPaid-price;;
    	float returnChange=change;
    	
    	if(change!=0){
    		for(int i=5;i>=0;i--){
        		if(returnChange>=denominations[i]){
        			int div=(int) ((float)returnChange/denominations[i]);
            		if(div<=numUnits[i]){
            			returnBack[i]=div;
            			returnChange=(float)Math.round(returnChange%denominations[i]*100)/100;
            		}else{
            			returnBack[i]=numUnits[i];
            			returnChange=(float)Math.round((returnChange%denominations[i]+(div-numUnits[i])*denominations[i])*100)/100;
            			if(i==0){
            				flag=false;
            				break;
            			}
            		}
        		}
        	}
    		if(flag){
    			add(CurrencyUnitType.PENNY,paidUnits[0]);
            	add(CurrencyUnitType.DIME,paidUnits[1]);
            	add(CurrencyUnitType.QUARTER,paidUnits[2]);
            	add(CurrencyUnitType.ONE_DOLLAR,paidUnits[3]);
            	add(CurrencyUnitType.TEN_DOLLAR,paidUnits[4]);
            	add(CurrencyUnitType.TWENTY_DOLLAR,paidUnits[5]);
            	
            	remove(CurrencyUnitType.PENNY,returnBack[0]);
            	remove(CurrencyUnitType.DIME,returnBack[1]);
            	remove(CurrencyUnitType.QUARTER,returnBack[2]);
            	remove(CurrencyUnitType.ONE_DOLLAR,returnBack[3]);
            	remove(CurrencyUnitType.TEN_DOLLAR,returnBack[4]);
            	remove(CurrencyUnitType.TWENTY_DOLLAR,returnBack[5]);
    		}
    	}
        return returnBack;
    }

    /**
     * Convert to amount
     * @param units number of units of different currency units
     * @return amount in dollars and cents
     */
    public static float amount(int [] units) { 
    	totalPaid=(float)units[0]/100+(float)(10*units[1])/100+(float)(25*units[2])/100+units[3]+10*units[4]+20*units[5];
    	return totalPaid; }

    /**
     * If the units given by units1 and units2 give the same amount
     * @param units1 first bag of units
     * @param units2 second bag of units
     * @return true if same amount else false
     */
    public static boolean sameAmount(int [] units1, int [] units2) { 
    	for (int i=0;i<CurrencyUnitType.values().length;i++) {
    		if(units1[i]!=0)
    			return false;
    	}
    	return true; }


    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        // get initial values of currency units in the cash register
        int [] nUnits = new int[CurrencyUnitType.values().length];
        for (CurrencyUnitType unitType: CurrencyUnitType.values()) {
            System.out.print(unitType.toString()+ " :");
            nUnits[unitType.ordinal()] = scanner.nextInt();
        }

        // Create a CashRegister object with these initial values
        CashRegister register = new CashRegister(nUnits);

        // Call other methods on the object to test
        register.display();

        display(register.changeBack(7.5f,new int [] { 0, 5, 0, 0, 10, 0 }));

        float price = 10.25f;
        int [] paidUnits = new int [] { 0, 5, 1, 0, 10, 0 };
        int [] changeBack = register.changeBack(price,paidUnits);
        if (sameAmount(changeBack,paidUnits)) {
            System.out.println("Cannot break change for " + (amount(paidUnits)-price));
        } else {
            display(changeBack);
        }

        register.add(CurrencyUnitType.QUARTER,50);
        register.display();

        System.out.println("Units removed:" + register.remove(CurrencyUnitType.DIME,10));

    }

}
