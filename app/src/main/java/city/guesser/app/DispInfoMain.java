package city.guesser.app;

import java.util.Arrays;
import java.util.Collections;

public class DispInfoMain {
  public String[] dispInfoMain(Object QCityInfo[]) {
    String[] cityInfoArrayS = new String[10];
    Object ObjLatitude = String.valueOf(QCityInfo[0]);
    cityInfoArrayS[0] = (String) ObjLatitude;
    Object ObjLongitude = String.valueOf(QCityInfo[1]);
    cityInfoArrayS[1] = (String) ObjLongitude;
    Object ObjName = QCityInfo[2];
    cityInfoArrayS[2] = (String) ObjName;
    Object ObjCountry = QCityInfo[3];
    cityInfoArrayS[3] = (String) ObjCountry;
    Object ObjRegion = QCityInfo[4];
    cityInfoArrayS[4] = (String) ObjRegion;
    Object ObjRegionId = QCityInfo[5];
    cityInfoArrayS[5] = (String) ObjRegionId;
    Object ObjName2 = QCityInfo[6];
    cityInfoArrayS[6] = (String) ObjName2;
    Object ObjName3 = QCityInfo[7];
    cityInfoArrayS[7] = (String) ObjName3;
    Object ObjName4 = QCityInfo[8];
    cityInfoArrayS[8] = (String) ObjName4;
    Object ObjName5 = QCityInfo[9];
    cityInfoArrayS[9] = (String) ObjName5;
    return cityInfoArrayS;

  }

  public String[] randomNames(String cityInfoArrayS[]) {

    String[] randomNamesArray = new String[5];

    randomNamesArray[0] = cityInfoArrayS[2];
    randomNamesArray[1] = cityInfoArrayS[6];
    randomNamesArray[2] = cityInfoArrayS[7];
    randomNamesArray[3] = cityInfoArrayS[8];
    randomNamesArray[4] = cityInfoArrayS[9];
    Collections.shuffle(Arrays.asList(randomNamesArray));
    return randomNamesArray;
  }
}
