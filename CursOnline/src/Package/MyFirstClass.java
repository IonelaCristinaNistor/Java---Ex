package Package;

public class MyFirstClass {
    public static void main(String[] args)
    {

        //***********JAVA SUMMARY OF OPERATORS********

        boolean isAlien = false;
        if(isAlien == false) {
            System.out.println("It is not an alien!");
            System.out.println("And I am scared of aliens!");
        }

        int topScore = 100;
        if(topScore >  100) {
            System.out.println("You got the high score!");
        }

        int secondTopScore = 60;
        if((topScore > secondTopScore) && (topScore <= 100)) {
            System.out.println("Greater than second top score and less than 100");
        }

        if((topScore > 90) || (secondTopScore <= 90)){
            System.out.println("Either or both of the condtions are true");
        }

        int newValue = 50;
        if(newValue == 50)
        {
            System.out.println("This is not an error!");
        }

        boolean isCar = false;
        if(isCar == true){
            System.out.println("This is not supposed to happen!");
        }

        String makeofCar = "Volkswagen";
        boolean isDomestic = makeofCar == "Volkswagen" ? false : true;
        if(isDomestic) {
            System.out.println("This car is domestic in our country!");
        }

        String s = (isDomestic) ? "This car is domestric" : "This car is not domestic";
        System.out.println(s);

        int ageOfClient = 20;
        String ageText = (ageOfClient >= 18) ? "Over eighteen" : "Still a kid";
        System.out.println("Our client is " + ageText);

        //************** JAVA OPERATOR PRECEDENCE TABLE ******************


        double myFirstValue = 20.00;
        double mySecondValue = 80.00;
        double myValuesTotal = (myFirstValue + mySecondValue) * 100.00;
        System.out.println("My values total = " + myValuesTotal);
        double theRemainder = myValuesTotal % 40.00;
        System.out.println("The remainder = " + theRemainder);
        boolean isNoRemainder = (theRemainder == 0) ? true : false;
        System.out.println("Is not remainder = " + isNoRemainder);
        if(!isNoRemainder){
            System.out.println("Got some remainder!");
        }

    }
}
