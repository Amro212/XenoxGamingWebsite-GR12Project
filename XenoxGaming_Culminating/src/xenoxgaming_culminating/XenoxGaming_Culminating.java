/*************************************************
*Project: Xenox Gaming Culminating
*Programmer: Amro AbedMoosa
*Date: 17/04/2021
*Program Name: XenoxGaming_Culminating.java
*Description: This is a program that creates a gaming store for gamers to shop in!
*************************************************/

package xenoxgaming_culminating;

/*
importing
*/
import java.io.*;
import java.text.*;
import java.util.*;
public class XenoxGaming_Culminating {

    
    public static void main(String[] args) throws InterruptedException, IOException{
        /**
         * object calling below
         */
        Random randomNumbers = new Random();//randomizer
        FileWriter fw = new FileWriter("customers.txt", true);//creating customers file
        PrintWriter pw = new PrintWriter(fw);//to write to file
        ArrayList<Integer> userCart = new ArrayList<>();//arraylist for user's cart
        Scanner scanN = new Scanner(System.in);//input for integers/doubles
        Scanner scanS = new Scanner(System.in);//input for strings
        File myFile = new File("game_inventory.txt");//importing game inventory file
        Scanner readFile = new Scanner(myFile);//to read the game inventory file
        DecimalFormat twoDigit = new DecimalFormat("0.00");//calling decimalformat to 2 decimal points
        CalculatorTool calculator = new CalculatorTool();
        /**
         * colors below
         * any red color isn't an error i promise!
         */
        String colorReset = "\u001B[0m";//resets the color 
        String redColor = "\u001B[31m";//sets color to red
        String blueColor = "\u001B[34m";//sets color to blue
        String cyanColor = "\u001B[36m";//sets color to cyan
        String greenColor = "\u001B[32m";//sets color to green
        String yellowColor = "\u001B[33m";//sets color to yellow
        String boldRed = "\033[1;31m";//sets color to bold red
        String purpleColor = "\033[4;35m";//sets color to purple
        String greyColor = "\033[1;96m";//sets color to grey
        String blueBackground = "\033[44m";//sets background color to blue
        /**
         * variables below
         */
        int count;//count for new release display
        int mainOption;//user's option from main menu
        String gameSearch;//user's desired game they wish to search for
        String tryAgainOption = "";//user's choice whether to try searching for a game when game isnt found in case 4
        String addOption2 = "";//user's choice whether to add the game to cart or no
        int platformOption;//user's choice of what platform they would like to sort by
        String checkoutOption = "";//user's choice whether to checkout or no in case 7
        String surpriseOption;//user's choice whether to add game from case 6 to cart
        String userName;//user's name
        String userNumber;//user's phone number (used a string because java cant take an integer bigger than 10 digits, sorry)
        String userEmail;//user's email address
        
        BannerDesign(cyanColor, colorReset);//simple banner design to start off
        
        /**
         * putting games from inventory to array
         */
        String games = readFile.nextLine();
        String[] gamesTokens = games.split("\\,");
        /**
         * putting prices from inventory to array
         */
        String prices = readFile.nextLine();
        String[] temptokens1 = prices.split("\\,");//temporary tokens for prices
        double[] pricesTokens = new double[temptokens1.length];
        /**
         * putting platform from inventory to array
         */
        String platform = readFile.nextLine();
        String[] platformTokens = platform.split("\\,");
        /**
         * putting year from inventory to array
         */
        String year = readFile.nextLine();
        String[] temptokens2 = year.split("\\,");//temporary tokens for years
        int[] yearTokens = new int[temptokens2.length];
        
        for(int i=0; i<temptokens1.length;i++)
        {
            pricesTokens[i] = Double.parseDouble(temptokens1[i]);//converting string to double
            yearTokens[i] = Integer.parseInt(temptokens2[i]);//converting string to int
        }
        
        /*
        small intro
        */
        System.out.format("\n\t\t\t\t" + cyanColor + "%33s", "####################");
        System.out.format("\n\t\t\t\t" + cyanColor + "%15s %10s %2s", "##", "WELCOME GAMER!", "##\n");
        System.out.format(cyanColor + "\t\t\t\t%39s", "####################\n\n" + colorReset);
        System.out.println("\t\t\t" + blueBackground + "This is our virtual gaming store that consists of many games\n" + colorReset
                + "\t\t" + blueBackground + "you can choose from! We have all kinds of deals from the most popular platforms.\n" + colorReset
                + "\t    " + blueBackground + "We hope you enjoy your visit in Xenox and don't forget to tell all your friends about us!" + colorReset);
        
        //gathering user's information
        System.out.println("\nTo begin, please enter the following information:\n"
                + "Your name:");
        userName = scanS.nextLine();//name input
        System.out.println("\nYour email:");
        userEmail = scanS.nextLine();//email input
        System.out.println("\nYour phone number:");
        userNumber = scanS.nextLine();//phone number input
        

        GameListSort(gamesTokens, pricesTokens, platformTokens, yearTokens);//alphabetically sorting games from beginning to avoid errors
        
        do
        {
            /**
             * display of main menu below
             */
            System.out.format("\n" + blueColor + "%30s", "#################");
            System.out.format("\n" + blueColor + "%15s %10s %4s", "##", "MAIN MENU", "##\n");
            System.out.format(blueColor + "%32s", "#################\n\n");
            System.out.format(greenColor + "%9s %20s %9s", "--", "1. New Releases", "--\n" + colorReset);
            System.out.format(boldRed + "%9s %17s %12s", "--", "2. Hot Deals", "--\n" + colorReset);
            System.out.format(blueColor + "%9s %17s %12s", "--", "3. Platforms", "--\n" + colorReset);
            System.out.format(cyanColor + "%9s %14s %15s", "--", "4. Search", "--\n" + colorReset);
            System.out.format(purpleColor + "%9s %17s %12s", "--", "5. Game List", "--\n" + colorReset);
            System.out.format(greyColor + "%9s %17s %12s", "--", "6. Surprise Me!", "--\n" + colorReset);
            System.out.format(yellowColor + "%9s %17s %9s", "--", "7. View Cart/Checkout", "--\n\n" + colorReset);
            
            System.out.println("Enter the number corresponding to the option below:\n");//taking user's choice for the main menu
            mainOption = scanN.nextInt();
            
            switch(mainOption)
            {
                case 1:{//if user chooses new releases
                    
                    /*
                    simple design when option is selected
                    */
                    for(int k=0; k < "** NEW RELEASES **".length(); k++)
                    {
                        System.out.print(greenColor + "\t **NEW RELEASES** \n".charAt(k)+ " " + colorReset);
                        Thread.sleep(250);
                    }
                    
                    count = 1;//resetting count instead of using more than one
                    System.out.println("\n\nIn this section, regardless of the platform type,\n"
                            + "you will find yourself wandering around\n"
                            + "the newest games in the market as of this year!\n\n"
                            + "Here is the list of" + greenColor+ " New Releases: " + colorReset + "\n\n");//coloring and resetting text color
                    
                    int[] newReleasePositions = NewReleaseSearch(yearTokens);//calling on NewReleaseSearch to search for games release in 2021
        
                    System.out.format(greenColor + "%10s %30s %25s", "**NAME**", "**PRICE**", "**PLATFORM**\n\n" + colorReset);//neatly organized
                    
                    for(int i=0; i < gamesTokens.length; i++)//loop to display the results
                    {
                        if(newReleasePositions[i] >= 0)
                        {
                            System.out.format(greenColor + "%-25s %13s %-10s %6s", count++ + ". " + gamesTokens[i],"$" + pricesTokens[i], 
                                    " ", platformTokens[i] + colorReset + "\n");//outputting results
                        }
                    }
                    
                    //does all the work from error handling, to adding to cart.
                    GameAddition(gamesTokens, userCart, greenColor, redColor, colorReset);
                    
                    break;
                }
                case 2:{//if user chooses hot deals
                    
                    /*
                    simple design when option is selected
                    */
                    for(int k=0; k < "** HOT DEALS **".length(); k++) 
                    {
                        System.out.print(boldRed + "\t **HOT DEALS** \n".charAt(k)+ " " + colorReset);
                        Thread.sleep(250);
                    }
                    
                    count = 1;//resetting count
                    System.out.println("\n\nIn this section, regardless of the platform type,\n"
                            + "you will find the hottest deals on amazing games!\n"
                            + "All of the games displayed will all be under " + boldRed + "$20!\n\n" + colorReset
                            + "Here is the list of" + boldRed+ " Hot Deals: " + colorReset + "\n\n");//coloring and resetting text color
                    
                    int[] hotDealsPositions = HotDealsSearch(pricesTokens);
                    System.out.format(boldRed + "%10s %30s %20s %25s", "**NAME**", "**WAS**", "**NOW**", "**PLATFORM**\n\n" + colorReset);//neatly organized
                    
                    for(int i=0; i < hotDealsPositions.length; i++)//loop to display the results
                    {
                        if(hotDealsPositions[i] >= 0)
                        {
                            System.out.format(boldRed + "%-25s %14s %20s %-9s %3s", count++ + ". " + gamesTokens[i], "$" + twoDigit.format(pricesTokens[i]*7), "$" + 
                                    pricesTokens[i], " ",  platformTokens[i] + colorReset + "\n");//outputting results
                        }
                    }
                    
                    GameAddition(gamesTokens, userCart, greenColor, redColor, colorReset);//method to add games to cart
                    
                    break;
                }
                
                
                case 3:{//if user chooses platforms
                    
                    /*
                    simple design when option is selected
                    */
                    for(int k=0; k < "** PLATFORMS **".length(); k++) 
                    {
                        System.out.print(blueColor + "\t **PLATFORMS** \n".charAt(k)+ " " + colorReset);
                        Thread.sleep(250);
                    }
                    
                    count = 1;//resetting count
                    System.out.println("\n\nIn this section, you can choose which platform you would like to sort the games by.\n");
                    do
                    {
                        System.out.println("Please select the choice corresponding to the platform to sort by:\n\n"
                                + blueColor + "\t\t1- PC\n"//number 1 corresponds to PC sorting
                                + blueColor + "\t\t2- Playstation\n"//number 2 corresponds to playstation sorting
                                + blueColor + "\t\t3- Xbox\n" + colorReset);//number 3 corresponds to xbox sorting
                        platformOption = scanN.nextInt();//user's choice input 
                        
                        if(platformOption < 1 || platformOption > 3)//error trapping in case input isnt from the menu
                        {
                            System.out.println(boldRed + "\n\tInvalid input. Try again." + colorReset + "\n");
                        }
                        else
                        {
                            int[] platformPositions = PlatformSearch(platformTokens, platformOption);
                            
                            System.out.println("\n\t" + blueColor + "Here is the list of sorted games we can find!\n");
                            System.out.format(blueColor + "%10s %32s %25s", "**NAME**", "**PRICE**", "**PLATFORM**\n\n" + colorReset);
                            
                            for (int i = 0; i < platformPositions.length; i++)//loop to display the results
                            {
                                if (platformPositions[i] >= 0)
                                {
                                    System.out.format(blueColor + "%-32s %-1s %6s  %21s", count++ + ". " + gamesTokens[i], " ",
                                    "$" + pricesTokens[i],  platformTokens[i] + colorReset + "\n");//outputting results neatly
                                }
                            }
                            
                            GameAddition(gamesTokens, userCart, greenColor, redColor, colorReset);//calling on GameAddition method
                        }
                        
                    }while(platformOption !=1 && platformOption !=2 && platformOption !=3);
                    
                    break;
                }
                
                
                case 4:{//if user chooses search
                    
                    /*
                    simple design when option is selected
                    */
                    for(int k=0; k < "** SEARCH **".length(); k++) 
                    {
                        System.out.print(cyanColor + "\t **SEARCH** \n".charAt(k)+ " " + colorReset);
                        Thread.sleep(250);
                    }
                    
                    count = 1;//resetting count
                    System.out.println("\n\nThe search feature will, obviously, allow you to search for games in our inventory!");
                    
                    do
                    {
                        System.out.println("\nEnter the EXACT name of the game you wish to" + cyanColor + " search " + colorReset + "for below:");
                        gameSearch = scanS.nextLine();
                        int searchPosition = GameSearch(gamesTokens, gameSearch);//calling on GameSearch method

                        if (searchPosition >= 0)//when game is found
                        {
                            System.out.println("\n\t\t" + greenColor + "Game found!" + colorReset);
                            System.out.format(cyanColor + "%10s %15s %25s", "**NAME**", "**PRICE**", "**PLATFORM**\n" + colorReset);
                            System.out.format(cyanColor + "%10s %13s %23s", gamesTokens[searchPosition], "$" + pricesTokens[searchPosition], 
                                    platformTokens[searchPosition] + "\n\n" + colorReset);
                            do
                            {
                                System.out.println("\nWould you like to add it to cart? (yes/no)");
                                addOption2 = scanS.nextLine();
                                if(addOption2.equalsIgnoreCase("yes"))//if yes
                                {
                                    userCart.add(searchPosition);
                                    System.out.println("\n\t" + greenColor + "Successfully added game(s) to cart!" + colorReset);
                                }
                                
                                else if(addOption2.equalsIgnoreCase("no"))//if no
                                {
                                    System.out.println(greenColor + "\tMake sure to check out other options!" + colorReset);
                                }
                                else
                                {
                                    System.out.println(boldRed + "Invalid input. Try again." + colorReset);//if anything else
                                }
                            }while(!addOption2.equalsIgnoreCase("no") && !addOption2.equalsIgnoreCase("yes"));//error trapping 
                            
                        }
                        
                        else//if user's game was not found
                        {
                            System.out.println(boldRed + "Sorry, game was not found. Try again? (yes/no)" + colorReset);
                            tryAgainOption = scanS.nextLine();
                        }
                    }while(!tryAgainOption.equalsIgnoreCase("no") && !addOption2.equalsIgnoreCase("no") && !addOption2.equalsIgnoreCase("yes"));
                    
                    break;
                }
                
                case 5:{//if user chooses game list
                    
                    /*
                    simple design when option is selected
                    */
                    for(int k=0; k < "** GAME LIST **".length(); k++) 
                    {
                        System.out.print(purpleColor + "\t **GAME LIST** \n".charAt(k)+ " " + colorReset);
                        Thread.sleep(250);
                    }
                    
                    count = 1;//resetting count
                    System.out.println("\n\nThe following section will display the list of all games in alphabatical order.\n"
                            + "You are more than welcome to select and add any of them to cart.\n"
                            + "\nHere is the full " + purpleColor + "Game List:\n\n" + colorReset);//coloring and resetting text color
                    GameListSort(gamesTokens, pricesTokens, platformTokens, yearTokens);//sorting games alphabatically
                    
                    System.out.format(purpleColor + "%10s %37s %25s", "**NAME**", "**PRICE**", "**PLATFORM**\n\n" + colorReset);//neatly organized                    
                    for (int i = 0; i < gamesTokens.length; i++)//for loop to printt out results
                    {
                        System.out.format(purpleColor + "%-35s %3s %-17s %7s", count++ + ". " + gamesTokens[i], " ", "$" + pricesTokens[i],
                                platformTokens[i] + colorReset + "\n");//outputting results
                    }
                    
                    GameAddition(gamesTokens, userCart, greenColor, redColor, colorReset);//calling on GameAddition method
                    System.out.println(userCart);
                    break;
                }
                
                case 6:{
                    count = 1;//resetting count
                    
                    int num = randomNumbers.nextInt(17) + 0;//generating random number from 0-17, which represent the indexes for games

                    for(int k=0; k < "** SURPRISE ME! **".length(); k++)//into design
                    {
                        System.out.print(greyColor + "\t **SURPRISE ME!** \n".charAt(k)+ " " + colorReset);
                        Thread.sleep(250);
                    }
                    
                    System.out.println("\n\nThis section will surprise our dear customer with one of our many games!");
                    System.out.println("\n\t\tYour generated game is...\n");
                    
                    System.out.format(greyColor + "%-10s %29s %20s", "**NAME**", "**PRICE**", "**PLATFORM**\n" );
                    System.out.format(greyColor + "%-25s %5s %-16s %6s", count++ + ". " + gamesTokens[num], " ",
                                            "$" + pricesTokens[num], platformTokens[num] + colorReset + "\n\n");//neatly organized output
                    
                    
                    
                    do//error trappingg user to enter eithehr yes or no
                    {
                        System.out.println("Would you like to add this game to cart?");
                        surpriseOption = scanS.nextLine();
                        if(surpriseOption.equalsIgnoreCase("yes"))//if yes
                        {
                            userCart.add(num);//adding index of game to cart
                            System.out.println("\n\t" + greenColor + "Successfully added game(s) to cart!" + colorReset);//successful message
                        }
                        else if(surpriseOption.equalsIgnoreCase("no"))//if no
                        {
                            System.out.println(greenColor + "\n\tBe sure to check out other options!" + colorReset);
                        }
                        else
                        {
                            System.out.println("\n" + boldRed + "Invalid input. Try again.\n" + colorReset);//anything else
                        }
                        
                    }while(!surpriseOption.equalsIgnoreCase("no") && !surpriseOption.equalsIgnoreCase("yes"));//condition to keep looping
                    
                    break;
                }
                
                case 7:{
                    
                    calculator.setSubtotal(0);//resetting subtotal value in case user wants to view only
                    count = 1;//resetting count
                    
                    if(userCart.isEmpty())//if cart is empty
                    {
                        System.out.println("\n\t" + boldRed + "Your cart is empty. " + colorReset
                                + greenColor + "Add some games and come back!" + colorReset);//if user's cart is empty
                    }
                    else//other than that
                    {
                        
                        /*
                        simple design when option is selected
                        */
                        for (int k = 0; k < "** CART/CHECKOUT **".length(); k++)
                        {
                            System.out.print(yellowColor + "\t **CART/CHECKOUT** \n".charAt(k) + " " + colorReset);
                            Thread.sleep(250);
                        }
                        System.out.println("\n\nThis section will display all the games you added to your " + yellowColor + "Cart!" + colorReset);
                        System.out.println("\n\t\tHere is your " + yellowColor + "Cart:\n\n");

                        System.out.format(yellowColor + "%10s %32s %25s", "**NAME**", "**PRICE**", "**PLATFORM**\n\n" + colorReset);//neatly organized
                        
                        for (int i = 0; i < userCart.size(); i++)
                        {
                            
                            System.out.format(yellowColor + "%-25s %9s %-16s %6s", count++ + ". " + gamesTokens[userCart.get(i)], " ",
                                            "$" + pricesTokens[userCart.get(i)], platformTokens[userCart.get(i)] + "\n\n" + colorReset);//neatly organized output
                        }
                        
                        for (int i = 0; i < userCart.size(); i++)
                                {
                                    calculator.calcSubtotal(pricesTokens[userCart.get(i)]);//to calculate subtotal without tax (to view)
                                }
                        
                        System.out.format(greenColor + "%-10s %36s", "Subtotal:" , "$" + twoDigit.format(calculator.getSubtotal()) + colorReset + "\n\n");
                        
                        /*
                        error trapping with do while loop
                        and checking whether user would like to checkout or no
                        */
                        do {
                            System.out.println("Would you like to " + yellowColor + "Checkout" + colorReset + " with the currnet games? (yes/no)\n");
                            checkoutOption = scanS.nextLine();
                            
                            if (checkoutOption.equalsIgnoreCase("yes"))//if yes
                            {
                                calculator.setSubtotal(0);//resetting subtotal to avoid wrongful values
                                count = 1;//resetting count
                                
                                /*
                                simple design when option is selected
                                 */
                                for (int k = 0; k < "\t\t\t** RECEIPT **".length(); k++)
                                {
                                    System.out.print(yellowColor + "\t\t\t **RECEIPT** \n".charAt(k) + " " + colorReset);
                                    Thread.sleep(250);
                                }

                                //carrying calculations if user decides to checkout
                                for (int i = 0; i < userCart.size(); i++)
                                {
                                    calculator.calcSubtotal(pricesTokens[userCart.get(i)]);//to calculate subtotal without tax
                                    calculator.calcTax(pricesTokens[userCart.get(i)]);//to calculate tax
                                    calculator.calcFinalSub(pricesTokens[userCart.get(i)]);//to calculate subtotal with tax
                                }
                                
                                /*
                                outputting receipt
                                */
                                
                                System.out.format("\n\n" + yellowColor + "%10s %32s %25s", "********", "*********",
                                        "*************\n");//neatly organized

                                System.out.format(yellowColor + "%10s %32s %25s", "**NAME**", "**PRICE**",
                                        "**PLATFORMS**\n");//neatly organized

                                System.out.format(yellowColor + "%10s %32s %30s", "********", "*********",
                                        "*************\n\n" + colorReset);//neatly organized
                                
                                for (int i = 0; i < userCart.size(); i++)
                                {   
                                    
                                    System.out.format(yellowColor + "%-25s %9s %-21s %6s", count++ + ". " + gamesTokens[userCart.get(i)], " ",
                                            "$" + pricesTokens[userCart.get(i)], platformTokens[userCart.get(i)] + "\n\n" + colorReset);//neatly organized output
                                    
                                    
                                    for (int k = 0; k < 69; k++)//line design between games
                                    {
                                        System.out.print(boldRed + "#");
                                    }
                                    System.out.println(colorReset + "\n");//starting a new line and resetting color
                                }
                                
                                /*
                                displaying totals
                                i would have used the toString method from the object
                                but it wont display colors nicely like this :)
                                */
                                System.out.format("\n" + greenColor + "%-35s %1s", "SUBTOTAL: ",
                                        "$" + twoDigit.format(calculator.getSubtotal()) + "\n");//subtotal display
                                System.out.format("\n" + greenColor + "%-35s %1s", "TAX DUE (13%):",
                                        "$" + twoDigit.format(calculator.getTax()) + "\n");//tax display
                                System.out.format("\n" + greenColor + "%-35s %1s", "FINAL TOTAL:",
                                        "$" + twoDigit.format(calculator.getFinalSubtotal()) + "\n" + colorReset);//final subtotal display
                                
                                int invoice = randomNumbers.nextInt(9999999) + 1000000;//invoice number generated
                                System.out.println("\nHere the invoice number for the purchase: " + greyColor + invoice);
                                
                                System.out.println("\n\n\t\t" + blueBackground + cyanColor + "THANK YOU VERY MUCH FOR SHOPPING AT XENOX GAMING!\n\n"
                                        + colorReset + "\t " + blueBackground + cyanColor +"We sincerely appreciate your visit and hope we've succeeded\n"
                                        + colorReset + "\t " + blueBackground + cyanColor +"in bringing you an enjoyable experience and entertainment!\n"
                                        + colorReset + "\t\t"+ blueBackground + cyanColor +"You are more than welcome to visit us again!");//goodbye message
                                
                                //saving customer info to customers.txt
                                pw.println("** NAME **\t--\t" + userName + "\n** EMAIL **\t--\t"+ userEmail + "\n** NUMBER **\t--\t" + userNumber
                                        + "\n** TOTAL **\t--\t$" + twoDigit.format(calculator.getFinalSubtotal()) + "\n** INVOICE **\t--\t" + invoice + "\n\n");
                                
                                /*
                                closing files
                                 */
                                readFile.close();
                                pw.close();
                                fw.close();
                            }
                            
                            else if (checkoutOption.equalsIgnoreCase("no"))//if no
                            {
                                System.out.println(greenColor + "\tMake sure to check out other options!\n" + colorReset);
                            }
                            
                            else
                            {
                                System.out.println("\n" + boldRed + "Invalid input. Try again.\n" + colorReset);//anything else
                            }
                            
                        } while(!checkoutOption.equalsIgnoreCase("no") && !checkoutOption.equalsIgnoreCase("yes"));//condition to keep loop running
                    }
                    break;
                }
                default:{
                    System.out.println("\n\t" + redColor + "Invalid input. Please try again.\n" + colorReset);
                    break;
                }
            }
        }while(userCart.isEmpty() || mainOption != 7 || checkoutOption.equalsIgnoreCase("no"));//condition for main do while loop
        
    }//end of main
    
