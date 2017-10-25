package me.aoa4eva;

import java.util.ArrayList;

public class Bus {
    private ArrayList<Passenger> passengers;
    private ArrayList<BusStop> stops;

    public Bus() {
        passengers = new ArrayList<Passenger>();
        stops = new ArrayList<BusStop>();

    }

    public void alight(Passenger p) {
        passengers.remove(p);
    }

    public void board(Passenger p) {
        passengers.add(p);
    }

    public BusStop findStop(int stopNumber) {

        //This is an example of how to search for a particular bus stop. It is not used in the example, because different
        // bus stop objects are used for passengers and the bus. Note that though the stops have the same information, they
        // are NOT the same object.

        for (BusStop s : stops) {
            if (s.getStopNumber() == stopNumber)
                return s;
        }
        return null;
    }

    public void drive() {

        for (BusStop s : stops) {
            System.out.println("The bus has stopped at " + s.getStopName() + ", stop " + s.getStopNumber());

            ArrayList<Passenger> gonePassengers = new ArrayList<Passenger>();

            for (Passenger p : passengers) {
                //Each passenger should annoucne his/her stop when the bus stops at the right place
                if (p.getMyStop().getStopNumber() == s.getStopNumber()) {
                    System.out.println(p.announceStop() + " My name is " + p.getMyName() + ".");
                    gonePassengers.add(p);
                }

            }
            for (Passenger gonePassenger : gonePassengers) {
                passengers.remove(gonePassenger);
            }
            System.out.println("Passenger still in the bus");
            if (passengers.isEmpty()) {
                System.out.println("every passenger left the bus");
            } else {
                for (Passenger p : passengers) {
                    System.out.println(p.getMyName() + "    " + p.getMyStop().getStopName());
                }
            }
            System.out.println("-------------------------------------");

            //Each passenger should get off the bus (see the ArrayList Example for hints on what to do)
        }
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public ArrayList<BusStop> getStops() {
        return stops;
    }

    public void setStops(ArrayList<BusStop> stops) {
        this.stops = stops;
    }

    public void addStop(BusStop b) {
        this.stops.add(b);
    }


}


