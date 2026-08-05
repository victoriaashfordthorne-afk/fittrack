package MbemX.example.FitTrack.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembersDto {
    private Long id;
    private String preName;
    private String name;
    private String email;

}
