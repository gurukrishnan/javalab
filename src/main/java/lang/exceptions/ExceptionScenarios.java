package lang.exceptions;

/**
 * Created by Guru Krishnan on 5/7/2018.
 *
 * Note: This test case class answers multiple test cases with regards to exception handling
 *
 * Key Concepts and Principles:
 *  - Checked vs. Unchecked exceptions
 *  - Throwable (class)
 *  - Exception vs. Error
 *  -
 *
 *  Note: Here's the bottom line guideline: If a client can reasonably be expected to recover from an exception,
 *  make it a checked exception. If a client cannot do anything to recover from the exception, make it an
 *  unchecked exception.
 *
 * Case 1: Can Java code catch RunTimeException?
 * Answer: Yes, Java code can catch RunTimeException, but it is not a recommended practice
 *
 * Case 2: Can Java code catch Error?
 * Answer: Yes, Java code can catch Error, but it is not a recommended practice
 *
 * Case 3: Can Java code catch Throwable?
 * Answer: Yes, Java code can catch Throwable, which is root for all exceptions and errors,
 * but it is not a recommended practice
 *
 * Case 4: What happens when a number is divided by zero?
 * Answer: This depends on what type of number it is. If it is an integer number then Java throws
 * java.lang.ArithmeticException ( / by zero). If it is floating point or double then Java does not
 * throw any exception. The reason is that Java follows IEE-754 specification for floating point arithmetic
 * and part of the specification is to return +/- NaN when encountered with divide by zero situation.
 *
 * Note: Please refer to the following StackOverflow and Wiki links for further details:
 * https://stackoverflow.com/questions/12954193/why-does-division-by-zero-with-floating-point-or-double-precision-numbers-not
 * https://en.wikipedia.org/wiki/IEEE_754#Exception_handling
 *
 * Case 5: What is a chained exception?
 * An application often responds to an exception by throwing another exception. In effect, the first exception
 * causes the second exception. It can be very helpful to know when one exception causes another.
 * Chained Exceptions help the programmer do this.
 *
 * Case 6: What happens when a program encounters an unchecked exception (Error or RunTimeException)
 * and the program does not handle (catch) them?
 * Answer: The program terminates without further
 *
 *
 *
 */
public class ExceptionScenarios {

    private void catchRunTimeException() {
        try{
            int i = 0;
            throw new RuntimeException();
        }
        catch(RuntimeException e) {
            System.out.println("I caught RunTimeException");
        }
    }

    private void catchError() {
        try{
            int i = 0;
            throw new InternalError();
        }
        catch(InternalError e) {
            System.out.println("I caught Internal VM error");
        }
    }

    private void catchThrowable() {
        try{
            int i = 0;
            throw new InternalError();
        }
        catch(Throwable e) {
            System.out.println("I caught Throwable: mother of all exceptions & errors and suppressed everything");
        }
    }

    private void divideByZeroException() {
        //Note: Below comment will throw java.lang.ArithmeticException, which is an uncheked exception since it
        //inhertis from RunTimeException
        //int i = 2 / 0;

        //Note: float and double values do not throw divide by zero exception
        float f = 2.0f / 0.0f;
        System.out.println("Value of f is: " + f);

        double d = 2.0d / 0.0d;
        System.out.println("Value of d is: " + d);

        try {
            int x = 4 / 0;
            System.out.println("Value of x is: " + x);
        }
        catch(ArithmeticException e) {
            System.out.println("I caught divide by zero exception: " + e);
        }

    }

    class AppException extends Exception {
        public AppException(String msg, Throwable e) {
            super(msg, e);
        }
    }

    private void catchChainedException() {
        try {
            try {
                int x = 4 / 0;
            } catch (ArithmeticException e) {
                throw new AppException("Encountered divide by zero exception", e);
            }
        } catch (AppException e) {
            System.out.println(e);
        }
    }

    private void doNotCatchError() {
        int x = 7;
        System.out.println("About to throw Internal VM error");
        throw new InternalError();
    }

    private void doNotCatchRunTimeException() {
        int x = 7;
        System.out.println("About to throw RunTimeException");
        throw new RuntimeException();
    }

    private void tryWithResource() {
        //try(Integer n = new Integer(10))
    }

    public static void main(String[] args) {
        ExceptionScenarios ex = new ExceptionScenarios();
        ex.catchRunTimeException();
        ex.catchError();
        ex.catchThrowable();
        ex.divideByZeroException();
        ex.catchChainedException();
        //ex.doNotCatchError();
        //ex.doNotCatchRunTimeException();
        //Note: Below statement(s) will never reach if either doNotCatchError or
        //doNotCatchRunTimeException method is invoked above.
        System.out.println("Thrown and caught all exceptions and errors!!!");
    }
}
