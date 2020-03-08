package model.actor;

import java.io.Serializable;

public class Actor implements Serializable {
    private static final long serialVersionUID = 2L;
    private String name;
    private String surname;
    private String career;
    private String birthDate;
    private String birthPlace;
    private String photo;

    public Actor(String name, String surname, String career, String birthDate, String birthPlace, String photo) {
        this.name = name;
        this.surname = surname;
        this.career = career;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.photo = photo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCareer() {
        return career;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }


    public String getPhoto() {
        return photo;
    }
}
