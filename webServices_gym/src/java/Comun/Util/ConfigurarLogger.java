package Comun.Util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

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
        fh = new FileHandler(ruta+"/logGYM/myLogger.log", true);
        fh.setLevel(Level.WARNING);
        logr.addHandler(fh);
            System.out.println(ruta);
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
