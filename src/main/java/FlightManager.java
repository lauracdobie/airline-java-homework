import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FlightManager {

    Flight flight;

    public FlightManager (Flight flight) {
        this.flight = flight;
    }

    public int getPassengerBaggageWeight(Passenger passenger) {
        int bagWeight = getFlightBaggageWeight() / this.flight.getPlane().getCapacity();
        return passenger.getNumberOfBags() * bagWeight;
    }

    public int getTotalPassengerBaggageWeight() {
        int totalWeight = 0;
        ArrayList<Passenger> flightPassengers = this.flight.getPassengerList();
        for (Passenger passenger : flightPassengers) {
            totalWeight += getPassengerBaggageWeight(passenger);
        }

        return totalWeight;
    }

    public int getFlightBaggageWeight() {
        return this.flight.getPlane().getTotalWeight() / 2;
    }

    public int calculateRemainingBaggageWeight() {
        return this.getFlightBaggageWeight() - this.getTotalPassengerBaggageWeight();
    }

    public void assignFlightToPassenger() {
        ArrayList<Passenger> flightPassengers = this.flight.getPassengerList();
        for (Passenger passenger : flightPassengers) {
            passenger.setFlight(this.flight);
        }
    }

    public void bookPassengerOntoFlight(Passenger passenger) {
        this.flight.addPassengerToFlight(passenger);
        this.assignFlightToPassenger();
    }
}
