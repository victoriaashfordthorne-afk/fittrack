package MbemX.example.FitTrack.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.Email;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Members {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;

    @NotBlank(message = "Name is obligatory")
    private String name;

    @NotBlank(message = " Prename is obligatory")
    @Column(name = "pre_name")
    private String preName;

 @Email(message = "Email is invalid")
 @NotBlank(message = "Email is required")
    private String email;

}
