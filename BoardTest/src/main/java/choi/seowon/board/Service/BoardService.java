package choi.seowon.board.Service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import choi.seowon.board.domain.Board;
import choi.seowon.board.domain.Repository.BoardRepository;
import choi.seowon.board.dto.BoardDto;

@Service
public class BoardService {
	private BoardRepository boardRepository;
	private static final int BLOCK_PAGE_NUM_COUNT = 5; //블럭에 존재하는 페이지 수
	private static final int PAGE_POST_COUNT = 4; //한 페이지에 존재하는 게시글 수
	
	public BoardService(BoardRepository boardRepository){
		this.boardRepository = boardRepository;
	}
	
	/*페이징 처리된 게시글 리스트 반환
	public Page<Board> findBoardList(Pageable pageable){
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1, pageable.getPageSize());
		return boardRepository.findAll(pageable);
	}*/
	
	@Transactional
	public Long savePost (BoardDto boardDto) {
		return boardRepository.save(boardDto.toEntity()).getId();
	}
	
	@Transactional
	public List<BoardDto> getBoardList(Integer pageNum){ //게시물의 목록을 가져온다.
		Page<Board> page = boardRepository
				.findAll(PageRequest
						.of(pageNum-1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC,"createdDate")));
		
		//List<Board> boardList = boardRepository.findAll();
		List<Board> boards = page.getContent();
		List<BoardDto> boardDtoList = new ArrayList<>();
		
		for(Board board : boards) {
			BoardDto boardDto = BoardDto.builder()
					.id(board.getId())
					.nickname(board.getNickname())
					.title(board.getTitle())
					.content(board.getContent())
					.created_at(board.getCreated_at())
					.build();
			boardDtoList.add(boardDto);
		}
		return boardDtoList;
	}
	public Integer[] getPageList(Integer curPageNum) {
		Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];
		
		//총 게시글 수
		Double postsTotalCount = Double.valueOf(this.getBoardCount());
		
		//총 게시글 수를 기준으로 계산한 마지막 페이지 번호
		Integer totalLastPageNum = (int)(Math.ceil((postsTotalCount/PAGE_POST_COUNT)));
		
		//현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
		Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
				? curPageNum + BLOCK_PAGE_NUM_COUNT
				: totalLastPageNum;
		
		//페이지 시작 번호 조정
		curPageNum = (curPageNum<=3) ? 1 : curPageNum - 2;
		
		//페이지 번호 할당
		for(int val=curPageNum, i=0; val <= blockLastPageNum; val++, i++) {
			pageList[i] = val;
		}
		return pageList;
	}
	
	@Transactional
	public Long getBoardCount() {
		return boardRepository.count();
	}
	
	
	@Transactional
	public BoardDto getPost(Long id) { //게시글의 id를 받아 해당 게시글의 데이터만 가져와 화면에 뿌림
		Board board = boardRepository.findById(id).get();
		
		BoardDto boardDto = BoardDto.builder()
				.id(board.getId())
				.nickname(board.getNickname())
				.title(board.getTitle())
				.content(board.getContent())
				.created_at(board.getCreated_at())
				.build();
		return boardDto;
	}
	
	@Transactional
	public void deletePost(Long id) {
		boardRepository.deleteById(id);
	}
	

}