    /**
     * This method creates a simple banner design for the start of the program
     * @param cyanColor - changes text color to cyan
     * @param colorReset - resets text color
     * @throws InterruptedException 
     */
    public static void BannerDesign(String cyanColor, String colorReset) throws InterruptedException{
        String storeName = "\t\tXENOX GAMING STORE";//name of the store
        
        for (int row = 10; row>=1; row--) //banner design
        {
            for(int d = 1; d<=row; d++)
            {
                System.out.print(cyanColor + "\t$" + colorReset);
            }
            System.out.println("\n*");
        }
        
        for(int k=0; k < storeName.length(); k++) //loop to display banner message
        {
            System.out.print(cyanColor + storeName.charAt(k)+ " " + colorReset);
            Thread.sleep(250);
        }
        
        for(int row = 1;row <= 10;row++)//banner design
        {
            for(int col = 1;col<=row;col++)
            {
                System.out.print(cyanColor + "\t$" + colorReset);
            }
            System.out.println("\n*");
        }
        
    }//end of BannerDesign
    
    /**
     * This method searches for the newest games released as of this year (2021)
     * @param yearTokens - contains list of year released for each game
     * @return newReleasePositions
     */
    public static int[] NewReleaseSearch(int[] yearTokens){
        
        int[] newReleasePositions = new int [18];//array to hold all the positions found in the search
        
        for(int k=0; k < newReleasePositions.length; k++)//initializing array to start at -1 so that program does not ignore position 0
        {
            newReleasePositions[k] = -1;//setting elements in array to -1
        }
        
        for(int i = 0; i<yearTokens.length; i++)//searching through the array yearTokens
        {
            if(yearTokens[i] == 2021)//when key is found in array (in this case, our key is 2021 since the most recent games came out in 2021)
            {
                newReleasePositions[i] = i;//then save that position in the array
            }
        }
        return newReleasePositions;
        
    }//end of NewReleaseSearch
    
