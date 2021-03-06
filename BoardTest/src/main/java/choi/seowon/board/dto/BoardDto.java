package choi.seowon.board.dto;

import java.time.LocalDateTime;

import choi.seowon.board.domain.Entity.BoardEntity;
import choi.seowon.board.domain.Entity.enums.BoardType;
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
	
	private Long board_id;
	private String nickname;
	private String title;
	private String content;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private LocalDateTime created_at;
	private LocalDateTime modified_at;
	private BoardType boardType;
	
	/*public BoardEntity toEntity() {
		BoardEntity build = BoardEntity.builder()
				.board_id(board_id)
				.nickname(nickname)
				.title(title)
				.content(content)
				.boardType(boardType)
				.build();
		return build;
	}*/
	
	public BoardEntity toEntity() {
		BoardEntity boardEntity = BoardEntity.builder()
				.board_id(board_id)
				.nickname(nickname)
				.title(title)
				.content(content)
				.boardType(boardType)
				.build();
		return boardEntity;
   }
	
	@Builder
	public BoardDto(Long board_id, String nickname, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate, BoardType boardType) {
		this.board_id = board_id;
		this.nickname = nickname;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.boardType = boardType;
	}
	
}
