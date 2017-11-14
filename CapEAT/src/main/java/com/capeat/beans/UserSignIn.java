package com.capeat.beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class UserSignIn {
    
    private int sid;
    private String eid;
    private String password;
    
    public UserSignIn() {
        super();
        // TODO Auto-generated constructor stub
    }
    public UserSignIn(int sid, String eid, String password) {
        super();
        this.sid = sid;
        this.eid = eid;
        this.password = password;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getEid() {
        return eid;
    }
    public void setEid(String eid) {
        this.eid = eid;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((eid == null) ? 0 : eid.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + sid;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserSignIn other = (UserSignIn) obj;
        if (eid == null) {
            if (other.eid != null)
                return false;
        } else if (!eid.equals(other.eid))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (sid != other.sid)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "UserSignIn [sid=" + sid + ", eid=" + eid + ", password=" + password + "]";
    }
    
    
    
}