package day18;

public class JohnAdamHomework {
    public static void main(String[] args) {

        System.out.println(daysToSurpass(2, 3, 5));
        //it will take 2 days
        System.out.println(daysToSurpass(5, 5, 1));
        //-1 Adam won't be able to surpass, their output is the same
        System.out.println(daysToSurpass(10,5,10));
        //-1 Adam won't surpass, because his output is lower
        System.out.println(daysToSurpass(-10, 30, 105));
        //3 it will take 3 days for Adam to surpass John

    }
    public static int daysToSurpass (int johnDaily, int adamDaily, int difference) {
        if (adamDaily <= johnDaily) {
            return -1;
        }
        int adamTotal = 0;
        int johnTotal = difference;
        int dayCounter = 1;
        while (adamTotal < johnTotal) {
            johnTotal += johnDaily;
            adamTotal += adamDaily;
            dayCounter++;
        }
        return dayCounter;

    }

}

