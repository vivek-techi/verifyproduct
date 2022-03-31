package BaseLibrary;

import CommonConstant.Constant;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;



public class ProReader {
    static Properties props = new Properties();
    public static ProReader proReader = null;

    public ProReader()  {

        List<String> list = Arrays.asList(Constant.LOCATOR_FILEPATH,Constant.TEST_FILEPATH);
        for (String file : list) {
            FileReader reader = null;
            try {
                reader = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                props.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static ProReader getInstance(){
        if (proReader == null) {
            proReader = new ProReader();
        }
        return proReader;
    }


    public static String getPropertyValue(String key){
        return  props.getProperty(key);
    }



}
