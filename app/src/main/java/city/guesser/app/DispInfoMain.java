package city.guesser.app;

public class DispInfoMain {
  public String[] dispInfoMain(Object QCityInfo[]) {
    String[] cityInfoArrayS = new String[4];
    Object ObjName = QCityInfo[2];
    cityInfoArrayS[0] = (String) ObjName;
    Object ObjCountry = QCityInfo[3];
    cityInfoArrayS[1] = (String) ObjCountry;
    Object ObjRegion = QCityInfo[4];
    cityInfoArrayS[2] = (String) ObjRegion;
    Object ObjRegionId = QCityInfo[5];
    cityInfoArrayS[3] = (String) ObjRegionId;
    return cityInfoArrayS;

  }
}
