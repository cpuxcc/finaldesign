package fd.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "g_user_detail")
public class UserDetail implements Serializable {
    private Integer id;
    private String introduce;
    private String msgBoard;
    private String signture;

    private UserDetail userDetail;

    public UserDetail(){ }

    public UserDetail(String introduce, String msgBoard,String signture) {
        this.introduce = introduce;
        this.msgBoard = msgBoard;
        this.signture = signture;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getMsgBoard() {
        return msgBoard;
    }

    public void setMsgBoard(String msgBoard) {
        this.msgBoard = msgBoard;
    }

    public String getSignture() {
        return signture;
    }

    public void setSignture(String signture) {
        this.signture = signture;
    }



    @OneToOne
    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

}
