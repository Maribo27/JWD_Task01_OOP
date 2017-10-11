package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.Set;

public class Validator {
	
	public static <E> boolean criteriaValidator(Criteria<E> criteria) {
	    if (criteria == null) {
	        return false;
        }

        if (criteria.getApplianceType().equals("")) {
	        return false;
        }

        Map<E, Object> applianceCriteria;
        applianceCriteria = criteria.getCriteria();

        Set<E> criteriaKeys;
        criteriaKeys = applianceCriteria.keySet();

        for (E key : criteriaKeys) {
            if (applianceCriteria.get(key) == null) {
                return false;
            }

            boolean stringValue;
            stringValue = key.toString().equals("OS") || key.toString().equals("FILTER_TYPE")
                    || key.toString().equals("BAG_TYPE") || key.toString().equals("WAND_TYPE")
                    || key.toString().equals("COLOR") || key.toString().equals("FREQUENCY_RANGE");

            if (!stringValue) {
                Class valueClass;
                valueClass = applianceCriteria.get(key).getClass();

                if (valueClass == String.class) {
                    return false;
                }
            } else {
                Class valueClass;
                valueClass = applianceCriteria.get(key).getClass();

                boolean numberValue;
                numberValue = valueClass == Double.class || valueClass == Integer.class;

                if (numberValue) {
                    return false;
                }
            }
        }
		return true;
	}
}