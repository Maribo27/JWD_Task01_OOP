package by.tc.task01.entity;

import java.io.Serializable;

public class VacuumCleaner extends Appliance implements Serializable {

    private double powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private double motorSpeedRegulation;
    private double cleaningWidth;

    public VacuumCleaner() {
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacuumCleaner that = (VacuumCleaner) o;

        if (Double.compare(that.powerConsumption, powerConsumption) != 0) return false;
        if (Double.compare(that.motorSpeedRegulation, motorSpeedRegulation) != 0) return false;
        if (Double.compare(that.cleaningWidth, cleaningWidth) != 0) return false;
        if (filterType != null ? !filterType.equals(that.filterType) : that.filterType != null) return false;
        if (bagType != null ? !bagType.equals(that.bagType) : that.bagType != null) return false;
        return wandType != null ? wandType.equals(that.wandType) : that.wandType == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(powerConsumption);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (filterType != null ? filterType.hashCode() : 0);
        result = 31 * result + (bagType != null ? bagType.hashCode() : 0);
        result = 31 * result + (wandType != null ? wandType.hashCode() : 0);
        temp = Double.doubleToLongBits(motorSpeedRegulation);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cleaningWidth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "VacuumCleaner : " +
                "POWER_CONSUMPTION=" + powerConsumption +
                ", FILTER_TYPE=" + filterType +
                ", BAG_TYPE=" + bagType +
                ", WAND_TYPE=" + wandType +
                ", MOTOR_SPEED_REGULATION=" + motorSpeedRegulation +
                ", CLEANING_WIDTH=" + cleaningWidth;
    }
}