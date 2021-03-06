package com.yi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yi.domain.Board;
import com.yi.domain.Criteria;
import com.yi.domain.PageMaker;
import com.yi.domain.Reply;
import com.yi.service.BoardService;
import com.yi.service.ReplyService;

@RestController
@RequestMapping("/replies/*")
public class ReplyController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);

	@Autowired
	private ReplyService service;
	
	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody Reply vo) {
		ResponseEntity<String> entity = null;

		try {
			service.create(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// @PathVariable : 주소에 있는 url 변수를 내 매개변수에 대입시켜준다.
	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<Reply>> list(@PathVariable("bno") int bno) {
		ResponseEntity<List<Reply>> entity = null;

		try {
			List<Reply> list = service.list(bno);
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/{bno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("bno") int bno, @PathVariable("page") int page) {
		ResponseEntity<Map<String, Object>> entity = null;

		try {
			Criteria cri = new Criteria();
			cri.setPage(page);

			List<Reply> list = service.listpage(cri, bno);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);

			int count = service.totalCount(bno);
			pageMaker.setTotalCount(count);
			
			Board boardVO = boardService.read(bno);
			

			HashMap<String, Object> map = new HashMap<>(); // map에 값을 담음
			map.put("list", list);
			map.put("pageMaker", pageMaker);
			map.put("replycnt", boardVO.getReplycnt());
			

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK); // 성공

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 실패
		}

		return entity;

	}

	@RequestMapping(value = "{rno}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("rno") int rno, @RequestBody Reply vo) {
		ResponseEntity<String> entity = null;

		try {
			vo.setRno(rno);
			service.update(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") int rno) {
		ResponseEntity<String> entity = null;

		try {
			service.delete(rno);
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