    /**
     * This method searches for hot deals 
     * @param pricesTokens - contains prices of games
     * @return hotDealsPositions
     */
    public static int[] HotDealsSearch(double[] pricesTokens){
        
        int[] hotDealsPositions = new int [18];//array to hold all the positions found in the search
        
        for(int k=0; k < hotDealsPositions.length; k++)//initializing array to start at -1 so that program does not ignore position 0
        {
            hotDealsPositions[k] = -1;//setting elements in array to -1
        }
        
        for(int i = 0; i<pricesTokens.length; i++)//searching through the array pricesTokens
        {
            if(pricesTokens[i] < 20.00)//when key is found in array (in this case, our key is 2021 since the most recent games came out in 2021)
            {
                hotDealsPositions[i] = i;//then save that position in the array
            }
        }
        return hotDealsPositions;
    }//end of HotDealsSearch
    
    /**
     * This method searches for the user's desired platform to sort by
     * @param platformTokens - contains the platform of each game
     * @param platformOption - user's choice of platform to sort by
     * @return platformPositions
     */
    public static int[] PlatformSearch(String[] platformTokens, int platformOption){
        
        int[] platformPositions = new int [18];//array to hold all the positions found in the search
        
        for(int k=0; k < platformPositions.length; k++)//initializing array to start at -1 so that program does not ignore position 0
        {
            platformPositions[k] = -1;//setting elements in array to -1
        }
        
        switch(platformOption)
        {
            case 1:{//if user chooses pc
                for (int i = 0; i < platformTokens.length; i++)//searching through the array platformTokens
                {
                    if (platformTokens[i].equalsIgnoreCase("PC"))//when key is found (PC)
                    {
                        platformPositions[i] = i;//then save that position in the array
                    }
                }
                break;
            }
            
            case 2:{//if user chooses playstation
                for (int i = 0; i < platformTokens.length; i++)//searching through the array platformTokens
                {
                    if (platformTokens[i].equalsIgnoreCase("Playstation"))//when key is found (Playstation)
                    {
                        platformPositions[i] = i;//then save that position in the array
                    }
                }
                
                break;
            }
            
            case 3:{//if user chooses xbox
                for (int i = 0; i < platformTokens.length; i++)//searching through the array platformTokens
                {
                    if (platformTokens[i].equalsIgnoreCase("Xbox"))//when key is found (Xbox)
                    {
                        platformPositions[i] = i;//then save that position in the array
                    }
                }
            }
            
            break;
        }
        
        return platformPositions;
    }//end of PlatformSearch
    
    
    /**
     * This method searches for the game specified by the user
     * @param gamesTokens - contains list of games
     * @param gameSearch - user's desired game to search for
     * @return searchPosition
     */
    public static int GameSearch(String[] gamesTokens, String gameSearch){
        int searchPosition = -1;//setting it to -1 in case no game is found
        
        for(int i = 0; i<gamesTokens.length; i++)//searching through the array pricesTokens
        {
            if(gamesTokens[i].equalsIgnoreCase(gameSearch))//when key is found in array (in this case, our key is 2021 since the most recent games came out in 2021)
            {
                searchPosition = i;//then save that position in the array
            }
        }
        
        return searchPosition;
    }//end of GameSearch
    
