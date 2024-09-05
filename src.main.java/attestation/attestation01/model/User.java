package attestation.attestation01.model;

import attestation.attestation01.exception.PasswordValidationException;
import attestation.attestation01.validation.UserValidation;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class User {

    private String id;
    private LocalDateTime date;
    private String login;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String name;
    private String lastName;
    private Integer age;
    private Boolean isWorker;

    public User() {}

    public User(String id, String login, String password, String confirmPassword, String firstName, String name, String lastName, Integer age, Boolean isWorker) {
        this.id = UserValidation.validateId(id);
        this.date = LocalDateTime.now();
        this.login = UserValidation.validateLogin(login);
        this.password = UserValidation.validatePassword(password);
        if (this.password.equals(confirmPassword)) {
            this.confirmPassword = confirmPassword;
        } else {
            throw new PasswordValidationException("Пароли не совпадают");
        }
        this.firstName = UserValidation.validateName(firstName);
        this.name = UserValidation.validateName(name);
        this.lastName = UserValidation.validateLastName(lastName);
        this.age = age;
        this.isWorker = isWorker;
    }

    public User(String line) {
        String[] stringArray = line.split("\\|");
        this.id = stringArray[0];
        this.date = LocalDateTime.parse(stringArray[1]);
        this.login = stringArray[2];
        this.password = stringArray[3];
        this.confirmPassword = stringArray[4];
        this.firstName = stringArray[5];
        this.name = stringArray[6];
        this.lastName = stringArray[7];
        this.age = Integer.parseInt(stringArray[8]);
        this.isWorker = Boolean.parseBoolean(stringArray[9]);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = UserValidation.validateId(id);
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = UserValidation.validateLogin(login);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = UserValidation.validatePassword(password);
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        if (this.password.equals(confirmPassword)) {
            this.confirmPassword = confirmPassword;
        } else {
            throw new PasswordValidationException("Пароли не совпадают");
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = UserValidation.validateName(firstName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = UserValidation.validateName(name);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = UserValidation.validateLastName(lastName);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getWorker() {
        return isWorker;
    }

    public void setWorker(Boolean worker) {
        isWorker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(date, user.date) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(confirmPassword, user.confirmPassword) && Objects.equals(firstName, user.firstName) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(age, user.age) && Objects.equals(isWorker, user.isWorker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, login, password, confirmPassword, firstName, name, lastName, age, isWorker);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", date=" + date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isWorker=" + isWorker +
                '}';
    }

    public String parseUserToString() {
        return id + "|" +
                date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "|" +
                login + "|" +
                password + "|" +
                confirmPassword + "|" +
                firstName + "|" +
                name  + "|" +
                lastName + "|" +
                age + "|" +
                isWorker;
    }
}
