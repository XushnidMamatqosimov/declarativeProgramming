package uz.pdp.lambdaExpression;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ishchi {
   /* private String full_name;
    private String country;
    private String position;
    private int age;*/

    private String full_name;
    private int id;
    private String country;
    private String gender;
    private int age;

}
