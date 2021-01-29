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
        introToPatternMatcher();
        findOccurrencesWithPatternMatcher();
        findOccurrencesWithPatternMatcherGroup();
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
