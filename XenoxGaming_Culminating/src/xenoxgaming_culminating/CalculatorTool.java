/*************************************************
*Project: Calculator Tool
*Programmer: Amro AbedMoosa
*Date: 17/04/2021
*Program Name: CalculatorTool.java
*Description: This class will be used as a tool to calculate all totals, subtotals, tax, etc.
*************************************************/
package xenoxgaming_culminating;


public class CalculatorTool {
    
    
    //fields first
    private double subtotal;//total before tax
    private double tax;//total of tax due
    private double finalSubtotal;//total with tax
    
    
    //using default constructor
    
    
    //setters/mutators
    public void setSubtotal(double sub){
        
        subtotal = sub;
    }
    
    
    public void setTax(double t){
        
        tax = t;
    }
    
    
    public void setFinalSubtotal(double fsub){
        
        finalSubtotal = fsub;
    }
    
    //getters/accessors
    public double getSubtotal(){
        return subtotal;
    }
    
    public double getTax(){
        return tax;
    }
    
    public double getFinalSubtotal(){
        return finalSubtotal;
    }
    
    
    //unique methods
    /**
     * This method calculates the subtotal before tax
     * @param priceinput - the input of prices for each game in user's cart
     * @return subtotal
     */
    public double calcSubtotal(double priceinput){
        
            subtotal += priceinput;//calculation to obtain subtotal
            
        return subtotal;
    }//end of calcSubtotal
    
    /**
     * This method calculates tax due
     * @param priceinput - the input of prices for each game in user's cart
     * @return tax 
     */
    public double calcTax(double priceinput){
        
            tax = subtotal * 0.13;//calculation to obtain tax
            
        return tax;
    }//end of calcTax
    
    /**
     * This method calculates the finalSubtotal
     * @param priceinput - the input of prices for each game in user's cart
     * @return 
     */
    public double calcFinalSub(double priceinput){
        
            finalSubtotal = subtotal + tax;//calculation to obtain finalSubtotal
            
        return finalSubtotal;
    }//end of calcFinalSub
    
    
    /**
     * This method prints out the values of subtotal, tax, and finalSubtotal
     * @return str
     */
    @Override
    public String toString() 
    {
        String str = "\nSubtotal:\t\t\t$" + subtotal + "\n\nTax:\t\t\t\t$" + tax 
                + "\n\nFinal Subtotal:\t\t\t$" + finalSubtotal;
        return str;
    }//end of toString
    
}//end of class