    /**
     * This method will take the user's selected game and add it to cart
     * @param gamesTokens - list of all games
     * @param userCart - user's cart
     * @param greenColor - green text color
     * @param redColor - red text color
     * @param colorReset - reset text color
     */
    public static void GameAddition(String[] gamesTokens, ArrayList userCart, String greenColor, String redColor, String colorReset){
        Scanner scanS = new Scanner(System.in);
        String gameName;//game name selected by user
        String addOption;//whether user wants to add game to cart or no
        int track;//tracker
        
        do {
            track = 0;//variable to keep track
            System.out.println("\nAdd game(s) to cart? (yes/no)");
            addOption = scanS.nextLine();

            if (addOption.equalsIgnoreCase("yes"))//if user enters yes
            {
                System.out.println("\nPlease enter the EXACT name of the game you wish to add to cart:");
                gameName = scanS.nextLine();//user input for game's name
                    
                for (int i = 0; i < gamesTokens.length; i++)//searching through the array gamesTokens
                {
                    if (gamesTokens[i].equalsIgnoreCase(gameName))//when key is found, which is the game name user entered in main
                    {
                        track = 1;//setting to 1 to keep track
                        userCart.add(i);//then add the position of that game to arraylist (cart)
                    }
                }
                
                if(track == 1)
                {
                    System.out.println("\n" + greenColor + "\tSuccessfully added game(s) to cart!" + colorReset);
                }
                
                else
                {
                    System.out.println("\n" + redColor + "\tSorry, game was not found." + colorReset);
                }
            }
            
            else if (addOption.equalsIgnoreCase("no"))//if user enters no
            {
                System.out.println(greenColor + "\n\t\tBe sure to check out other options!" + colorReset);
                
            }
            
            else 
            {
                System.out.println("\n" + redColor + "Invalid input. Try again" + colorReset);
            }
        } while (!addOption.equalsIgnoreCase("no"));//error trapping user with a do while loop
        
        
    }//end of GameAddition
    
