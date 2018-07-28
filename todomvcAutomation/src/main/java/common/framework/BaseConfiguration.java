package common.framework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseConfiguration {
   private Properties configFile;

    /**
     * To strings.
     *
     * Loads base.properties file for driver information
     */
   public BaseConfiguration()
   {
       configFile = new Properties();

       try {
           configFile.load(this.getClass().getClassLoader().getResourceAsStream("base.properties"));
       } catch(Exception ex){
           ex.printStackTrace();
       }
   }

   String getProperty(String key)
   {
       return this.configFile.getProperty(key);
   }

    public static String createName(){

        String name;

        Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat("ddMMyyyyhhmmss");

        name="QA TEST "+ ft.format(dNow).toString();

        return name;
    }
}