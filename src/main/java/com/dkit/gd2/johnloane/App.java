package com.dkit.gd2.johnloane;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * GD2 Regular Expessions - we want to know about this
 * as it will allow us to validate user input
 */

public class App 
{
    public static void main( String[] args )
    {
//        stringRegularExpressions();
//        alphaNumericRegularExpressions();
//        alphaNumericRegularExpressionsMatches();
//        alphaNumericEndFindMultipleCharactersRegex();
//        alphaNumericRangesRegex();
//        whiteSpaceRegex();
//        specificNumberOfOccurrencesRegex();
//        introToPatternMatcher();
//        findOccurrencesWithPatternMatcher();
//        findOccurrencesWithPatternMatcherGroup();
//          orAndRegex();
//          whyWeNeedNegativeLookAheadRegex();
//          negativeLookAheadRegex();
//          usPhoneNumberRegex();
//          visaRegex();
//        challengeOne();
//        challengeTwo();
//        challengeThree();
//        challengeFour();
//        challengeFive();
//        challengeSix();
//        challengeSeven();
        challengeEight();
    }

    private static void challengeEight()
    {
        //Modify challenge 7 to use a group so that we can print out the digits that occur in a string that has multiple occurrences of the pattern. Use Pattern, Matcher.
        //The output for the String below should be 135, 7, 999
        String challenge8 = "abcd.135usqv.7tzik.999";

        String regExp = "[A-z][a-z]+\\.(\\d+)";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge8);

