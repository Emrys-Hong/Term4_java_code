package Q3;

import java.util.ArrayList;
import java.util.Collections;

public class TimeFinishAssignment {

    public static void main(String[] args) {
        ArrayList<Double> listOfAssignment = new ArrayList<>();
        listOfAssignment.add(6.0);
        listOfAssignment.add(7.0);
        listOfAssignment.add(8.0);
        listOfAssignment.add(9.0);
        listOfAssignment.add(10.0);

        System.out.println(computeTimeFinish(listOfAssignment));
        // output: 15

    }



    public static double computeTimeFinish(ArrayList<Double> l) {
       // TODO: implement computeTimeFinish method
        ArrayList<Double> time = new ArrayList<>(3);
        time.add(0.0);
        time.add(0.0);
        time.add(0.0);
        while (l.size()!=0) {
            double mintime = Collections.min(time);
            int index = time.indexOf(mintime);

            double nextJob = Collections.max(l);
            time.set(index, mintime+nextJob);
            l.remove(nextJob);
        }
        return Collections.max(time);
    }
}
