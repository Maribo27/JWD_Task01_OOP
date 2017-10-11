package by.tc.task01.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
    private String path = "JWD_Task01_OOP\\jwd-task01-template\\src\\main\\resources\\appliances_db.txt";

    public Parser(String path){
        this.path = path;
    }

    public List<Map<String, Object>> parseFile(String applianceType){

        Map<String, Object> appliance;

        List<Map<String, Object>> appliances;
        appliances = new ArrayList<>();

        Scanner input;
        try {
            input = new Scanner(new File(path));
            while (input.hasNextLine()) {

                String inputString;
                inputString = input.nextLine();

                if (inputString.matches(applianceType + " : ")){
                    for (int charNumber = 0; charNumber < inputString.length(); charNumber++){
                        if (inputString.charAt(charNumber) == ':') {
                            inputString = inputString.substring(charNumber + 1, inputString.length());
                            break;
                        }
                    }

                    appliance = createAppliance(inputString);

                    if (appliance != null) {
                        appliances.add(appliance);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return appliances;
    }

    private Map<String,Object> createAppliance(String characteristics){
        characteristics = characteristics.replaceAll("\\s", "");

        StringBuilder buffer;
        buffer = new StringBuilder();

        Map<String, Object> appliance;
        appliance = new HashMap<>();

        String name;
        name = "";

        for (int charNumber = 0; charNumber < characteristics.length(); charNumber++){
            if (characteristics.charAt(charNumber) == '='){
                name = buffer.toString();
                buffer = new StringBuilder();
            } else {
                boolean endOfCharacteristic = characteristics.charAt(charNumber) == ',' || characteristics.charAt(charNumber) == ';';
                if (endOfCharacteristic){
                    if (buffer.toString().matches("^\\d+\\.?\\d*$")){
                        appliance.put(name, Double.parseDouble(buffer.toString()));
                    } else {
                        appliance.put(name, buffer.toString());
                    }
                    buffer = new StringBuilder();
                } else {
                    buffer.append(characteristics.charAt(charNumber));
                }
            }
        }
        return appliance;
    }
}
