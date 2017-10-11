package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.Parser;
import java.util.Map;
import java.util.Set;
import java.util.List;


public class ApplianceDAOImpl implements ApplianceDAO{

    private final static String PATH = "jwd-task01-template\\src\\main\\resources\\appliances_db.txt";

    @Override
	public <E> Appliance find(Criteria<E> criteria) {

		Map<E, Object> applianceCriteria;
        applianceCriteria = criteria.getCriteria();

        Set<E> criteriaKeys;
        criteriaKeys = applianceCriteria.keySet();

        Parser parser;
        parser = new Parser(PATH);

        List<Map<String, Object>> appliances;
        appliances = parser.parseFile(criteria.getApplianceType());

        for (Map<String, Object> appliance : appliances){
            int numberOfCoincidences;
            numberOfCoincidences = 0;
            for (E key : criteriaKeys){
                Object applianceValue;
                applianceValue = appliance.get(key.toString());

                Object criteriaValue;
                criteriaValue = applianceCriteria.get(key);

                boolean number = applianceValue.getClass() == Integer.class || applianceValue.getClass() == Double.class;
                if (number){
                    double applianceNumber;
                    applianceNumber = Double.parseDouble(applianceValue.toString());

                    double criteriaNumber;
                    criteriaNumber = Double.parseDouble(criteriaValue.toString());

                    if (applianceNumber == criteriaNumber) {
                        numberOfCoincidences++;
                    }
                } else {
                    if (appliance.get(key.toString()).toString().equalsIgnoreCase(applianceCriteria.get(key).toString())){
                        numberOfCoincidences++;
                    }
                }
            }

            if (numberOfCoincidences == criteriaKeys.size()) {
                return tempParseToAppliance(appliance, criteria.getApplianceType());
            }
        }
		return null;
	}

    private Appliance tempParseToAppliance(Map<String, Object> map, String type) {
        if (type.equals("Laptop")){
            Laptop applianceLaptop = new Laptop();
            applianceLaptop.setBatteryCapacity(Double.parseDouble(map.get("BATTERY_CAPACITY").toString()));
            applianceLaptop.setCpu(Double.parseDouble(map.get("CPU").toString()));
            applianceLaptop.setDisplayInches(Double.parseDouble(map.get("DISPLAY_INCHES").toString()));
            applianceLaptop.setMemoryROM(Double.parseDouble(map.get("MEMORY_ROM").toString()));
            applianceLaptop.setOs(map.get("OS").toString());
            applianceLaptop.setSystemMemory(Double.parseDouble(map.get("SYSTEM_MEMORY").toString()));
            return applianceLaptop;
        }
        if (type.equals("Oven")){
            Oven applianceOven = new Oven();
            applianceOven.setCapacity(Double.parseDouble(map.get("CAPACITY").toString()));
            applianceOven.setDepth(Double.parseDouble(map.get("DEPTH").toString()));
            applianceOven.setHeight(Double.parseDouble(map.get("HEIGHT").toString()));
            applianceOven.setPowerConsumption(Double.parseDouble(map.get("POWER_CONSUMPTION").toString()));
            applianceOven.setWeight(Double.parseDouble(map.get("WEIGHT").toString()));
            applianceOven.setWidth(Double.parseDouble(map.get("WIDTH").toString()));
            return applianceOven;
        }
        if (type.equals("Refrigerator")){
            Refrigerator applianceRefrigerator = new Refrigerator();
            applianceRefrigerator.setFreezerCapacity(Double.parseDouble(map.get("FREEZER_CAPACITY").toString()));
            applianceRefrigerator.setHeight(Double.parseDouble(map.get("HEIGHT").toString()));
            applianceRefrigerator.setOverallCapacity(Double.parseDouble(map.get("OVERALL_CAPACITY").toString()));
            applianceRefrigerator.setPowerConsumption(Double.parseDouble(map.get("POWER_CONSUMPTION").toString()));
            applianceRefrigerator.setWeight(Double.parseDouble(map.get("WEIGHT").toString()));
            applianceRefrigerator.setWidth(Double.parseDouble(map.get("WIDTH").toString()));
            return applianceRefrigerator;
        }
        if (type.equals("Speakers")){
            Speakers applianceSpeakers = new Speakers();
            applianceSpeakers.setColdLength(Double.parseDouble(map.get("CORD_LENGTH").toString()));
            applianceSpeakers.setFrequencyRange(map.get("FREQUENCY_RANGE").toString());
            applianceSpeakers.setNumberOfSpeakers(Double.parseDouble(map.get("NUMBER_OF_SPEAKERS").toString()));
            applianceSpeakers.setPowerConsumption(Double.parseDouble(map.get("POWER_CONSUMPTION").toString()));
            return applianceSpeakers;
        }
        if (type.equals("TabletPC")){
            TabletPC applianceTabletPC = new TabletPC();
            applianceTabletPC.setBatteryCapacity(Double.parseDouble(map.get("BATTERY_CAPACITY").toString()));
            applianceTabletPC.setColor(map.get("COLOR").toString());
            applianceTabletPC.setDisplayInches(Double.parseDouble(map.get("DISPLAY_INCHES").toString()));
            applianceTabletPC.setMemoryROM(Double.parseDouble(map.get("MEMORY_ROM").toString()));
            applianceTabletPC.setFlashMemoryCapacity(Double.parseDouble(map.get("FLASH_MEMORY_CAPACITY").toString()));
            return applianceTabletPC;
        }
        if (type.equals("VacuumCleaner")){
            VacuumCleaner applianceVacuumCleaner = new VacuumCleaner();
            applianceVacuumCleaner.setBagType(map.get("BAG_TYPE").toString());
            applianceVacuumCleaner.setCleaningWidth(Double.parseDouble(map.get("CLEANING_WIDTH").toString()));
            applianceVacuumCleaner.setFilterType(map.get("FILTER_TYPE").toString());
            applianceVacuumCleaner.setMotorSpeedRegulation(Double.parseDouble(map.get("MOTOR_SPEED_REGULATION").toString()));
            applianceVacuumCleaner.setPowerConsumption(Double.parseDouble(map.get("POWER_CONSUMPTION").toString()));
            applianceVacuumCleaner.setWandType(map.get("WAND_TYPE").toString());
            return applianceVacuumCleaner;
        }
        return null;
    }

}