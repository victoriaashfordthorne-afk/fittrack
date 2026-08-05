package MbemX.example.FitTrack.Mapping;

import MbemX.example.FitTrack.Dto.MembersDto;
import MbemX.example.FitTrack.Entity.Members;


public class MembersMapper {
    public static MembersDto versDto(Members members) {
        MembersDto membersDto = new MembersDto();
        membersDto.setId(members.getId());
        membersDto.setName(members.getName());
        membersDto.setPreName(members.getPreName());
        membersDto.setEmail(members.getEmail());
        return membersDto;
    }


public static Members ToEntite(CreateMembersRequest request) {
        Members members = new Members();

        members.setName(members.getName());
        members.setPreName(members.getPreName());
        members.setEmail(members.getEmail());
        return members;

    }

}
