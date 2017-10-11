package by.tc.task01.entity;

import java.util.Map;

public class CreateAppliance {
    public static Appliance createAppliance(Map<String, Object> applianceCharacteristics, String applianceType) {
        if (applianceType.equals("Laptop")) {
            Laptop applianceLaptop;
            applianceLaptop = new Laptop();

            double batteryCapacity;
            batteryCapacity = Double.parseDouble(applianceCharacteristics.get("BATTERY_CAPACITY").toString());
            applianceLaptop.setBatteryCapacity(batteryCapacity);

            double cpu;
            cpu = Double.parseDouble(applianceCharacteristics.get("CPU").toString());
            applianceLaptop.setCpu(cpu);

            double displayInches;
            displayInches = Double.parseDouble(applianceCharacteristics.get("DISPLAY_INCHES").toString());
            applianceLaptop.setDisplayInches(displayInches);

            double memoryROM;
            memoryROM = Double.parseDouble(applianceCharacteristics.get("MEMORY_ROM").toString());
            applianceLaptop.setMemoryROM(memoryROM);

            String os;
            os = applianceCharacteristics.get("OS").toString();
            applianceLaptop.setOs(os);

            double systemMemory;
            systemMemory = Double.parseDouble(applianceCharacteristics.get("SYSTEM_MEMORY").toString());
            applianceLaptop.setSystemMemory(systemMemory);

            return applianceLaptop;
        }

        if (applianceType.equals("Oven")) {
            Oven applianceOven;
            applianceOven = new Oven();

            double capacity;
            capacity = Double.parseDouble(applianceCharacteristics.get("CAPACITY").toString());
            applianceOven.setCapacity(capacity);

            double depth;
            depth = Double.parseDouble(applianceCharacteristics.get("DEPTH").toString());
            applianceOven.setDepth(depth);

            double height;
            height = Double.parseDouble(applianceCharacteristics.get("HEIGHT").toString());
            applianceOven.setHeight(height);

            double powerConsumption;
            powerConsumption = Double.parseDouble(applianceCharacteristics.get("POWER_CONSUMPTION").toString());
            applianceOven.setPowerConsumption(powerConsumption);

            double weight;
            weight = Double.parseDouble(applianceCharacteristics.get("WEIGHT").toString());
            applianceOven.setWeight(weight);

            double width;
            width = Double.parseDouble(applianceCharacteristics.get("WIDTH").toString());
            applianceOven.setWidth(width);

            return applianceOven;
        }

        if (applianceType.equals("Refrigerator")) {
            Refrigerator applianceRefrigerator;
            applianceRefrigerator = new Refrigerator();

            double freezerCapacity;
            freezerCapacity = Double.parseDouble(applianceCharacteristics.get("FREEZER_CAPACITY").toString());
            applianceRefrigerator.setFreezerCapacity(freezerCapacity);

            double height;
            height = Double.parseDouble(applianceCharacteristics.get("HEIGHT").toString());
            applianceRefrigerator.setHeight(height);

            double overallCapacity;
            overallCapacity = Double.parseDouble(applianceCharacteristics.get("OVERALL_CAPACITY").toString());
            applianceRefrigerator.setOverallCapacity(overallCapacity);

            double powerConsumption;
            powerConsumption = Double.parseDouble(applianceCharacteristics.get("POWER_CONSUMPTION").toString());
            applianceRefrigerator.setPowerConsumption(powerConsumption);

            double weight;
            weight = Double.parseDouble(applianceCharacteristics.get("WEIGHT").toString());
            applianceRefrigerator.setWeight(weight);

            double width;
            width = Double.parseDouble(applianceCharacteristics.get("WIDTH").toString());
            applianceRefrigerator.setWidth(width);

            return applianceRefrigerator;
        }
        if (applianceType.equals("Speakers")) {
            Speakers applianceSpeakers;
            applianceSpeakers = new Speakers();

            double cordLength;
            cordLength = Double.parseDouble(applianceCharacteristics.get("CORD_LENGTH").toString());
            applianceSpeakers.setColdLength(cordLength);

            String frequencyRange;
            frequencyRange = applianceCharacteristics.get("FREQUENCY_RANGE").toString();
            applianceSpeakers.setFrequencyRange(frequencyRange);

            double numberOfSpeakers;
            numberOfSpeakers = Double.parseDouble(applianceCharacteristics.get("NUMBER_OF_SPEAKERS").toString());
            applianceSpeakers.setNumberOfSpeakers(numberOfSpeakers);

            double powerConsumption;
            powerConsumption = Double.parseDouble(applianceCharacteristics.get("POWER_CONSUMPTION").toString());
            applianceSpeakers.setPowerConsumption(powerConsumption);

            return applianceSpeakers;
        }
        if (applianceType.equals("TabletPC")) {
            TabletPC applianceTabletPC;
            applianceTabletPC = new TabletPC();

            double batteryCapacity;
            batteryCapacity = Double.parseDouble(applianceCharacteristics.get("BATTERY_CAPACITY").toString());
            applianceTabletPC.setBatteryCapacity(batteryCapacity);

            String color;
            color = applianceCharacteristics.get("COLOR").toString();
            applianceTabletPC.setColor(color);

            double displayInches;
            displayInches = Double.parseDouble(applianceCharacteristics.get("DISPLAY_INCHES").toString());
            applianceTabletPC.setDisplayInches(displayInches);

            double memoryROM;
            memoryROM = Double.parseDouble(applianceCharacteristics.get("MEMORY_ROM").toString());
            applianceTabletPC.setMemoryROM(memoryROM);

            double flashMemoryCapacity;
            flashMemoryCapacity = Double.parseDouble(applianceCharacteristics.get("FLASH_MEMORY_CAPACITY").toString());
            applianceTabletPC.setFlashMemoryCapacity(flashMemoryCapacity);

            return applianceTabletPC;
        }
        if (applianceType.equals("VacuumCleaner")) {
            VacuumCleaner applianceVacuumCleaner;
            applianceVacuumCleaner = new VacuumCleaner();

            String bagType;
            bagType = applianceCharacteristics.get("BAG_TYPE").toString();
            applianceVacuumCleaner.setBagType(bagType);

            double cleaningWidth;
            cleaningWidth = Double.parseDouble(applianceCharacteristics.get("CLEANING_WIDTH").toString());
            applianceVacuumCleaner.setCleaningWidth(cleaningWidth);

            String filterType;
            filterType = applianceCharacteristics.get("FILTER_TYPE").toString();
            applianceVacuumCleaner.setFilterType(filterType);

            double motorSpeedRegulation;
            motorSpeedRegulation = Double.parseDouble(applianceCharacteristics.get("MOTOR_SPEED_REGULATION").toString());
            applianceVacuumCleaner.setMotorSpeedRegulation(motorSpeedRegulation);

            double powerConsumption;
            powerConsumption = Double.parseDouble(applianceCharacteristics.get("POWER_CONSUMPTION").toString());
            applianceVacuumCleaner.setPowerConsumption(powerConsumption);

            String wandType;
            wandType = applianceCharacteristics.get("WAND_TYPE").toString();
            applianceVacuumCleaner.setWandType(wandType);

            return applianceVacuumCleaner;
        }
        return null;
    }
}
