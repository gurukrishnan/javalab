package lang.string;

/**
 * Created by Guru Krishnan on 5/7/2018.
 */
public class StringPool {

    public void stringInterning() {
        String str1 = "xyz";
        String str2 = str1.intern();
        System.out.println("Equality test for an interned string:");
        if(str1 == str2)
            System.out.println("String 1 (" + str1 + ") is same as String 2 (" + str2 + ")");
        else
            System.out.println("String 1 (" + str1 + ") String 2 (" + str2 + ") are not the same");
        System.out.println("");
    }

    public void stringCopying() {
        String str1 = "xyz";
        String str2 = new String(str1);
        System.out.println("Equality test for an copied string:");
        if(str1 == str2)
            System.out.println("String 1 (" + str1 + ") is same as String 2 (" + str2 + ")");
        else
            System.out.println("String 1 (" + str1 + ") String 2 (" + str2 + ") are not the same");
        System.out.println("");
    }

    public void stringLiterals() {
        String str1 = "xyz";
        String str2 = "xyz";
        System.out.println("Equality test for two string instances initialized with identical string literals:");
        if(str1 == str2)
            System.out.println("String 1 (" + str1 + ") is same as String 2 (" + str2 + ")");
        else
            System.out.println("String 1 (" + str1 + ") String 2 (" + str2 + ") are not the same");
        System.out.println("");
    }

    public void stringLiterals_2() {
        String str1 = "xyz";
        String str2 = "xyZ";
        System.out.println("Equality test for two string instances initialized with slighltly different string literals:");
        if(str1 == str2)
            System.out.println("String 1 (" + str1 + ") is same as String 2 (" + str2 + ")");
        else
            System.out.println("String 1 (" + str1 + ") String 2 (" + str2 + ") are not the same");
        System.out.println("");
    }

    public void stringRedundantLiterals() {
        String str1 = new String("xyz");
        String str2 = new String("xyz");
        System.out.println("Equality test for two string instances created and initialized with identical string literals (Poor practice):");
        if(str1 == str2)
            System.out.println("String 1 (" + str1 + ") is same as String 2 (" + str2 + ")");
        else
            System.out.println("String 1 (" + str1 + ") String 2 (" + str2 + ") are not the same");
        System.out.println("");
    }

    public static void main(String[] args) {
        //create instance of outer class first:
        StringPool strPool = new StringPool();
        strPool.stringInterning();
        strPool.stringLiterals();
        strPool.stringLiterals_2();
        strPool.stringRedundantLiterals();;
    }
}
