package generics;

import java.util.ArrayList;

/**
 *
 * Key concepts: generics, type erasure
 *
 * Two key problems with type erasure:
 *  1. Java runtime won't be able to distinguish between an ArrayList of Integer vs an ArrayList of Float
 *  2. Java does not allow a generic class to extend the Throwable class
 *
 * References:
 *  https://en.wikipedia.org/wiki/Generics_in_Java#Problems_with_type_erasure
 *
 *
 * Created by Guru Krishnan on 4/29/2018.
 */
public class TypeErasure {
    public TypeErasure() {
    }

    public boolean erasureCheck() {
        ArrayList<Integer> li = new ArrayList<Integer>();
        ArrayList<Float> lf = new ArrayList<Float>();
        //Note: due to type erasure feature, the type information of generics type is lost after compilation
        //and is unavailable during run time. Java runtime internally couldn't distinguish between
        //an ArrayList of Integer vs and ArrayList of Float as the below check returns true.
        return li.getClass() == lf.getClass();
    }
}
