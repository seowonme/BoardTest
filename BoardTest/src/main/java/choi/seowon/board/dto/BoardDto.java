package choi.seowon.board.dto;

import java.time.LocalDateTime;

import choi.seowon.board.domain.Entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto { //Controller와 Service사이에서 데이터 주고받기
	
	private Long id;
	private String nickname;
	private String title;
	private String content;
	private LocalDateTime created_at;
	private LocalDateTime modified_at;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	public BoardEntity toEntity() {
		BoardEntity board = BoardEntity.builder()
				.id(id)
				.nickname(nickname)
				.title(title)
				.content(content)
				.build();
		return board;
   }
	
	@Builder
	public BoardDto(Long id, String nickname, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
		this.id = id;
		this.nickname = nickname;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

}
