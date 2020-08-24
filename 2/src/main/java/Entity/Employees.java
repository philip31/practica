package Entity;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "departmentId")
    private Departments department;

    @ManyToOne
    @JoinColumn(name = "jobCategoryId")
    private JobCategories jobCategories;

    private int isManager;
    private LocalDate startDate;
    private LocalDate endDate;
    private int active;
    private String address;
    private String CP;
    private String telephone;
    private String email;
    private LocalDate birthday;
    private int noChildren;
    private int salary;

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public JobCategories getJobCategories() {
        return jobCategories;
    }

    public void setJobCategories(JobCategories jobCategories) {
        this.jobCategories = jobCategories;
    }

    @Type(type = "text")
    private String studies;
    private String socialSecurityNumber;
    private int hasDrivingLicence;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIsManager() {
        return isManager;
    }

    public void setIsManager(int isManager) {
        this.isManager = isManager;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getNoChildren() {
        return noChildren;
    }

    public void setNoChildren(int noChildren) {
        this.noChildren = noChildren;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public int getHasDrivingLicence() {
        return hasDrivingLicence;
    }

    public void setHasDrivingLicence(int hasDrivingLicence) {
        this.hasDrivingLicence = hasDrivingLicence;
    }

    @Override
    public String toString() {
        return "Employees{\n" +
                "\nid=" + id +
                ", \nfirstName='" + firstName + '\'' +
                ", \nlastName='" + lastName + '\'' +
                ", \ndepartment=" + department.getName() +
                ", \njobCategories=" + jobCategories.getName() +
                ", \nisManager=" + isManager +
                ", \nstartDate=" + startDate +
                ", \nendDate=" + endDate +
                ", \nactive=" + active +
                ", \naddress='" + address + '\'' +
                ", \nCP='" + CP + '\'' +
                ", \ntelephone='" + telephone + '\'' +
                ", \nemail='" + email + '\'' +
                ", \nbirthday=" + birthday +
                ", \nnoChildren=" + noChildren +
                ", \nsalary=" + salary +
                ", \nstudies='" + studies + '\'' +
                ", \nsocialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", \nhasDrivingLicence=" + hasDrivingLicence +
                '}';
    }
}