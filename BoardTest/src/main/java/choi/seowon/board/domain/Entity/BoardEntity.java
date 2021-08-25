package choi.seowon.board.domain.Entity;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="board")
@Getter
@Entity //db 테이블과 매핑되는 객체
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@EntityListeners(AuditingEntityListener.class)
public class BoardEntity extends TimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	private String nickname;
	
	@Column(length = 50)
	private String title;
	
	@Column(length = 2048)
	private String content;
	
	//private LocalDateTime created_at;
	
	@Builder
	public BoardEntity(Long id, String nickname, String title, String content) {
		this.id = id;
		this.nickname = nickname;
		this.title = title;
		this.content = content;
		
	}

	
}
