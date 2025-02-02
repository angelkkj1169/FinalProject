package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dao.BasketDAO;
import com.project.dto.BasketDTO;
import com.project.dto.MemberDTO;
import com.project.dto.ShopBoardDTO;
import com.project.service.BasketService;
import com.project.service.ShopBoardService;

@Controller
@RequestMapping("/Basket")
public class BasketController {

	@Autowired
	private BasketDAO dao;
	@Autowired
	private BasketService bservice;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private ShopBoardService sService;
	@Autowired
	private HttpSession session;

	@RequestMapping("/basketInsert") // 샵 시퀀스
	public String basketInsert(String seq, String quantity) {
		int result_seq = Integer.parseInt(seq);
		int result_quantity = Integer.parseInt(quantity); // 수량
		ShopBoardDTO sdto = sService.ShopBoardIdSelect(result_seq);
		sdto.setShop_quantity(result_quantity);
		String id = ((MemberDTO) session.getAttribute("id")).getMember_id();
		int price = sdto.getShop_price();//금액
		int totalPrice = result_quantity*price; //수량 합계 금액
		String seller = sdto.getShop_id();
		sdto.setShop_price(totalPrice);
		sdto.setShop_id(id);
		sdto.setShop_contents(seller);
		dao.basketInsert(sdto);
		List<BasketDTO> result = bservice.basketIdSelect(id);
		request.setAttribute("list", result);
		request.setAttribute("sdto", sdto);
		return "redirect:/Basket/basketList?id="+id;
	}

	@RequestMapping("/basketList")
	public String basketSelectProc(String id) {
		List<BasketDTO> result = bservice.basketIdSelect(id);
		request.setAttribute("list", result);
		return "/shopBoard/shopBoard_basket";
	}

	@RequestMapping("/basketDelete")
	public String deleteProc(String basket_seq) {
		int seq = Integer.parseInt(basket_seq);
		int deleteseq = dao.basketDelete(seq);
		MemberDTO mdto = (MemberDTO) session.getAttribute("id");
		String id = mdto.getMember_id();
		List<BasketDTO> result = bservice.basketIdSelect(id);
		request.setAttribute("list", result);
		return "/shopBoard/shopBoard_basket";
	}
	
	@RequestMapping("/asd")
	public String asd(String basket_seq) {
		int price = 0;
		int amount = 0;
		String seq = basket_seq;
		String[] seqList = seq.split(",");
		List<BasketDTO> arr = new ArrayList();
		for(int i = 0 ; i < seqList.length ; i ++) {
			 arr.add(bservice.basketListBuy(seqList[i]));
			 price = price + arr.get(i).getBasket_price();//합계금액
			 amount = amount + arr.get(i).getBasket_quantity();//합계 수량
		}
		request.setAttribute("amount",amount );
		request.setAttribute("basketseq", basket_seq);
		request.setAttribute("basketarr", arr);
		request.setAttribute("price", price);
		return "/shopBoard/shopBoard_buy2";
	}
}
