package choi.seowon.board.dto;

import choi.seowon.board.domain.Board;
import java.time.LocalDateTime;

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
	
	public Board toEntity() {
		Board build = Board.builder()
				.id(id)
				.nickname(nickname)
				.title(title)
				.content(content)
				.build();
		return build;
   }
	
	@Builder
	public BoardDto(Long id, String nickname, String title, String content, LocalDateTime created_at) {
		this.id = id;
		this.nickname = nickname;
		this.title = title;
		this.content = content;
		this.created_at = created_at;
	}

}
