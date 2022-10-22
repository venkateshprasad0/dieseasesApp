package com.upgrad.patterns.Service;

import com.upgrad.patterns.Interfaces.IndianDiseaseStat;
import com.upgrad.patterns.Constants.SourceType;
import com.upgrad.patterns.Strategies.DiseaseShStrategy;
import com.upgrad.patterns.Strategies.JohnHopkinsStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndiaDiseaseStatFactory {
    private IndianDiseaseStat diseaseShStrategy;
    private IndianDiseaseStat johnHopkinsStrategy;

    @Autowired
    public IndiaDiseaseStatFactory(DiseaseShStrategy diseaseShStrategy, JohnHopkinsStrategy johnHopkinsStrategy)
    {
        this.diseaseShStrategy = diseaseShStrategy;
        this.johnHopkinsStrategy = johnHopkinsStrategy;
    }

    //create a method named GetInstance with return type as IndianDiseaseStat and parameter of type sourceType
    	//create a conditional statement
    	//if the sourceType is JohnHopkins
    		//return johnHopkinsStrategy
    	//if the sourceType is DiseaseSh
    		//return diseaseShStrategy
    
    	//create a message for invalid disease strategy/sourceType
    	//throw the message as an Illegal argument exception

    public IndianDiseaseStat GetInstance(SourceType sourceType){
            if (sourceType.toString().equalsIgnoreCase("JohnHopkins"))
                return johnHopkinsStrategy;
            else if (sourceType.toString().equalsIgnoreCase("DiseaseSh"))
                return diseaseShStrategy;

            else {
                String message = "invalid disease strategy/sourceType";
                throw new IllegalArgumentException(message);
            }


    }
    
}
