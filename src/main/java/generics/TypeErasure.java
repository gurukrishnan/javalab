package generics;

import java.util.ArrayList;

/**
 *
 * Key concepts: generics, type erasure
 *
 * Created by Guru Krishnan on 4/29/2018.
 */
public class TypeErasure {
    public TypeErasure() {
    }

    public boolean erasureCheck() {
        ArrayList<Integer> li = new ArrayList<Integer>();
        ArrayList<Float> lf = new ArrayList<Float>();
        return li.getClass() == lf.getClass();
    }
}
