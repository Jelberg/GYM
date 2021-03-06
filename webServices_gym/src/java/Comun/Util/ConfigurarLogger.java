package Comun.Util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author simon
 */
public class ConfigurarLogger {
    
    private Logger logr = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    FileHandler fh;
    
    public ConfigurarLogger() {
        setProperties();
    }
    
    private void setProperties(){
        try{
        String ruta = System.getProperty("user.home");
        
        //LogManager.getLogManager().reset();
        logr.setLevel(Level.WARNING);
        fh = new FileHandler(ruta+"/LogGym/myLogger.log", true);

        fh.setLevel(Level.WARNING);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fh.setFormatter(simpleFormatter);
        
        logr.addHandler(fh);
        }
        catch(IOException e){
            logr.log(Level.SEVERE, "Error archivo logger", e);
        }
    }

    public Logger getLogr() {
        return logr;
    }

    public FileHandler getFh() {
        return fh;
    }
    
    
}
