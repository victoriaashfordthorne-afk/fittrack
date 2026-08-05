package MbemX.example.FitTrack.Services;


import MbemX.example.FitTrack.Dto.MembersDto;
import MbemX.example.FitTrack.Entity.Members;
import MbemX.example.FitTrack.Repository.MembersRepository;
import MbemX.example.FitTrack.exceptionNot.MembersNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MembersServices {
    private final MembersRepository membersRepository;

    public MembersServices(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    public List<Members> searchByName(String Name) {
        return membersRepository.findByNameContainingIgnoreCase(Name);

    }


    public long compterParDomaineEmail(String domaine) {
        return membersRepository.compterParDomaineEmail(domaine);
    }

    @Cacheable(value = "members")

    public List<Members> findAll() {

        try {
            Thread.sleep(3000); // Simulate a slow database request
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Searching database...");
        return membersRepository.findAll();
    }

    public MembersDto consulter(Long Id) {

        Members members = membersRepository.findById(Id)
                .orElseThrow(() ->
                        new RuntimeException("Member with Id " + Id + " Not Found"));

        MembersDto membersDto = new MembersDto();

        membersDto.setId(members.getId());
        membersDto.setName(members.getName());
        membersDto.setPreName(members.getPreName());
        membersDto.setEmail(members.getEmail());

        return membersDto;
    }
    @CacheEvict(value = "members", allEntries = true)
    public Members create(Members members) {

        if (membersRepository.existsByEmail(members.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        return membersRepository.save(members);



    }

    public MembersDto update(Long Id, Members members) {

        Members existing = membersRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        existing.setName(members.getName());
        existing.setPreName(members.getPreName());
        existing.setEmail(members.getEmail());

        Members updated = membersRepository.save(existing);


        MembersDto dto = new MembersDto();

        dto.setId(updated.getId());
        dto.setName(updated.getName());
        dto.setPreName(updated.getPreName());
        dto.setEmail(updated.getEmail());

        return dto;
    }

    public void Delete(Long Id) {
        consulter(Id);
        membersRepository.deleteById(Id);


    }


}






//
//    private final List<Members> members =new ArrayList<>(
//            List.of(
//                    new Members(1L,"Sofia","Eyoum","sofiangama@gmail.com"),
//                    new Members(2L,"Lucas","Abwenek","lucasagbor@gmail.com"),
//                        new Members(3L,"Sandra","Bih","sandrabih@gmail.com")
//            )
//    );
//
//    @Cacheable(value ="members")
//    public List<Members> lister() {
//
//
//        try {
//            Thread.sleep(3000); // simulate slow database request
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//
//        System.out.println("Searching database...");
//    return members;
//    }
//
//
//
//    @CacheEvict("members")
//public Members  consulter(Long Id){
//    throw new UnsupportedOperationException("Not implemented yet");
//
//}
//public Members create(Members members)
//{
//    return members;
//}
//
//
//}