        while(matcher.find())
        {
            System.out.println("Occurrence: " + matcher.group(1));
        }


    }

    private static void challengeSeven()
    {
        //Write a regex that match a string that starts with a series of letters
        //The letters are followed by a period. After the period there are series
        //of digits. "kjsl.22" should match, "f5.12a" should not match
        String challenge7 = "abcd.135";
        //If you want a . you need to escape it
        //. -> will match anything in regex
        String regExp = "^[A-z][a-z]+\\.\\d+$";
        System.out.println(challenge7.matches(regExp));
    }

    private static void challengeSix()
    {
        //Write a regex that will match match challenge 5 string in its entirety
        String challenge5 = "aaabccccccccdddefffg";

        String regExp = "^a{3}bc{8}d{3}ef{3}g$";
        System.out.println(challenge5.matches(regExp));
    }

    private static void challengeFive()
    {
        //Write regex to match String below. Verify with String.matches()
        String challenge5 = "aaabccccccccdddefffg";

        String regExp = "[a-g]+";
        System.out.println(challenge5.matches(regExp));
    }

    private static void challengeFour()
    {
        //Replace all occurrences of whitespace with _ in following String
        //Print the new String
        String challenge4 = "Replace all blanks with whitespaces";
        System.out.println(challenge4.replaceAll("\\s", "_"));
    }

    private static void challengeThree()
    {
        //In challenge 2 we used String.matches
        //Use Matcher.matches to check for matches.
        //Hint - compile your regex pattern
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";

        String regExp = "I want a (bike|ball)\\.";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());


    }

    private static void challengeTwo()
    {
        //Write a regex that will match the two strings below. Verify using matches
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";

        String regExp = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regExp));
        System.out.println(challenge2.matches(regExp));
    }

    private static void challengeOne()
    {
        //Write the string literal regex that will match the following String
        //Use String.matches() to verify your answer.
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));



    }

    private static void visaRegex()
    {
        //Visa has to start with 4, can have either 13 or 16 digits in total
        //4444444444 , 13 4's Valid
        //4444444444444, 16 4's Valid
        //577777 Invalid
        //444444 //Not valid
        //444444444444444444 Not valid
        String visa1 = "4444444444444"; //Valid
        String visa2 = "5444444444444"; //Invalid
        String visa3 = "4444444444444444"; //Valid
        String visa4 = "4444"; //Invalid

        String cianVisaRegex = "^4(\\d){12}$|^4(\\d){15}$";
        String visaRegex = "^4[0-9]{12}([0-9]{3})?$";
        System.out.println("visa1 " + visa1.matches(visaRegex));
        System.out.println("visa2 " + visa2.matches(visaRegex));
        System.out.println("visa3 " + visa3.matches(visaRegex));
        System.out.println("visa4 " + visa4.matches(visaRegex));

    }

    private static void usPhoneNumberRegex()
    {
        //(800) 123-4567
        String phone1 = "1234567890"; //Should not match
        String phone2 = "(123) 456-7890"; //Match
        String phone3 = "123 456-7890"; //No match
        String phone4 = "(123)456-7890"; //No match
        String phone5 = "****(123) 456-7890***"; //No match

        String usPhoneNumberRegex = "^[\\(]{1}[\\d]{3}[\\)]{1}[ ]{1}[\\d]{3}-[\\d]{4}$";
        System.out.println("phone1 = " + phone1.matches(usPhoneNumberRegex));
        System.out.println("phone2 = " + phone2.matches(usPhoneNumberRegex));
        System.out.println("phone3 = " + phone3.matches(usPhoneNumberRegex));
        System.out.println("phone4 = " + phone4.matches(usPhoneNumberRegex));
        System.out.println("phone5 = " + phone5.matches(usPhoneNumberRegex));
    }

    private static void negativeLookAheadRegex()
    {
        String tvTest = "tstvtkt";
        String tNotVRegExp = "t(?!v)";

        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        int count = 0;
        while(tNotVMatcher.find())
        {
            count++;
            System.out.println(tvTest);
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }
    }

    private static void whyWeNeedNegativeLookAheadRegex()
    {
        //[^abc]
        String tvTest = "tstvtkt";
        String tNotVRegExp = "t[^v]";

        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        int count = 0;
        while(tNotVMatcher.find())
        {
            count++;
            System.out.println(tvTest);
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }


    }

    private static void orAndRegex()
    {
        //"abc" -> "a" and "b" and "c"
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));
    }

    private static void findOccurrencesWithPatternMatcherGroup()
    {
        StringBuilder htmlText = new StringBuilder("<h1>Page Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is paragraph about something</p>");
        htmlText.append("<p>Another paragraph</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>This is the summary</p>");

        //The ? changes the regex from greedy - get as much as possible
        //to lazy - do as little as possible
        String h2Pattern = "(<h2>.*?</h2>)";
        Pattern pattern = Pattern.compile((h2Pattern));
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        while(matcher.find())
        {
            System.out.println("Occurrence: " + matcher.group(1));
        }

        String h2GroupPattern = "(<h2>)(.*?)(</h2>)";
        Pattern groupPattern = Pattern.compile((h2GroupPattern));
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();
        while(groupMatcher.find())
        {
            System.out.println("Occurrence: " + groupMatcher.group(2));
        }


    }

    private static void findOccurrencesWithPatternMatcher()
    {
        StringBuilder htmlText = new StringBuilder("<h1>Page Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is paragraph about something</p>");
        htmlText.append("<p>Another paragraph</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>This is the summary</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile((h2Pattern));
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find())
        {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }
    }

    private static void introToPatternMatcher()
    {
        //StringBuilder is a mutable String
        //String is immutable
        //mutable = can be changed
        StringBuilder htmlText = new StringBuilder("<h1>Page Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is paragraph about something</p>");
        htmlText.append("<p>Another paragraph</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>This is the summary</p>");

        String h2Pattern = ".*<h2>.*";
        Pattern pattern = Pattern.compile((h2Pattern));
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(htmlText);
        System.out.println(matcher.matches());
    }

    private static void specificNumberOfOccurrencesRegex()
    {
        String alphanumeric = "abcDeeeeeeF12Ghhiiiiiijkl99z";
        //Curly brackets allow us to specify the exact number of occurrences
        System.out.println(alphanumeric.replaceAll("^abcDe{3}", "YYY"));
        //+ means one or more occurrences
        System.out.println(alphanumeric.replaceAll("^abcDe+", "YYY"));
        //* means zero or more
        System.out.println(alphanumeric.replaceAll("^abcDe*", "YYY"));
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}", "YYY"));
        //Replace any number of h's (there has to eb at least one), followed by any number of i's, followed by a j with Y
        System.out.println(alphanumeric.replaceAll("h+i*j", "Y"));
    }

    private static void whiteSpaceRegex()
    {
        String whiteSpace = "I have blanks and \t a tab, and a newline \n";
        System.out.println(whiteSpace);
        // \s is whiteSpace - need to escape it
        System.out.println(whiteSpace.replaceAll("\\s", ""));
        //Replace the tab with an X
        System.out.println(whiteSpace.replaceAll("\t", "X"));
        // \S is anything that is not a whitespace
        System.out.println(whiteSpace.replaceAll("\\S", "X"));
        //\w is any word character [a-zA-Z_0-9]
        System.out.println(whiteSpace.replaceAll("\\w", "X"));
        System.out.println(whiteSpace.replaceAll("\\b", "X"));

    }

    private static void alphaNumericRangesRegex()
    {
        String alphanumeric = "abcDeeeF12Ghhiiiiiijkl99z";
        //When used inside [] ^ means not ^ej means not e and not j
        System.out.println(alphanumeric.replaceAll("[^ej]", "X"));
        //Regular expressions are case sensitive
        System.out.println(alphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        //? means case insensitive
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println(alphanumeric.replaceAll("[0-9]", "X"));
        // \d is the regex for any digit - need to escape it with \
        System.out.println(alphanumeric.replaceAll("\\d", "X"));
        //The uppercase of any letter regex is the opposite - anything that is not a digit in this case
        System.out.println(alphanumeric.replaceAll("\\D", "X"));

    }

    private static void alphaNumericEndFindMultipleCharactersRegex()
    {
        String alphanumeric = "abcDeeeF12Ghhiiiiiijkl99z";
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "END"));

        System.out.println(alphanumeric.replaceAll("[aei]", "Something longer"));

        //Challenge - Want to replace any a, e or i that is followed by an F or j with "X"
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
    }

    private static void alphaNumericRegularExpressionsMatches()
    {
        String alphanumeric = "abcDeeeF12Ghhiiiiiijkl99z";
        System.out.println(alphanumeric.matches("^hello"));
        //matches expects to match the entire string
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("^abcDeeeF12Ghhiiiiiijkl99z"));
    }

    private static void alphaNumericRegularExpressions()
    {
        String alphanumeric = "abcDeeeF12Ghhiiiiiijkl99z";
        System.out.println(alphanumeric);
        //. in regex will match anything
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        //Expected result - YYYF12Ghhiiiiiijkl99z
        //^ means the start of the word
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String alphanumericTwo = "abcDeeeF12GhhabcDeeeiiiiiijkl99z";
        System.out.println(alphanumericTwo.replaceAll("^abcDeee", "YYY"));
    }

    private static void stringRegularExpressions()
    {
        //A String is a regular expression
        String testString = "I like bikes. So, I do";
        System.out.println(testString);
        String secondString = testString.replaceAll("I", "You");
        System.out.println(secondString);
    }
}
