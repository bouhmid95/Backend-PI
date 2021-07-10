package tn.esprit.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;

import tn.esprit.dto.CountOrderByUser;
import tn.esprit.entities.Order;
import tn.esprit.entities.User;
import tn.esprit.services.EmailServiceImpl;
import tn.esprit.services.OrderServiceImpl;
import tn.esprit.util.pdf.PDFGenerator;

@RestController
public class RestControllerOrder {
	
	private static final Logger logger = Logger.getLogger(RestControllerOrder.class);

	@Autowired
	private OrderServiceImpl orderService;
	
	@Autowired
	public PDFGenerator pdfGenerator ;
	
	@Autowired
	private EmailServiceImpl emailService ;
	
	@PostMapping("/addOrder")
	@ResponseBody
	public Order addOrder(@RequestBody Order order) {
		this.orderService.addOrder(order);
		return order ;
	}
	
	@PutMapping("/updateOrder")
	@ResponseBody
	public Order updateOrder(@RequestBody Order order) {
		this.orderService.updateOrder(order);
		return order;
	}
	
	@DeleteMapping(value = "/deleteOrder/{idOrder}")
	public String deleteOrder(@PathVariable("idOrder") int idOrder) {
		this.orderService.deleteOrder(idOrder);
		return "Order N° " + idOrder + " deleted" ;
	}
	
	@GetMapping("/ListOrder")
	public List<Order> findAllOrder() {
		return this.orderService.findAllOrder();
	}
	
	@GetMapping("/findOrderById/{idOrder}")
	public Order findOrderById(@PathVariable("idOrder") Integer idOrder) {
		return this.orderService.findOrder(idOrder);
	}
	
	@GetMapping("/findOrderByUser/{idUser}")
	public List<Order> findOrderByUser(@PathVariable("idUser") Integer idUser) {
		return this.orderService.findOrderByUserCriteria(idUser);
	}
	
	@GetMapping("/findOrderNumberForUser")
	public List<CountOrderByUser> findOrderByUser() {
		return this.orderService.findNumberOrderForUser();
	}
	
	@RequestMapping("/downloadOrderFile") 
	public String method(HttpServletResponse response){
        try {
        
        this.pdfGenerator.generatePdfReport();
        String fileName = this.pdfGenerator.getPdfNameWithDate();
		byte [] data = Files.readAllBytes(Paths.get(fileName));
        response.setContentType("application/" + "pdf");
        response.addHeader("content-disposition", "attachment; filename=" + fileName);
        response.addHeader("Content-Length", String.valueOf(data.length));
        
        ServletOutputStream sos = response.getOutputStream();
        sos.write(data);
        sos.flush();
        sos.close();
        
        this.emailService.sendSimpleMessage("skander1673@gmail.com", "PDF", "votre doc est généré");
        
        } catch (Exception exception) {
        		exception.printStackTrace();
        }
        
		return "" ;
	}

}
