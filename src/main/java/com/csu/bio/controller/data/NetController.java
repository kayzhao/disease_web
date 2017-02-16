package com.csu.bio.controller.data;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.csu.bio.frame.dao.CommonNoSqlMongoFSDao;
import com.csu.bio.object.model.*;
import com.csu.bio.service.data.DataService;
import com.csu.bio.util.CytoVisual;

/**
 *
 * @author kayzhao
 * @version 2016年12月25日
 */

@RestController
public class NetController {
	private final Logger logger = Logger.getLogger(NetController.class);

	@Autowired
	public DataService rs;

	@Autowired
	CommonNoSqlMongoFSDao cFsDao;

	@RequestMapping("/net")
	public ModelAndView index(ModelMap model) {
		return new ModelAndView("network/index");
	}

	@RequestMapping(value = "/net/decodepng", method = RequestMethod.POST)
	public String decodePng(HttpSession session, HttpServletResponse response, @RequestParam("png") String png) {
		System.out.println("----DecodePNG----");
		int index = png.indexOf(",");
		png = png.substring((index + 1));
		Base64 base64 = new Base64();
		byte[] decoderBytes = base64.decode(png);
		String status = "ok";
		if (decoderBytes.length > 0)
			session.setAttribute("png", decoderBytes);
		else
			status = "error";
		return status;
	}

	@RequestMapping(value = "/net/downloadpng")
	public void downloadPng(HttpSession session, HttpServletResponse response) {
		System.out.println("----DownloadPNG----");
		byte[] decoderBytes = (byte[]) session.getAttribute("png");
		session.removeAttribute("png");
		response.setContentType("image/png");
		response.addHeader("Content-Disposition", "attachment; filename=net.png");
		OutputStream os;
		try {
			os = response.getOutputStream();
			os.write(decoderBytes);
			os.close();
		} catch (IOException e) {
			System.out.println("DownloadPNG Error!");
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/net/show", method = RequestMethod.POST)
	public ModelAndView showNetwork(HttpServletRequest request, @RequestParam("file") MultipartFile file,
			@RequestParam("inputData") String inputData) {
		List<String> datasets;
		ModelAndView mav = new ModelAndView();
		if (file.isEmpty()) {
			datasets = Arrays.asList(inputData.split("\r\n"));
		} else {
			try {
				datasets = new ArrayList<>();
				Scanner scanner = new Scanner(file.getInputStream());
				while (scanner.hasNextLine()) {
					datasets.add(scanner.nextLine().trim());
				}
				scanner.close();
			} catch (IOException e) {
				datasets = null;
				e.printStackTrace();
			}
		}
		// remove length=0 elements
		ArrayList<String> ids = new ArrayList<String>();
		for (int i = 0; i < datasets.size(); i++) {
			if (datasets.get(i) != null && datasets.get(i).length() > 0)
				ids.add(datasets.get(i));
		}
		mav.addObject("net", CytoVisual.encapsulateNet2Json(datasets));
		mav.setViewName("network/show");
		return mav;
	}
}