    /**
     * This method sorts the games alphabetically  by also keeping their corresponding prices, release year, and platform
     * @param gamesTokens - contains list of all games
     * @param pricesTokens - contains prices of all games
     * @param platformTokens - contains platform type for all games
     * @param yearTokens - contains release year for each game
     */
    public static void GameListSort(String[] gamesTokens, double[] pricesTokens, String[] platformTokens, int[] yearTokens){
         //declare variables
        int i, j, indexToSwap;
        String tempGames;//temporary variable for games
        double tempPrices;//temporary variable for prices
        String tempPlatforms;//temporary variable for platform
        int tempYears;//temporary variable for year
        
        
        for(i=0; i<gamesTokens.length-1; i++)
        {
            //initialize variables
            indexToSwap = i;//initialize to the index of the first of the unsorted cells
            tempGames = gamesTokens[indexToSwap];//temp for games
            tempPrices = pricesTokens[indexToSwap];//temp for prices
            tempPlatforms = platformTokens[indexToSwap];//temp for platforms
            tempYears = yearTokens[indexToSwap];//temp for year
            
            //search through the unsorted values
            for (j=1+i; j<gamesTokens.length; j++)    
            {
                if (tempGames.compareToIgnoreCase(gamesTokens[j])>0)
                {
                    indexToSwap = j;
                    tempGames = gamesTokens[indexToSwap];//swapping games
                    tempPrices = pricesTokens[indexToSwap];//swapping prices
                    tempPlatforms = platformTokens[indexToSwap];//swapping platforms
                    tempYears = yearTokens[indexToSwap];//swapping years
                }// end of if statement
            }//end of inner for loop
            
            /*
            swapping process
            */
            gamesTokens[indexToSwap] = gamesTokens[i];
            gamesTokens[i] = tempGames;
            pricesTokens[indexToSwap] = pricesTokens[i];
            pricesTokens[i] = tempPrices;
            platformTokens[indexToSwap] = platformTokens[i];
            platformTokens[i] = tempPlatforms;
            yearTokens[indexToSwap] = yearTokens[i];
            yearTokens[i] = tempYears;
        }
    }//end of GameListSort
}//end of class