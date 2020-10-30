package com.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.dao.ReimbursementDao;
import com.web.model.Reimburse;
import com.web.service.ReimbursementService;

public class ReimbursementDataController {
		private ReimbursementService rs;
		SessionController ses;
		static ReimbursementDao dao;

		public ReimbursementDataController(ReimbursementService us) {
			super();
			this.rs = rs;
		}

		public ReimbursementDataController() {
			this(new ReimbursementService());
		}
		
		
		
		public void findAllById(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
			rs = new ReimbursementService();
			res.setContentType("text/json");
			ses = new SessionController();
			int id = ses.getSessionUser(req).getUserId();
			List<Reimburse> list = rs.findAllById(id);
			res.getWriter().println(new ObjectMapper().writeValueAsString(list));
		}
		
		public void findAlPending(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
			rs = new ReimbursementService();
			res.setContentType("text/json");
			ses = new SessionController();
			List<Reimburse> list = rs.findAllByStatus("pending");
			res.getWriter().println(new ObjectMapper().writeValueAsString(list));
		}
		
		public void DeleteReimb(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
			rs = new ReimbursementService();
			res.setContentType("text/json");
			try {
				//System.out.println(req.getInputStream().read());
				Reimburse r = new ObjectMapper().readValue(req.getInputStream(), Reimburse.class);
				System.out.println(r);
				int result = rs.deny(r.getReimb_id());
			     System.out.println(r.getReimb_id());
			} catch (IOException e) {
				e.printStackTrace();
				res.getWriter().println("hghg");
			}
		}
		
		public void ApproveReimb(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
			rs = new ReimbursementService();
			res.setContentType("text/json");
			try {
				//System.out.println(req.getInputStream().read());
				Reimburse r = new ObjectMapper().readValue(req.getInputStream(), Reimburse.class);
				System.out.println(r);
				int result = rs.approve(r.getReimb_id());
			     System.out.println(r.getReimb_id());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		


	}


