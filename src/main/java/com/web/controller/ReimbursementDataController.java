package com.web.controller;

import java.io.IOException;
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
			// int id = ses.getSessionUser(req).getUserId();
			List<Reimburse> list = rs.findAllById(1);
			res.getWriter().println(new ObjectMapper().writeValueAsString(list));
		}
		


	}


