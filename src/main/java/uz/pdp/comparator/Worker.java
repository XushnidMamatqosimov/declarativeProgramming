package uz.pdp.comparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Worker {
    private String full_name;
    private int id;
    private String country;
    private String gender;
    private int age;

}
