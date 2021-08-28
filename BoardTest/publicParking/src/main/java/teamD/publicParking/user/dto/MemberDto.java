package teamD.publicParking.user.dto;

import java.time.LocalDateTime;

import teamD.publicParking.user.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {

	private Long id;
	private String userEmail;
	private String userPassword;
	private String userNickname;
	private LocalDateTime createdDate;
	private LocalDateTime modifideDate;
	
	public Member toEntity() {
		return Member.builder()
                .id(id)
                .userEmail(userEmail)
                .userPassword(userPassword)
                .userNickname(userNickname)
                .build();
	}
	
	@Builder
	public MemberDto(Long id, String userEmail, String userPassword, String userNickname) {
		this.id = id;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
				
	}
	
}
