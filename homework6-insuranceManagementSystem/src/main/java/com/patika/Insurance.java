package com.patika;

import java.util.Date;

abstract class Insurance {
    protected final String name;
    protected final double fee;
    protected final Date startDate;
    protected final Date endDate;

    public Insurance(String name, double fee, Date startDate, Date endDate) {
        this.name = name;
        this.fee = fee;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract double calculate();

    @Override
    public String toString() {
        return String.format("Insurance: %s\nFee: %.2f\nStart Date: %s\nEnd Date: %s",
                name, fee, startDate, endDate);
    }
}

class HealthInsurance extends Insurance {
    public HealthInsurance(double fee, Date startDate, Date endDate) {
        super("Health Insurance", fee, startDate, endDate);
    }

    @Override
    public double calculate() {
        // Custom calculation logic
        return fee;
    }
}

class ResidenceInsurance extends Insurance {
    public ResidenceInsurance(double fee, Date startDate, Date endDate) {
        super("Residence Insurance", fee, startDate, endDate);
    }

    @Override
    public double calculate() {
        // Custom calculation logic
        return fee;
    }
}

class TravelInsurance extends Insurance {
    public TravelInsurance(double fee, Date startDate, Date endDate) {
        super("Travel Insurance", fee, startDate, endDate);
    }

    @Override
    public double calculate() {
        // Custom calculation logic
        return fee;
    }
}

class CarInsurance extends Insurance {
    public CarInsurance(double fee, Date startDate, Date endDate) {
        super("Car Insurance", fee, startDate, endDate);
    }

    @Override
    public double calculate() {
        // Custom calculation logic
        return fee;
    }
}

