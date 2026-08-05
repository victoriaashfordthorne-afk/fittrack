package MbemX.example.FitTrack.Controller;

import MbemX.example.FitTrack.Dto.MembersDto;
import MbemX.example.FitTrack.Entity.Members;
import MbemX.example.FitTrack.Mapping.MembersMapper;
import MbemX.example.FitTrack.Services.MembersServices;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class  MembersController{
  private final MembersServices membersServices;
  public MembersController(MembersServices membersServices){
      this.membersServices=membersServices;
  }

    @GetMapping("/count")
    public long compterParDomaineEmail(@RequestParam String domaine) {
        return membersServices.compterParDomaineEmail(domaine);
    }


    @GetMapping("/all")
    public ResponseEntity<List<MembersDto>> findAll() {

        List<Members> members = membersServices.findAll();

        List<MembersDto> dtos = new ArrayList<>();

        for (Members member : members) {

            MembersDto dto = new MembersDto();
            dto.setId(member.getId());
            dto.setName(member.getName());
            dto.setPreName(member.getPreName());
            dto.setEmail(member.getEmail());

            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }
@GetMapping("/Id")
    public ResponseEntity<MembersDto> consulter( @PathVariable  Long Id){
    MembersDto membersDto = membersServices.consulter(Id);
  return ResponseEntity.ok(membersDto);

}

    @PostMapping("/add")

    public ResponseEntity<MembersDto> create(@Valid @RequestBody Members members) {

        Members members1 = membersServices.create(members);

        MembersDto dto = new MembersDto();

        dto.setId(members1.getId());
        dto.setName(members1.getName());
        dto.setPreName(members1.getPreName());
        dto.setEmail(members1.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }


@PutMapping("/{Id}")
    public ResponseEntity<MembersDto> Update(@PathVariable Long Id,   @Valid @RequestBody Members members){
    MembersDto membersDto = membersServices.update(Id,members);
    return ResponseEntity.ok(membersDto);
}

@DeleteMapping("/{Id}")
public ResponseEntity<MembersDto> Delete(@PathVariable  Long Id){
      membersServices.Delete(Id);
      return ResponseEntity.noContent().build();
}
   
}
