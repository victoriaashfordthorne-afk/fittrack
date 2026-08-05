package MbemX.example.FitTrack.Mapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMembersRequest {

    private String Name;
    private String PreName;
    private String Email;

    public String getName() {
        return Name;
    }

     public String getPreName(){
        return  PreName;
     }
    public String getEmail() {
        return Email;
    }


    public void setName(String name) {
        this.Name = Name;
    }

    public void setPreName(){
        this.PreName = PreName;
    }
    public void setEmail(String email) {
        this.Email = Email;
    }
}
