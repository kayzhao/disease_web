package com.csu.bio.controller.data;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.csu.bio.frame.dao.CommonNoSqlMongoFSDao;
import com.csu.bio.object.model.*;
import com.csu.bio.service.data.DataService;
import com.csu.bio.service.network.NetworkService;
import com.csu.bio.util.CytoVisual;

/**
 *
 * @author kayzhao
 * @version 2016年12月25日
 */

@Controller
public class NetController {
	private final Logger logger = Logger.getLogger(NetController.class);

	@Autowired
	public DataService rs;

	@Autowired
	public NetworkService ns;

	@Autowired
	CommonNoSqlMongoFSDao cFsDao;

	@RequestMapping("/net")
	public ModelAndView index(ModelMap model) {
		return new ModelAndView("network/index");
	}

	@ResponseBody
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

	@RequestMapping(value = "/net/show/d2d", method = RequestMethod.POST)
	public String showNetworkD2D(HttpServletRequest request, String type, String inputData,
			RedirectAttributes attributes, ModelMap model) throws Exception {
		List<String> datasets;
		if (inputData == null || inputData.length() == 0) {
			attributes.addFlashAttribute("errorInfo", "Error Search Text or Type");
			return "redirect:/net";
		}
		datasets = Arrays.asList(inputData.split("\r\n"));
		if (datasets == null || datasets.size() == 0) {
			attributes.addFlashAttribute("errorInfo", "Error Search Text or Type");
			return "redirect:/net";
		}
		// remove length=0 elements
		ArrayList<String> ids = new ArrayList<String>();
		for (int i = 0; i < datasets.size(); i++) {
			if (datasets.get(i) != null && datasets.get(i).length() > 0)
				ids.add(datasets.get(i));
		}

		// get data
		// get the mapping ids
		Map map = ns.getRelationshipData(ids, UMLSREL.class);
		// get the error disease ids
		ArrayList<Object> errorids = new ArrayList<>();
		if (map.get("errorids") != null) {
			for (String id : ((String) map.get("errorids")).split(",")) {
				errorids.add(id);
			}
			map.remove("errorids");
		}

		model.addAttribute("net", CytoVisual.Net2Json(map));
		return "network/show";
	}

	@RequestMapping(value = "/net/show/d2t", method = RequestMethod.POST)
	public String showNetworkD2T(HttpServletRequest request, String type, String inputData,
			RedirectAttributes attributes, ModelMap model) throws Exception {
		List<String> datasets;
		if (inputData == null || inputData.length() == 0) {
			attributes.addFlashAttribute("errorInfo", "Error Search Text or Type");
			return "redirect:/net";
		}
		datasets = Arrays.asList(inputData.split("\r\n"));
		if (datasets == null || datasets.size() == 0) {
			attributes.addFlashAttribute("errorInfo", "Error Search Text or Type");
			return "redirect:/net";
		}
		// remove length=0 elements
		ArrayList<String> ids = new ArrayList<String>();
		for (int i = 0; i < datasets.size(); i++) {
			if (datasets.get(i) != null && datasets.get(i).length() > 0)
				ids.add(datasets.get(i));
		}

		// get data
		// get the mapping ids
		Map map = ns.getRelationshipData(ids, UMLSREL.class);
		// get the error disease ids
		ArrayList<Object> errorids = new ArrayList<>();
		if (map.get("errorids") != null) {
			for (String id : ((String) map.get("errorids")).split(",")) {
				errorids.add(id);
			}
			map.remove("errorids");
		}

		model.addAttribute("net", CytoVisual.Net2Json(map));
		return "network/show";
	}

	@RequestMapping(value = "/net/show/dim", method = RequestMethod.POST)
	public String showNetworkDIM(HttpServletRequest request, String type, String inputData,
			RedirectAttributes attributes, ModelMap model) throws Exception {
		List<String> datasets;
		if (inputData == null || inputData.length() == 0) {
			attributes.addFlashAttribute("errorInfo", "Error Search Text or Type");
			return "redirect:/net";
		}
		datasets = Arrays.asList(inputData.split("\r\n"));
		if (datasets == null || datasets.size() == 0) {
			attributes.addFlashAttribute("errorInfo", "Error Search Text or Type");
			return "redirect:/net";
		}
		// remove length=0 elements
		ArrayList<String> ids = new ArrayList<String>();
		for (int i = 0; i < datasets.size(); i++) {
			if (datasets.get(i) != null && datasets.get(i).length() > 0)
				ids.add(datasets.get(i));
		}

		// get data
		// get the mapping ids
		Map map = ns.getRelationshipData(ids, DisMap.class);
		// get the error disease ids
		ArrayList<Object> errorids = new ArrayList<>();
		if (map.get("errorids") != null) {
			for (String id : ((String) map.get("errorids")).split(",")) {
				errorids.add(id);
			}
			map.remove("errorids");
		}
		model.addAttribute("errorids", errorids);
		if (map.isEmpty() || map.size() == 0) {
			attributes.addFlashAttribute("errorInfo", "No data to visualize");
			return "redirect:/net";
		}
		model.addAttribute("net", CytoVisual.Net2Json(map));
		return "network/show";
	}
}
