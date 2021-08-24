package choi.seowon.board.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity //db 테이블과 매핑되는 객체
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	private String nickname;
	
	@Column(length = 50)
	private String title;
	
	@Column(length = 2048)
	private String content;
	
	private LocalDateTime created_at;
	
	@Builder
	public Board(Long id, String nickname, String title, String content) {
		this.id = id;
		this.nickname = nickname;
		this.title = title;
		this.content = content;
		
	}

}
