package CommonConstant;

import java.io.File;

public class Constant {

        public final static String USER_HOME = System.getProperty("user.dir");
        public final static String RESOURCE_DIRECTORY = USER_HOME+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator;
        public final static String LOCATOR_FILEPATH = RESOURCE_DIRECTORY+"Locators.properties";
        public static final String TEST_FILEPATH = RESOURCE_DIRECTORY+"testdata.properties" ;
        public static int timeWait= 60;




}
