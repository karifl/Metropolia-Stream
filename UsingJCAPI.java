/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingjcapistream;

import java.util.*;
import java.util.stream.Stream;
/**
 *
 * @author kamaj
 */
public class UsingJCAPI {

    /**
     * @param args the command line arguments
     */

    
/*    interface Compare {
    
    public boolean test(TrafficCard t);
   
    
}*/
  
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        

 
        
        ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
        RandomString rString = new RandomString(10);
        float genBalance;
        TrafficCard myCard;
        Random r = new Random();
        int i;
        for (i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);

        
        };
        System.out.println("Matkakortit asiakasnumeron mukaisesti pienimmästä suurempaan.");
        
        
        
        
        cardUsers.stream().sorted((TrafficCard s1, TrafficCard s2)-> Integer.compare(s1.mTravellerNumber, s2.mTravellerNumber)).forEach(t -> System.out.println(t.toString()));
    //  cardUsers.stream().sorted(new TravellerNumberComparator().reversed()).forEach(t -> System.out.println(t.toString()));
        System.out.println("\n");
        System.out.println("Matkakortit saldon mukaisesti pienimmästä suurempaan.");
        
        cardUsers.stream().sorted((TrafficCard s1, TrafficCard s2)-> Float.compare(s1.mBalance, s2.mBalance)).forEach(t -> System.out.println(t.toString()));
        System.out.println("\n");
        System.out.println("Matkakortit tilin ensimmäisen kirjaimen mukaisesti pienimmästä suurempaan.");
        
        cardUsers.stream().sorted((TrafficCard s1, TrafficCard s2)-> Integer.compare(s1.mOwnerName.charAt(0), s2.mOwnerName.charAt(0))).forEach(t -> System.out.println(t.toString()));
//      
   //  System.out.println("Matkakortit matkustajanumeron perusteella pienimmästä suurimpaan");
   //     printTrafficCardsWithPredicate(cardUsers, t-> t.mTravellerNumber !=0);        
        
        
        //https://www.drdobbs.com/jvm/lambda-expressions-in-java-8/240166764
             
        
      
        
    }
    public static void printTrafficCardsWithPredicate(ArrayList <TrafficCard> cardUsers, Predicate<TrafficCard> tester){
       // cardUsers.sort(new TravellerNumberComparator (cardUsers.get(1).mTravellerNumber));
       //Collections.sort(cardUsers, new TravellerNumberComparator().reversed());
        
       //Lajitellaan pienimmästä suurimpaan
      // cardUsers.sort((TrafficCard s1, TrafficCard s2)-> Integer.compare(s1.mTravellerNumber, s2.mTravellerNumber)); 
       //https://www.drdobbs.com/jvm/lambda-expressions-in-java-8/240166764
          
       for(TrafficCard t:cardUsers){
                if(tester.test(t)){
                    System.out.println(t);
                  
                }
            }
        };
}
