package fd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "g_gamedetail")
public class GameAbstract implements Serializable {
    private Integer id;
    private String gameName;
    private String plantForm;
    private String kind;
    private String describe;
    private String coverImg;
    private Integer assess;
    private Integer heat;
    private Date createDate;
    public GameAbstract (){}

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPlantForm() {
        return plantForm;
    }

    public void setPlantForm(String plantForm) {
        this.plantForm = plantForm;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getAssess() {
        return assess;
    }

    public void setAssess(Integer assess) {
        this.assess = assess;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameAbstract{");
        sb.append("id=").append(id);
        sb.append(", gameName='").append(gameName).append('\'');
        sb.append(", kind='").append(kind).append('\'');
        sb.append(", plantForm='").append(plantForm).append('\'');
        sb.append(", coverImg='").append(coverImg).append('\'');
        sb.append(", createDate='").append(createDate).append('\'');
        sb.append(", assess='").append(assess).append('\'');
        sb.append(", heat='").append(heat).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
