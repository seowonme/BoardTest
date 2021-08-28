package teamD.publicParking.user.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=20, nullable=false)
	private String userEmail;
	
	@Column(length = 100, nullable = false)
	private String userPassword;
	
	@Column(length = 10, nullable = false)
	private String userNickname;
	
	@Builder
	public Member(Long id, String userEmail, String userPassword, String userNickname) {
		this.id = id;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
	}
	
	
}
