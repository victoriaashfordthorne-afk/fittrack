package MbemX.example.FitTrack.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDto {
    @NotBlank(message = "The Name is obligatory")
    private String preName;

    @NotBlank(message = "The Name is obligatory")
    private String name;

    @Email(message = "Email is invalid")
    @NotBlank(message = "Email is required")
    private String email;
}
