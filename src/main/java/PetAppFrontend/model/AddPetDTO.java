package PetAppFrontend.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPetDTO {
    private String name;
    private int age;
    private String petTypeName;
}