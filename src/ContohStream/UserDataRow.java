package ContohStream;

public class UserDataRow implements java.io.Serializable {

    public String regnumber;
    public String firstname;
    public String lastname;
    public String profession;
    public String sex;
    public String dateofbirth;
    public int size;

    public UserDataRow(String rn, String fn, String ln, String p, String s, String dob) {
        this.regnumber = rn;
        this.firstname = fn;
        this.lastname = ln;
        this.profession = p;
        this.sex = s;
        this.dateofbirth = dob;
        this.size = 6;
    }

    public String getRegnumber() {
        return this.regnumber;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getProfession() {
        return this.profession;
    }

    public String getSex() {
        return this.sex;
    }

    public String getDateofbirth() {
        return this.dateofbirth;
    }
}