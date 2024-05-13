package city.guesser.app;

public class DispInfoMain {
  public String[] dispInfoMain(Object QCityInfo[]) {
    String[] cityInfoArrayS = new String[6];
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
    return cityInfoArrayS;

  }
}
