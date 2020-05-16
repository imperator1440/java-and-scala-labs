package com.company;

import java.util.Vector;

public class FlyControlCenter {
    final static int var = 0;
    Vector<Airplanes> vector = new Vector<>();
    private int runwayCount = 0;
    FlyControlCenter(){}

    void addAirplane(Airplanes plane)
    {
        runwayCount++;
        vector.add(plane);
    }

    void removePlane()
    {
        for (int i = 0; i < vector.size(); i++) {
            if (vector.elementAt(i).time == 0) {
                vector.remove(i);
                runwayCount--;
                break;
            }
        }
    }

    boolean isRunwayFree() {
        return (runwayCount < 5);
    }

    public void closeAll()
    {
        for (int i = 0; i < vector.size(); i++) {
            vector.elementAt(i).closeThread();
        }
    }
}
