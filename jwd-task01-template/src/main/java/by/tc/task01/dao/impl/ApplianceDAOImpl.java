package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.Parser;
import java.util.Map;
import java.util.Set;
import java.util.List;

import static by.tc.task01.entity.CreateAppliance.createAppliance;

public class ApplianceDAOImpl implements ApplianceDAO {

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

        for (Map<String, Object> appliance : appliances) {
            int numberOfCoincidences;
            numberOfCoincidences = 0;
            for (E key : criteriaKeys) {
                Object applianceValue;
                applianceValue = appliance.get(key.toString());

                Object criteriaValue;
                criteriaValue = applianceCriteria.get(key);

                boolean number = applianceValue.getClass() == Integer.class || applianceValue.getClass() == Double.class;
                if (number) {
                    double applianceNumber;
                    applianceNumber = Double.parseDouble(applianceValue.toString());

                    double criteriaNumber;
                    criteriaNumber = Double.parseDouble(criteriaValue.toString());

                    if (applianceNumber == criteriaNumber) {
                        numberOfCoincidences++;
                    }
                } else {
                    String applianceString;
                    applianceString = appliance.get(key.toString()).toString();

                    String criteriaString;
                    criteriaString = applianceCriteria.get(key).toString();

                    if (applianceString.equalsIgnoreCase(criteriaString)) {
                        numberOfCoincidences++;
                    }
                }
            }

            if (numberOfCoincidences == criteriaKeys.size()) {
                return createAppliance(appliance, criteria.getApplianceType());
            }
        }
		return null;
	}
}