package Classes;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name="lists")
class SpaceMarineLists{
    List<SpaceMarine> SpaceMarineList;
    void setSpaceMarineList(List<SpaceMarine> SpaceMarineList) {
        this.SpaceMarineList = SpaceMarineList;
    }
}