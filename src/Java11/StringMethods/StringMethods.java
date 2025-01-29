package Java11.StringMethods;

public class StringMethods {
    public static void main(String[] args) {


        // ////////////////////////////////////////////////////////////////////////
        // indent()

        String multilineStr = "This is\na multiline\nstring.";
        String outputStr = "   This is\n     a multiline\n   string.\n";
        String postIndent = multilineStr.indent(2);


        System.out.println(multilineStr);
        System.out.println(outputStr);
        System.out.println(postIndent);

        // ///////////////////////////////////////////////////////////////////////

        // transform()
        String result = "hello".transform(input -> input + " world!");
        System.out.println(result);

        // repeat()

        String output = "La ".repeat(2) + "Land";
        System.out.println(output);

        // strip()
        String str1 = ("\n\t  hello   \u2005".trim());
        System.out.println(str1);

        // trim()
        String str2 = ("\n\t  hello   \u2005".trim());
        System.out.println(str2);

        // isBlank()
        boolean blank = ("\n\t\u2005  ".isBlank());
        System.out.println(blank);

        // lines()

        String multilineStr1 = "This is\n \n a multiline\n string.";

        long lineCount = multilineStr1.lines()
                .filter(String::isBlank)
                .count();

        System.out.println(lineCount);


    }
}
