package com.hk.board.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.board.command.DelBoardCommand;
import com.hk.board.command.InsertBoardCommand;
import com.hk.board.command.UpdateBoardCommand;
import com.hk.board.dtos.BoardDto;
import com.hk.board.dtos.FileBoardDto;
import com.hk.board.service.BoardService;
import com.hk.board.service.FileService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private FileService fileService;
	
	@GetMapping(value = "/boardlist")
	public ResponseEntity<Map<String,List<BoardDto>>> boardList(Model model,HttpServletRequest request) {
		System.out.println("글목록 보기");
//		System.out.println("세션:"+request.getSession().getAttribute("mdto"));
//		System.out.println(request.getCookies()[0].getValue());
		List<BoardDto> list=boardService.getAllList();
		model.addAttribute("list", list);
//		model.addAttribute("delBoardCommand", new DelBoardCommand());
		Map<String,List<BoardDto>>map=new HashMap<>();
		map.put("list", list);
		System.out.println(list.get(0));
		return ResponseEntity.ok(map);
	}
	
	@GetMapping(value = "/boardInsert")
	public String boardInsertForm(Model model) {
		model.addAttribute("insertBoardCommand", new InsertBoardCommand());
		return "board/boardInsertForm";
	}
	//글추가하기
	@PostMapping(value = "/boardinsert")
	public String boardInsert(
						//@ModelAttribute: Spring MVC에서 HTTP요청의 데이터를 특정 객체(DTO)에 바인딩하거나, 모델에 데이터를 추가할때사용
			            //                 컨트롤러의 메서드나 매개변수에 사용할 수 있다.
						 @ModelAttribute InsertBoardCommand insertBoardCommand, 
//			                BindingResult result,
							@RequestParam(value="filename", required = false) MultipartFile[] file,
			                MultipartRequest multipartRequest //multipart data를 처리할때 사용
							,HttpServletRequest request
			                ,Model model) throws IllegalStateException, IOException {
//		if(result.hasErrors()) {
//			System.out.println("글을 모두 입력하세요");
//			return "board/boardInsertForm";
//		}
		System.out.println("글추가하기");
		System.out.println("글추가값:"+insertBoardCommand);
		System.out.println(Arrays.toString(file));
		boardService.insertBoard(insertBoardCommand,multipartRequest
				                ,request);
		
		return "redirect:/board/boardList";
	}
	
	//상세보기
	@GetMapping(value = "/boarddetail/{seq}")
	public ResponseEntity<Map<String, BoardDto>> boardDetail(@PathVariable int seq, Model model) {
		System.out.println("상세보기");
		BoardDto dto=boardService.getBoard(seq);
		
		//유효값처리용
//		model.addAttribute("updateBoardCommand", new UpdateBoardCommand());
		//출력용
//		model.addAttribute("dto", dto);
		System.out.println(dto);
		Map<String, BoardDto>map=new HashMap<String, BoardDto>();
		map.put("dto", dto);
		return ResponseEntity.ok(map);
	}
	
	//수정하기
	@PutMapping(value = "/boardupdate")
	public ResponseEntity<String> boardUpdate(
			//@RequestBody는 요청 본문(body)에 포함된 데이터를 json형식으로 읽어서 java객체로 변환해줌
				@RequestBody UpdateBoardCommand updateBoardCommand
//				,BindingResult result
				,Model model) {
		System.out.println("글수정요청");
		System.out.println(updateBoardCommand);
//		if(result.hasErrors()) {
//			System.out.println("수정내용을 모두 입력하세요");
//			//코드 추가--------------------------------------------
//			BoardDto dto=boardService.getBoard(updateBoardCommand.getBoard_seq());
//			model.addAttribute("dto", dto);
//			//--------------------------------------------------
//			return ResponseEntity.badRequest().body("수정내용확인바람");//400코드
//		}
		
		boardService.updateBoard(updateBoardCommand);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("수정 성공");//201코드:요청성공(새로운 리소스 생성 성공)
	}
	
	@GetMapping(value = "/download")
	public void download(int file_seq, HttpServletRequest request
			                         , HttpServletResponse response) throws UnsupportedEncodingException {
		
		FileBoardDto fdto=fileService.getFileInfo(file_seq);//파일정보가져오기
		
		fileService.fileDownload(fdto.getOrigin_filename()
				                ,fdto.getStored_filename()
				                ,request,response);
	}
	
	@DeleteMapping(value="/muldel")
	public ResponseEntity<String> mulDel(@RequestParam String[] seqs
//						@Validated DelBoardCommand delBoardCommand
//						 ,BindingResult result
			             , Model model) {
		System.out.println("글삭제요청");
		System.out.println("삭제할 글 seqs:"+Arrays.toString(seqs));
//		if(result.hasErrors()) {
//			System.out.println("최소하나 체크하기");
//			List<BoardDto> list=boardService.getAllList();
//			model.addAttribute("list", list);
//			return "board/boardlist";
//		}
//		boardService.mulDel(delBoardCommand.getSeq());
		boardService.mulDel(seqs);
		System.out.println("글삭제함");
		return ResponseEntity.status(HttpStatus.CREATED).body("삭제 성공");//201코드:요청성공(새로운 리소스 생성 성공)
	}
}














